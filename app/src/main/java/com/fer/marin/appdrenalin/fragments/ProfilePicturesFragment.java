package com.fer.marin.appdrenalin.fragments;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.fer.marin.appdrenalin.R;

import java.io.ByteArrayOutputStream;


public class ProfilePicturesFragment extends Fragment {

    private ImageView imageButton, mImageView;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    LinearLayout picLL;

    public static ProfilePicturesFragment newInstance() {
        ProfilePicturesFragment fragment = new ProfilePicturesFragment();
        return fragment;
    }

    public ProfilePicturesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_pictures, container, false);
        picLL = (LinearLayout) rootView.findViewById(R.id.ll_profile_pictures_horizontal);
        rootView.findViewById(R.id.ripple).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,
                        CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });
        GridView gridview = (GridView) rootView.findViewById(R.id.profile_pictures_gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // Convert ByteArray to Bitmap::

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

                ImageView userImage = new ImageView(getActivity());
                userImage.setImageBitmap(bitmap);
                userImage.setPadding(16, 16, 16, 16);
                picLL.addView(userImage);
            }
        }
    }

}

class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(192, 192));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(16, 16, 16, 16);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.marjan, R.drawable.marjan1,
            R.drawable.marjan2, R.drawable.marjan3,
            R.drawable.marjan4, R.drawable.marjan5,
            R.drawable.sljeme, R.drawable.sljeme1,
            R.drawable.sljeme2, R.drawable.sljeme3,
            R.drawable.sljeme4, R.drawable.sljeme5,
            R.drawable.velebit,
            R.drawable.velebit2, R.drawable.velebit3,
            R.drawable.velebit4, R.drawable.velebit5
    };
}

