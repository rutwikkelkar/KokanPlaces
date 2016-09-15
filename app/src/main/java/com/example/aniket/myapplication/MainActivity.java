package com.example.aniket.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> categories = new ArrayList<String>();
        categories.add("Alibag");
        categories.add("Dive agar");
        categories.add("Nagao");
        categories.add("Tarkarli");


        // Spinner element
        Spinner spinner_CityList = (Spinner) findViewById(R.id.spinner_CityList);
        ImageButton icon11 = (ImageButton)findViewById(R.id.Icon11);
        ImageButton icon12 = (ImageButton)findViewById(R.id.Icon12);
        ImageButton icon13 = (ImageButton)findViewById(R.id.Icon13);
        ImageButton icon21 = (ImageButton)findViewById(R.id.Icon21);
        ImageButton icon22 = (ImageButton)findViewById(R.id.Icon22);
        ImageButton icon23 = (ImageButton)findViewById(R.id.Icon23);
        ImageButton icon31 = (ImageButton)findViewById(R.id.Icon31);
        ImageButton icon32 = (ImageButton)findViewById(R.id.Icon32);
        ImageButton icon33 = (ImageButton)findViewById(R.id.Icon33);

        icons present on the gui
        icon11.setOnClickListener(imageButtonClickListener);
        icon12.setOnClickListener(imageButtonClickListener);
        icon13.setOnClickListener(imageButtonClickListener);
        icon21.setOnClickListener(imageButtonClickListener);
        icon22.setOnClickListener(imageButtonClickListener);
        icon23.setOnClickListener(imageButtonClickListener);
        icon31.setOnClickListener(imageButtonClickListener);
        icon32.setOnClickListener(imageButtonClickListener);
        icon33.setOnClickListener(imageButtonClickListener);

        /*int rowCount = 3;
        int columnCount = 3;
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout);
        for (int r=0;r<rowCount;r++)
        {
            TableRow tr = new TableRow(this);

            for (int c=0;c<columnCount;c++)
            {
                ImageView im = new ImageView(this);
                im.setImageDrawable(getResources().getDrawable(R.drawable.hotel));
                im.setPadding(30,30,30,30); //should be altered according to the UI
                im.setAdjustViewBounds(true); // preserve the format of the original image.

                im.setOnClickListener(imageButtonClickListener);

                tr.addView(im, 100, 100);
            }
            table.addView(tr);
        }*/






        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_CityList.setAdapter(dataAdapter);
    }

    View.OnClickListener imageButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent nextScreen = new Intent(getApplicationContext(),DetaiLayout.class);
            startActivity(nextScreen);


        }
    };
}
