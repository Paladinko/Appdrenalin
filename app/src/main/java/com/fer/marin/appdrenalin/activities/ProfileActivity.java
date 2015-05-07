package com.fer.marin.appdrenalin.activities;

import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.DrawerAdapter;
import com.fer.marin.appdrenalin.adapters.ProfilePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends ActionBarActivity {

    PagerSlidingTabStrip tabHost;
    ViewPager pager;
    int menuIcons[] = {R.drawable.user_icon, R.drawable.world_icon, R.drawable.sports_icon, R.drawable.event_icon, R.drawable.followers_icon, R.drawable.settings_icon};
    String menuItems[] = {"Profile", "Locations", "Sports", "Events", "Following", "Settings"};
    String NAME = "Marin Bulatović";
    String EMAIL = "marin_bulatovic@hotmail.com";
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        toolbar = (Toolbar) findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);
        setTitle("Marin Bulatović");
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary_yellow));

        tabHost = (PagerSlidingTabStrip) this.findViewById(R.id.materialTabHost);
        pager = (ViewPager) this.findViewById(R.id.profile_view_pager);
        ProfilePagerAdapter pagerAdapter = new ProfilePagerAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(pagerAdapter);
        tabHost.setViewPager(pager);
        tabHost.setIndicatorColor(getResources().getColor(R.color.primary_yellow));
        tabHost.setShouldExpand(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new DrawerAdapter(this, menuItems, menuIcons, NAME, EMAIL);

        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.drawer_open, R.string.drawer_close){
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

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
