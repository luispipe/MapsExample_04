package com.example.mapsexampleg4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MapMarkerActivity extends FragmentActivity implements OnMapReadyCallback{

    GoogleMap gMap;

    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_marker);
        map=findViewById(R.id.map);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap= googleMap;

        UiSettings settings= googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        //Un marcador de una posición exacta

        LatLng monserrate= new LatLng(4.605833,-74.056389);
        this.gMap.addMarker(new MarkerOptions().position(monserrate).title("Monserrate"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(monserrate));

    }
}