package com.example.pizza;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    List<MarkerSettings> markerSettingsList = new ArrayList<MarkerSettings>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        markerSettingsList.add(
//                new MarkerSettings("logo_pizza", 56.839026, 60.598115));
//        markerSettingsList.add(
//                new MarkerSettings("logo_pizza", 56.837120, 60.597115));
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED
//                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
//                            Manifest.permission.ACCESS_COARSE_LOCATION},
//                    1);
//            //return;
//        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }

//        Task locationResult = fusedLocationProviderClient.getLastLocation();
//        locationResult.addOnCompleteListener(this, new OnCompleteListener() {
//            @Override
//            public void onComplete(@NonNull Task task) {
//                if (task.isSuccessful()) {
//                    Location lastLocation = (Location) task.getResult();
//                    LatLng myLocation = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 17));
//                }
//            }
//        });

        for (int i = 0; i < markerSettingsList.size(); i++) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(markerSettingsList.get(i).getLatitude(), markerSettingsList.get(i).getLongitude()))
                    .icon(BitmapDescriptorFactory
                            .fromBitmap(resizeBitmap("logo_pizza", 100, 100))));
        }

        LatLng ecatSquare1905 = new LatLng(56.838026, 60.597115);
        mMap.addMarker(new MarkerOptions()
                .position(ecatSquare1905)
                .title("Pizza 1905")
                .snippet("Pizza cafe")
                .icon(BitmapDescriptorFactory
                        .fromBitmap(resizeBitmap("logo_pizza", 100, 100))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ecatSquare1905, 17));
    }

    public Bitmap resizeBitmap(String drawableName, int width, int height) {
        Bitmap image = BitmapFactory.decodeResource(getResources(),
                getResources().getIdentifier(drawableName, "drawable", getPackageName()));
        return Bitmap.createScaledBitmap(image, width, height, false);
    }
}