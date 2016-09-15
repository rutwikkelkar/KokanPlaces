package com.example.aniket.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetaiLayout extends AppCompatActivity {

    ListView list;
    String[] web = {
            "Hotel1",
            "Hotel2",
            "Hotel3",
            "Hotel4",
            "Hotel5",
            "Hotel6",
            "Hotel7",
            "Hotel8",

    } ;
    Integer[] imageId = {
            R.drawable.hospital,
            R.drawable.hotel,
            R.drawable.beach_logo,
            R.drawable.realestatelogo,
            R.drawable.hospital,
            R.drawable.hotel,
            R.drawable.beach_logo,
            R.drawable.realestatelogo,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_layout);

        //ListView myListView=(ListView)findViewById(R.id.listView);

        Spinner spinner_CityList = (Spinner) findViewById(R.id.spinner_CityList);
        List<String> categories = new ArrayList<String>();
        categories.add("Alibag");
        categories.add("Dive agar");
        categories.add("Nagao");
        categories.add("Tarkarli");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_CityList.setAdapter(dataAdapter);


        CustomList adapter = new
                CustomList(DetaiLayout.this, web, imageId);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(DetaiLayout.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Intent thirdScreen = new Intent(getApplicationContext(),Screen3Activity.class);
                startActivity(thirdScreen);

            }
        });

    }
}


