package com.example.aniket.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rutwik on 02-Jul-16.
 */
public class DataProvider {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> expandableViewInfo = new HashMap<String, List<String>>();
        List<String> Overview = new ArrayList<String>();
        Overview.add("Description: Cosy, very stylish, newly renovated bedroom in the heart of London, located in in Westminster- an enviable postcode SW1 that counts the British Queen as its most well known resident.\n" +
                "Quiet residential street, only 5 min walk from Victoria Underground station (8 mins from Victoria Coach station).\n" +
                "All major landmarks within walking distance. ");
        List<String> addReview = new ArrayList<String>();
        addReview.add("Add a Review:Excellent experience, Lara is a great host. The location is amazing, just walking distant to the main tourist attraction in London. I really enjoyed my trip to London.");

        expandableViewInfo.put("Overview", Overview);
        expandableViewInfo.put("AddReview", addReview);

        return  expandableViewInfo;

    }
}
