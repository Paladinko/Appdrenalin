package com.fer.marin.appdrenalin;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.fer.marin.appdrenalin.adapters.ProfilePagerAdapter;


public class ProfileActivity extends ActionBarActivity {

    PagerSlidingTabStrip tabHost;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProfile);
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

        return super.onOptionsItemSelected(item);
    }
}
