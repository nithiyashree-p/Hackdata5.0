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

public class Contribution extends Fragment {

    Context mContext;
    MaterialCardView materialCardView1, materialCardView2, materialCardView3, materialCardView4,materialCardView5,materialCardView6,materialCardView7;

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
        return inflater.inflate(R.layout.fragment_contribution, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialCardView1=view.findViewById(R.id.cardView1);
        materialCardView2=view.findViewById(R.id.cardView2);
        materialCardView3=view.findViewById(R.id.cardView3);
        materialCardView4=view.findViewById(R.id.cardView4);
        materialCardView5=view.findViewById(R.id.cardView5);
        materialCardView6=view.findViewById(R.id.cardView6);
        materialCardView7=view.findViewById(R.id.cardView7);

        materialCardView1.setOnClickListener(view1 -> openFragment("https://www.carbonfootprint.com/calculator.aspx"));
        materialCardView2.setOnClickListener(view14 -> openFragment("https://cotap.org/reduce-carbon-footprint/"));
        materialCardView3.setOnClickListener(view12 -> openFragment("https://davidsuzuki.org/what-you-can-do/top-10-ways-can-stop-climate-change/"));
        materialCardView4.setOnClickListener(view13 -> openFragment("https://www.funkidslive.com/learn/marina-ventura/climate-explorers/"));
        materialCardView5.setOnClickListener(view15 -> openFragment("https://www.conserve-energy-future.com/stopglobalwarming.php"));
        materialCardView6.setOnClickListener(view16 -> openFragment("https://treefoundation.org/10-things-you-can-do-to-save-forests/"));
        materialCardView7.setOnClickListener(view17 -> openFragment("https://www.circlewaste.co.uk/2020/09/16/what-are-the-5-rs-of-waste-management/"));
    }

    public void openFragment(String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home, new ViewLink(), tag);
        fragmentTransaction.commit();
    }
}