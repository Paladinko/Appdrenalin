package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fer.marin.appdrenalin.R;

import java.util.List;

/**
 * Created by Marin on 06/05/2015.
 */
public class DrawerAdapter extends ArrayAdapter<String>{

    Context context;
    int[] menuIcons;
    LayoutInflater mInflater = null;

    public DrawerAdapter(Context context, int[] menuIcons){
        super(context, 0);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.menuIcons = menuIcons;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            vi = mInflater.inflate(R.layout.profile_detail_row, null);
        }
        TextView textView = (TextView) vi.findViewById(R.id.menu_list_text_view);
        textView.setText(getItem(position));
        ImageView imageView = (ImageView) vi.findViewById(R.id.menu_list_icon);
        imageView.setImageResource(menuIcons[position]);
        return vi;
    }
}
