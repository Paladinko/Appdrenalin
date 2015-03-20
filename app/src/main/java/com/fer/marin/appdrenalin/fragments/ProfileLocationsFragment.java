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

class ProfileLocationsAdapter extends BaseAdapter {

    Context context;
    LayoutInflater mInflater = null;
    String[] locations;
    int[] locationImages;
    HashMap<String, int[]> locationSports;

    public ProfileLocationsAdapter(Context context, String[] _locations, int[] _locationImages, HashMap<String, int[]> _sports){
        this.context = context;
        this.locations = _locations;
        this.locationImages = _locationImages;
        this.locationSports = _sports;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return locations.length;
    }

    @Override
    public Object getItem(int position) {
        return locations[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = mInflater.inflate(R.layout.profile_locations_row, null);
        }
        TextView title = (TextView) vi.findViewById(R.id.profile_location_title);
        title.setText(locations[position]);
        ImageView img = (ImageView) vi.findViewById(R.id.profile_location_image);
        img.setImageResource(locationImages[position]);
        LinearLayout picLL = (LinearLayout) vi.findViewById(R.id.ll_profile_location_title);
        picLL.removeAllViews();
        int[] sports = locationSports.get(locations[position]);
        for (int i = 0; i < sports.length; i++){
            ImageView sportsImage = new ImageView(context);
            sportsImage.setImageResource(sports[i]);
            picLL.addView(sportsImage);
        }
        return vi;
    }
}
