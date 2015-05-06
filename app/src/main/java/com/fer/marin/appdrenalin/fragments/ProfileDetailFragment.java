package com.fer.marin.appdrenalin.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.ProfileDetailAdapter;

import java.util.List;

public class ProfileDetailFragment extends Fragment {

    public static ProfileDetailFragment newInstance() {
        ProfileDetailFragment fragment = new ProfileDetailFragment();
        return fragment;
    }

    public ProfileDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_detail, container, false);
        ListView lvProfileSports = (ListView) rootView.findViewById(R.id.profile_sports_list);
        String[] sports = new String[]{"Cycling", "Mountaineering", "Scuba diving", "Skydiving", "Skiing"};
        int[] icons = new int[]{R.drawable.cycling_icon, R.drawable.mountaineering,
                R.drawable.scuba_diving_icon, R.drawable.skydiving_icon, R.drawable.skiing_icon};
        ProfileDetailAdapter adapter = new ProfileDetailAdapter(getActivity(), icons, false);
        lvProfileSports.setAdapter(adapter);
        adapter.addAll(sports);

        return rootView;
    }

}


