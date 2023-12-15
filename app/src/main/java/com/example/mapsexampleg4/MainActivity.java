package com.example.mapsexampleg4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button marker,location,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marker=findViewById(R.id.mapMarker);
        location=findViewById(R.id.mapLocation);
        search= findViewById(R.id.mapSearch);

        Intent markerMap= new Intent(getApplicationContext(), MapMarkerActivity.class);
        Intent locationMap= new Intent(getApplicationContext(), MapLocationActivity.class);
        Intent searchMap= new Intent(getApplicationContext(), MapSearchActivity.class);

        marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(markerMap);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(locationMap);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(searchMap);
            }
        });
    }
}