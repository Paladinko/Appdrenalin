package com.fer.marin.appdrenalin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fer.marin.appdrenalin.R;

public class LocationDetailFragment extends Fragment {

    public static LocationDetailFragment newInstance() {
        LocationDetailFragment fragment = new LocationDetailFragment();
        return fragment;
    }

    public LocationDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detail, container, false);
    }

}
