package com.fer.marin.appdrenalin.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.ProfileLocationsAdapter;

import java.util.HashMap;


public class ProfileLocationsFragment extends Fragment {

    public static ProfileLocationsFragment newInstance() {
        ProfileLocationsFragment fragment = new ProfileLocationsFragment();
        return fragment;
    }

    public ProfileLocationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_locations, container, false);
        ListView lvProfileLocations = (ListView) rootView.findViewById(R.id.profile_locations_list);
        String[] locations = new String[]{"Marjan", "Sljeme", "Velebit"};
        int[] images = new int[]{R.drawable.marjan, R.drawable.sljeme, R.drawable.velebit};
        HashMap<String, int[]> sports = new HashMap<>();
        int[] marjan = new int[]{R.drawable.cycling_icon, R.drawable.scuba_diving_icon};
        int[] sljeme = new int[]{R.drawable.cycling_icon, R.drawable.skiing_icon, R.drawable.mountaineering};
        int[] velebit = new int[]{R.drawable.mountaineering, R.drawable.skiing_icon, R.drawable.rafting_icon, R.drawable.cycling_icon};
        sports.put("Marjan", marjan);
        sports.put("Sljeme", sljeme);
        sports.put("Velebit", velebit);
        lvProfileLocations.setAdapter(new ProfileLocationsAdapter(getActivity(),  locations, images, sports));
        return rootView;
    }

}
