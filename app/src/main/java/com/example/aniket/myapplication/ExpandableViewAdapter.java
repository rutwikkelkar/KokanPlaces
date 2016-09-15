package com.example.aniket.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Rutwik on 02-Jul-16.
 */
public class ExpandableViewAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> ExpandableViewCategory;
    private List<String> myList;

    public ExpandableViewAdapter(Context ctx,  HashMap<String, List<String>> ExpandableViewCategory,List<String> myList )
    {
        this.ctx = ctx;
        this.ExpandableViewCategory = ExpandableViewCategory;
        this.myList = myList;

    }

    @Override
    public int getGroupCount() {
        return myList.size();
    }

    @Override
    public int getChildrenCount(int arg0) {

        return ExpandableViewCategory.get(myList.get(arg0)).size() ;
    }

    @Override
    public Object getGroup(int arg0) {
        return myList.get(arg0);
    }

    @Override
    public Object getChild(int parent, int child) {

        return ExpandableViewCategory.get(myList.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {

        String groupTitle = (String) getGroup(parent);
        if (convertView == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.expandable_view_parent, parentView, false);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.parent_txt);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean isLastChild, View convertView, ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if (convertView ==null)
        {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_view_child, parentView,false );
        }

        TextView childTextView = (TextView) convertView.findViewById(R.id.child_txt);
        childTextView.setText(childTitle);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
