package com.example.aniket.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Rutwik on 02-Jul-16.
 */
public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.SwipeImageView);
        //TextView textView = (TextView) item_view.findViewById(R.id.ImageCount);
        imageView.setImageResource(image_resources[position]);
        //textView.setText("Image" + position);
        container.addView(item_view);

        return item_view;
    }

    //when the user swipes a image, then the previous image will be destroyed.
    // this will free up the heap memory and make the application faster.
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        //container.removeView((LinearLayout)object);

        container.removeView((View) object);

        //super.destroyItem(container, position, object);
    }
}
