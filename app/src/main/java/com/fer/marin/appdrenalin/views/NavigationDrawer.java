package com.fer.marin.appdrenalin.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.DrawerAdapter;

/**
 * Created by Marin on 15/05/2015.
 */
public class NavigationDrawer {

    Context context;
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    Activity activity;

    String NAME = "Marin Bulatović";
    String EMAIL = "marin_bulatovic@hotmail.com";

    int menuIcons[] = {R.drawable.user_icon, R.drawable.world_icon, R.drawable.sports_icon, R.drawable.event_icon, R.drawable.followers_icon, R.drawable.settings_icon};
    String menuItems[] = {"Profile", "Locations", "Sports", "Events", "Following", "Settings"};

    public NavigationDrawer(Activity activity,Toolbar toolbar, RecyclerView recyclerView, DrawerLayout drawer){
        this.activity = activity;
        this.toolbar = toolbar;
        this.mRecyclerView = recyclerView;
        this.Drawer = drawer;

        mRecyclerView.setHasFixedSize(true);
        mAdapter = new DrawerAdapter(activity, menuItems, menuIcons, NAME, EMAIL);

        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDrawerToggle = new ActionBarDrawerToggle(activity, Drawer, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    public void syncState(){
        mDrawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration newConfig){
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}
