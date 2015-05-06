package com.fer.marin.appdrenalin.activities;

import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
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

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    String mActivityTitle;
    ListView mDrawerList;
    DrawerAdapter adapter;
    PagerSlidingTabStrip tabHost;
    ViewPager pager;
    int[] menuIcons;
    Toolbar toolbar;
    List<String> menuItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        addDrawerItems();

        toolbar = (Toolbar) findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);
        setTitle("Marin Bulatović");
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary_yellow));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tabHost = (PagerSlidingTabStrip) this.findViewById(R.id.materialTabHost);
        pager = (ViewPager) this.findViewById(R.id.profile_view_pager);
        ProfilePagerAdapter pagerAdapter = new ProfilePagerAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(pagerAdapter);
        tabHost.setViewPager(pager);
        tabHost.setIndicatorColor(getResources().getColor(R.color.primary_yellow));
        tabHost.setShouldExpand(true);


        mActivityTitle = getTitle().toString();
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);



        adapter = new DrawerAdapter(this, menuIcons);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ProfileActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addDrawerItems(){
        menuItems.add("Profile");
        menuItems.add("Sports");
        menuItems.add("Locations");
        menuItems.add("Events");

        menuIcons = new int[]{R.drawable.mountaineering, R.drawable.mountaineering, R.drawable.mountaineering, R.drawable.mountaineering};
    }

    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
    }
}
