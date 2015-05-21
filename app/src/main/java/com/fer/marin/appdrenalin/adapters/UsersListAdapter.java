package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fer.marin.appdrenalin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marin on 21/05/2015.
 */
public class UsersListAdapter extends ArrayAdapter<String> {

    Context context;
    LayoutInflater mInflater = null;
    List<Integer> images;

    public UsersListAdapter(Context context, List<Integer> images) {
        super(context,0);
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null){
            vi = mInflater.inflate(R.layout.users_row, null);
        }

        TextView userName = (TextView) vi.findViewById(R.id.users_row_name);
        ImageView userImage = (ImageView) vi.findViewById(R.id.users_row_image);

        userName.setText(getItem(position));
        userImage.setImageResource(images.get(position));

        return vi;
    }
}
