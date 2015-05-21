package com.fer.marin.appdrenalin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.LocationCommentAdapter;

import java.util.ArrayList;
import java.util.List;

public class LocationDetailFragment extends Fragment {

    ListView locationComments;
    LocationCommentAdapter adapter;
    List<String> comments = new ArrayList<>();
    List<Integer> images = new ArrayList<>();

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
        View rootView = inflater.inflate(R.layout.fragment_location_detail, container, false);
        locationComments = (ListView) rootView.findViewById(R.id.location_comments);
        View header = inflater.inflate(R.layout.location_comment_header, null);
        locationComments.addHeaderView(header);

        setData();
        adapter = new LocationCommentAdapter(getActivity(), images);
        adapter.addAll(comments);
        locationComments.setAdapter(adapter);
        return rootView;
    }

    private void setData(){
        comments.add("Prvi");
        comments.add("Brale predobra lokacija sta je ovo");
        comments.add("AJMOOOOOOOOOOOOOOOO");
        comments.add("Dobar dan braco");

        images.add(R.drawable.marjan);
        images.add(R.drawable.neo);
        images.add(R.drawable.marjan);
        images.add(R.drawable.neo);
    }

}
