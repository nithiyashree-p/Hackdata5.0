package com.example.learngeo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.learngeo.R;
import com.example.learngeo.fragments.ViewLink;

import java.util.ArrayList;

import io.github.ponnamkarthik.richlinkpreview.MetaData;
import io.github.ponnamkarthik.richlinkpreview.RichLinkViewTwitter;
import io.github.ponnamkarthik.richlinkpreview.ViewListener;


public class LinkAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> urls;
    ArrayList<MetaData> metaData = new ArrayList<>();
    public static String selectedUrl;

    public LinkAdapter(Context context, ArrayList<String> urls) {
        this.context = context;
        this.urls = urls;
        for (int i = 0; i < urls.size(); i++) {
            metaData.add(null);
        }
    }

    @Override
    public int getCount() {
        return ((urls == null) ? 0 : urls.size());
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public static class ViewHolder {
        RichLinkViewTwitter richLinkView;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.course_row, viewGroup, false);
            viewHolder.richLinkView = view.findViewById(R.id.richLinkView);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (urls.get(i) != null) {
            final String url = urls.get(i);
            if (metaData.get(i) != null) {
                viewHolder.richLinkView.setLinkFromMeta(metaData.get(i));
            } else {
                viewHolder.richLinkView.setLink(url, new ViewListener() {
                    @Override
                    public void onSuccess(boolean status) {
                        try {
                            metaData.set(i, viewHolder.richLinkView.getMetaData());
                        } catch (IndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
            viewHolder.richLinkView.setDefaultClickListener(false);
            viewHolder.richLinkView.setClickListener((view1, meta) -> {
                selectedUrl = meta.getUrl();
                FragmentManager fragmentManager = ((FragmentActivity) view1.getContext()).getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home,new ViewLink(),"link");
                fragmentTransaction.commit();
            });
        }
        return view;
    }

}