package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fer.marin.appdrenalin.fragments.LocationDetailFragment;
import com.fer.marin.appdrenalin.fragments.LocationMapFragment;
import com.fer.marin.appdrenalin.fragments.LocationVisitedFragment;
import com.fer.marin.appdrenalin.fragments.ProfileDetailFragment;
import com.fer.marin.appdrenalin.fragments.ProfileLocationsFragment;
import com.fer.marin.appdrenalin.fragments.ProfilePicturesFragment;

/**
 * Created by Marin on 15/05/2015.
 */
public class LocationPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    public LocationPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = LocationMapFragment.newInstance();
                break;
            case 1:
                fragment = LocationDetailFragment.newInstance();
                break;
            case 2:
                fragment = LocationVisitedFragment.newInstance();
                break;
            default:
                fragment = LocationDetailFragment.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "KARTA";
            case 1:
                return "KOMENTARI";
            case 2:
                return "POSJETILI";
        }

        return null;
    }
}
