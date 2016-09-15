package com.example.aniket.myapplication;

/**
 * Created by Aniket on 6/26/2016.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.listitemtemplate, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.listitemtemplate, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtsubTitle = (TextView) rowView.findViewById(R.id.subtxt);


        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);
        String subtext=String.format("Address of"+web[position]);
        txtsubTitle.setText(subtext);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}