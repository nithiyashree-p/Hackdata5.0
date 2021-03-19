package com.example.learngeo.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learngeo.R;
import com.example.learngeo.adapter.BackPressedListener;
import com.example.learngeo.adapter.LinkAdapter;
import com.example.learngeo.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.learngeo.HomePage.progressDialog;

public class News extends Fragment implements BackPressedListener {
    Context mContext;
    ListView listView;
    LinkAdapter urlAdapter;
    ArrayList<String> links = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.list);
        getData();
    }


    @Override
    public void onBackPressed() {
        links.clear();
        urlAdapter.notifyDataSetChanged();
    }
    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, config.MAIN__URL+"news.json",
                ServerResponse -> {
                    // Matching server response message to our text.
                    Log.e("Response ", ServerResponse);
                    try {
                        JSONObject object = new JSONObject(ServerResponse);
                        JSONArray link = object.getJSONArray("links");
                        for (int i = 0; i < link.length(); i++) {
                            links.add(link.getString(i));
                        }
                        urlAdapter = new LinkAdapter(mContext, links);
                        listView.setAdapter(urlAdapter);
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (JSONException ignored) {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }

                },
                volleyError -> {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    // Showing error message if something goes wrong.
                    Toast.makeText(mContext, volleyError.toString(), Toast.LENGTH_LONG).show();
                    Log.e("error", volleyError.toString());
                });
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }

}