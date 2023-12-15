package com.example.mapsexampleg4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MapSearchActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;

    Marker marker;

    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_search);

        searchView=findViewById(R.id.search);
        searchView.clearFocus();

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location= searchView.getQuery().toString();
                if(location==null){
                    Toast.makeText(getApplicationContext(),"Location not found",Toast.LENGTH_LONG).show();
                }else{
                    Geocoder geocoder= new Geocoder(getApplicationContext(), Locale.getDefault());
                    try {
                        List<Address> addressList= geocoder.getFromLocationName(location,1);
                        if(addressList.size()> 0){
                            LatLng latLng= new LatLng(addressList.get(0).getLatitude(),addressList.get(0).getLongitude());
                            if (marker!=null){
                                marker.remove();
                            }
                            MarkerOptions markerOptions= new MarkerOptions().position(latLng).title(location);
                            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                            CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(latLng,15);
                            gMap.animateCamera(cameraUpdate);
                            marker= gMap.addMarker(markerOptions);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap= googleMap;

        UiSettings settings= googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
    }
}