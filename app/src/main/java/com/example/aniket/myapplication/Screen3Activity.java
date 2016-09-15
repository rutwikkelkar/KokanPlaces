package com.example.aniket.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Screen3Activity extends AppCompatActivity {

    HashMap<String, List<String>> myExpandableViewHashMap;
    List<String> myExpandableViewList;
    ExpandableListView myExpandableView;
    ExpandableViewAdapter adapter;



    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        Object o=findViewById(R.id.expandable_list); // @Aniket - is it ok to delete this line ? not making use of object anyways.
        myExpandableView = (ExpandableListView)findViewById(R.id.expandable_list);
        myExpandableViewHashMap = DataProvider.getInfo();
        myExpandableViewList = new ArrayList<String>(myExpandableViewHashMap.keySet()); // will get values like Overview and addReview
        adapter = new ExpandableViewAdapter(Screen3Activity.this,myExpandableViewHashMap,myExpandableViewList);
        myExpandableView.setAdapter(adapter);

       /* myExpandableView.setOnTouchListener(new ExpandableListView.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch(action)
                {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;

                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

        myExpandableView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                setListViewHeight(parent, groupPosition);
                return false;
            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        customSwipeAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);


    }


    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
}
