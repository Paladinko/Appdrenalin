package com.fer.marin.appdrenalin.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fer.marin.appdrenalin.R;

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
        String[] exp = new String[]{"5 years", "1 year", "4 years", "6 months", "2 years"};
        int[] icons = new int[]{R.drawable.cycling_icon, R.drawable.mountaineering,
                R.drawable.scuba_diving_icon, R.drawable.skydiving_icon, R.drawable.skiing_icon};
        lvProfileSports.setAdapter(new ProfileDetailAdapter(getActivity(), sports, exp, icons));
        return rootView;
    }

}

class ProfileDetailAdapter extends BaseAdapter {

    Context context;
    LayoutInflater mInflater = null;
    String[] sports, experience;
    int[] sportIcons;

    public ProfileDetailAdapter(Context context, String[] _sports, String[] _exp, int[] _sportIcons){
        this.context = context;
        this.sports = _sports;
        this.experience = _exp;
        this.sportIcons = _sportIcons;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sports.length;
    }

    @Override
    public Object getItem(int position) {
        return sports[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = mInflater.inflate(R.layout.profile_detail_row, null);
        }
        TextView title = (TextView) vi.findViewById(R.id.profile_detail_sport_title);
        title.setText(sports[position]);
        TextView exp = (TextView) vi.findViewById(R.id.profile_detail_sport_exp);
        exp.setText(experience[position]);
        ImageView img = (ImageView) vi.findViewById(R.id.profile_detail_sport_icon);
        img.setImageResource(sportIcons[position]);
        return vi;
    }
}
