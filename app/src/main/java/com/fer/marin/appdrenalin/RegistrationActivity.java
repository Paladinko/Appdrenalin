package com.fer.marin.appdrenalin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;

import com.fer.marin.appdrenalin.utils.ImageHelper;


public class RegistrationActivity extends ActionBarActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary_yellow));
        setSupportActionBar(toolbar);
        setTitle("Registration");

        ImageView buttonRegistraion = (ImageView) findViewById(R.id.button_registration);
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.metalic);
        buttonRegistraion.setImageBitmap(ImageHelper.getRoundedCornerBitmap(icon, 120));

        ImageView bikeImage = (ImageView) findViewById(R.id.bike_registration);

        final TranslateAnimation translateBike =
                new TranslateAnimation(Animation.ABSOLUTE, 0,
                        Animation.RELATIVE_TO_PARENT, 1,
                        Animation.ABSOLUTE, 0,
                        Animation.ABSOLUTE, 1);
        translateBike.setDuration(2000);

        bikeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(translateBike);
                v.setVisibility(View.INVISIBLE);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
