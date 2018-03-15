package com.lucifer.QLSV_Poly_AndroidNC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.myMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(21.0355555, 105.7652897);
        map = googleMap;

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17));

        map.addMarker(new MarkerOptions()
                .title("FPT Polytechnic")
                .snippet("Trường Cao Đẳng thực hành FPT Polytechnic Hà Nội")
                .position(sydney));
    }
}
