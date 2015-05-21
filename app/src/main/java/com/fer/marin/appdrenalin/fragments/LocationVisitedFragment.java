package com.fer.marin.appdrenalin.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.UsersListAdapter;

import java.util.ArrayList;
import java.util.List;


public class LocationVisitedFragment extends Fragment {

    ListView usersVisited;
    UsersListAdapter adapter;
    List<Integer> images = new ArrayList<>();
    List<String> names = new ArrayList<>();

    public static LocationVisitedFragment newInstance() {
        LocationVisitedFragment fragment = new LocationVisitedFragment();
        return fragment;
    }

    public LocationVisitedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = inflater.inflate(R.layout.fragment_location_visited, container, false);
        usersVisited = (ListView) vi.findViewById(R.id.visited_list);
        setData();
        adapter = new UsersListAdapter(getActivity(), images);
        adapter.addAll(names);
        usersVisited.setAdapter(adapter);
        return vi;
    }

    private void setData(){
        for (int i = 0; i < 5; i++){
            images.add(R.drawable.marjan2);
            images.add(R.drawable.neo);
            images.add(R.drawable.velebit2);

            names.add("Korisnik " + i);
            names.add("User" + i);
            names.add("Covjek" + i);
        }
    }

}
