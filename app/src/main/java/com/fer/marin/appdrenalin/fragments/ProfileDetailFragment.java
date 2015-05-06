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

import com.fer.marin.appdrenalin.R;

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
        lvProfileSports.setAdapter(new ProfileDetailAdapter(getActivity(), sports, icons));
        return rootView;
    }

}

class ProfileDetailAdapter extends ArrayAdapter<String> {

    Context context;
    LayoutInflater mInflater = null;

    public ProfileDetailAdapter(Context context, List<String> sports){
        super(context, R.layout.profile_detail_row, R.id.profile_detail_sport_title);
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = mInflater.inflate(R.layout.profile_detail_row, null);
        }
        TextView title = (TextView) vi.findViewById(R.id.profile_detail_sport_title);
        title.setText(sports[position]);
        ImageView img = (ImageView) vi.findViewById(R.id.profile_detail_sport_icon);
        img.setImageResource(sportIcons[position]);
        return vi;
    }

    private static class SportsViewHolder{
        private TextView textView;
        private ImageView imageView;
        private CheckBox checkBox;

        public SportsViewHolder(ImageView imageView, TextView textView, CheckBox checkBox){
            this.textView = textView;
            this.imageView = imageView;
            this.checkBox = checkBox;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }
    }
}
