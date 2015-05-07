package com.fer.marin.appdrenalin.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.fer.marin.appdrenalin.R;
import com.fer.marin.appdrenalin.adapters.ProfileLocationsAdapter;

import java.util.HashMap;

public class LocationListActivity extends ActionBarActivity {

    String[] locations = new String[]{"Marjan", "Sljeme", "Velebit"};
    int[] images = new int[]{R.drawable.marjan, R.drawable.sljeme, R.drawable.velebit};
    HashMap<String, int[]> sports = new HashMap<>();
    int[] marjan = new int[]{R.drawable.cycling_icon, R.drawable.scuba_diving_icon};
    int[] sljeme = new int[]{R.drawable.cycling_icon, R.drawable.skiing_icon, R.drawable.mountaineering};
    int[] velebit = new int[]{R.drawable.mountaineering, R.drawable.skiing_icon, R.drawable.rafting_icon, R.drawable.cycling_icon};
    ProfileLocationsAdapter adapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        toolbar = (Toolbar) findViewById(R.id.toolbarLocationList);
        setSupportActionBar(toolbar);
        setTitle("Lokacije");
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary_yellow));

        sports.put("Marjan", marjan);
        sports.put("Sljeme", sljeme);
        sports.put("Velebit", velebit);

        ListView lvLocations = (ListView) findViewById(R.id.locations_list);
        adapter = new ProfileLocationsAdapter(this, locations, images, sports);
        lvLocations.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location_list, menu);
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
