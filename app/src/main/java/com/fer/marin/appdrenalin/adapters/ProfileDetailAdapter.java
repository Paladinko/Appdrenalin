package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fer.marin.appdrenalin.R;

/**
 * Created by Marin on 06/05/2015.
 */
public class ProfileDetailAdapter extends ArrayAdapter<String> {

    Context context;
    LayoutInflater mInflater = null;
    int[] icons;
    boolean editMode;


    public ProfileDetailAdapter(Context context, int[] icons, boolean editMode){
        super(context, R.layout.profile_detail_row, R.id.profile_detail_sport_title);
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.icons = icons;
        this.editMode = editMode;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        String sport = getItem(position);
        CheckBox checkBox;
        TextView textView;
        ImageView imageView;

        if (vi == null){
            vi = mInflater.inflate(R.layout.profile_detail_row, null);

            textView = (TextView) vi.findViewById(R.id.profile_detail_sport_title);
            imageView = (ImageView) vi.findViewById(R.id.profile_detail_sport_icon);
            checkBox = (CheckBox) vi.findViewById(R.id.profile_detail_checkbox);

            vi.setTag(new SportsViewHolder(imageView, textView, checkBox));

            if (editMode){
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        String sport = (String) cb.getTag();
                        Toast.makeText(context, sport, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                checkBox.setVisibility(View.INVISIBLE);
            }

        } else {
            SportsViewHolder viewHolder = (SportsViewHolder) vi.getTag();
            imageView = viewHolder.getImageView();
            textView = viewHolder.getTextView();
            checkBox = viewHolder.getCheckBox();
        }

        checkBox.setTag(sport);

        textView.setText(sport);
        imageView.setImageResource(icons[position]);
        return vi;
    }

    private static class SportsViewHolder{
        private TextView textView;
        private ImageView imageView;
        private CheckBox checkBox;

        public SportsViewHolder(ImageView imageView, TextView textView, CheckBox checkBox){
            this.textView = textView;
            this.imageView = imageView;
            this.checkBox = checkBox;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }
    }
}
