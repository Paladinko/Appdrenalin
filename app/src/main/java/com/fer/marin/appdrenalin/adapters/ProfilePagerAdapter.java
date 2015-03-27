package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fer.marin.appdrenalin.fragments.ProfileDetailFragment;
import com.fer.marin.appdrenalin.fragments.ProfileLocationsFragment;
import com.fer.marin.appdrenalin.fragments.ProfilePicturesFragment;

/**
 * Created by Marin on 20/03/2015.
 */
public class ProfilePagerAdapter extends FragmentPagerAdapter{
    Context mContext;

    public ProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = ProfileDetailFragment.newInstance();
                break;
            case 1:
                fragment = ProfileLocationsFragment.newInstance();
                break;
            case 2:
                fragment = ProfilePicturesFragment.newInstance();
                break;
            default:
                fragment = ProfileDetailFragment.newInstance();
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
                return "PROFILE";
            case 1:
                return "LOCATIONS";
            case 2:
                return "PICTURES";
        }

        return null;
    }
}
