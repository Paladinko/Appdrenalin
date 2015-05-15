package com.fer.marin.appdrenalin.activities;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
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

import com.astuetz.PagerSlidingTabStrip;
import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.DrawerAdapter;
import com.fer.marin.appdrenalin.adapters.LocationPagerAdapter;
import com.fer.marin.appdrenalin.adapters.ProfilePagerAdapter;
import com.fer.marin.appdrenalin.views.NavigationDrawer;

public class LocationActivity extends ActionBarActivity {

    PagerSlidingTabStrip tabHost;
    ViewPager pager;
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    DrawerLayout Drawer;
    NavigationDrawer navigationDrawer;

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        toolbar = (Toolbar) findViewById(R.id.toolbarLocation);
        setSupportActionBar(toolbar);
        setTitle("Marjan");
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary_yellow));

        tabHost = (PagerSlidingTabStrip) this.findViewById(R.id.tabHostLocation);
        pager = (ViewPager) this.findViewById(R.id.location_view_pager);

        fragmentManager = getSupportFragmentManager();

        LocationPagerAdapter pagerAdapter = new LocationPagerAdapter(fragmentManager, this);
        pager.setAdapter(pagerAdapter);
        tabHost.setViewPager(pager);
        tabHost.setIndicatorColor(getResources().getColor(R.color.primary_yellow));
        tabHost.setShouldExpand(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewLocation);
        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout_location);

        navigationDrawer = new NavigationDrawer(this, toolbar, mRecyclerView, Drawer);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        navigationDrawer.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        navigationDrawer.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
