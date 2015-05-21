package com.fer.marin.appdrenalin.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fer.marin.appdrenalin.R;

import java.util.List;

/**
 * Created by Marin on 5/20/2015.
 */
public class LocationCommentAdapter extends ArrayAdapter<String> {

    Context context;
    LayoutInflater mInflater = null;
    List<Integer> images;

    public LocationCommentAdapter(Context context, List<Integer> images) {
        super(context,0 );
        this.context = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ImageView imageView;
        TextView textView;

        if (vi == null){
            vi = mInflater.inflate(R.layout.location_comment_row, null);

            textView = (TextView) vi.findViewById(R.id.location_comment_text);
            imageView = (ImageView) vi.findViewById(R.id.location_comment_image);

            vi.setTag(new CommentViewHolder(textView, imageView));

        } else {
            CommentViewHolder viewHolder = (CommentViewHolder) vi.getTag();
            imageView = viewHolder.getImageView();
            textView = viewHolder.getTextView();
        }

        textView.setText(getItem(position));
        imageView.setImageResource(images.get(position));
        return vi;
    }

    private static class CommentViewHolder{
        private ImageView imageView;
        private TextView textView;

        public CommentViewHolder(TextView textView, ImageView imageView){
            this.imageView = imageView;
            this.textView = textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }


}
