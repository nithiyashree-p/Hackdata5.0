package com.example.learngeo.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learngeo.R;
import com.google.android.material.card.MaterialCardView;

public class Events extends Fragment {
    Context mContext;
    MaterialCardView materialCardView1, materialCardView2, materialCardView3;

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
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialCardView1 = view.findViewById(R.id.cardView1);
        materialCardView2 = view.findViewById(R.id.cardView2);
        materialCardView3 = view.findViewById(R.id.cardView3);

        materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment("https://www.competitionsciences.org/2017/12/18/the-best-environmental-competitions-for-your-students/");
            }
        });
        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment("https://10times.com/india/waste-management");
            }
        });
        materialCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment("https://www.nelda.org.in/blog/category/how-you-can-help/5-notable-tree-plantation-ngos-in-india#:~:text=Project%20Green%20Hands,million%20trees%20across%20Tamil%20Nadu.");
            }
        });
    }
    public void openFragment(String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home, new ViewLink(), tag);
        fragmentTransaction.commit();
    }
}