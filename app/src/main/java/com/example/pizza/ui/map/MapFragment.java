package com.example.pizza.ui.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.pizza.MarkerSettings;
import com.example.pizza.R;
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

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    List<MarkerSettings> markerSettingsList = new ArrayList<MarkerSettings>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_maps, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        markerSettingsList.add(
                new MarkerSettings("logo_mama", "Mama Mia pizza", "Best mama's pizza",
                        56.839026, 60.598115));
        markerSettingsList.add(
                new MarkerSettings("logo_kiwi", "Kiwi pizza", "Hot and tasty",
                        56.837120, 60.597115));
        markerSettingsList.add(
                new MarkerSettings("logo_dad", "Papa Joe", "Pizza from papa Joe",
                        56.838026, 60.597115));
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        return root;
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

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
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
                    .position(new LatLng(markerSettingsList.get(i)
                            .getLatitude(), markerSettingsList.get(i).getLongitude()))
                    .icon(BitmapDescriptorFactory
                            .fromBitmap(resizeBitmap(markerSettingsList.get(i)
                                    .getDrawableName(), 100, 100)))
                    .snippet(markerSettingsList.get(i).getSnippet())
                    .title(markerSettingsList.get(i).getTitle()));
        }

//        LatLng ecatSquare1905 = new LatLng(56.838026, 60.597115);
//        mMap.addMarker(new MarkerOptions()
//                .position(ecatSquare1905)
//                .title("Pizza 1905")
//                .snippet("Pizza cafe")
//                .icon(BitmapDescriptorFactory
//                        .fromBitmap(resizeBitmap("logo_pizza", 100, 100))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(56.838026, 60.597115), 17));
    }

    public Bitmap resizeBitmap(String drawableName, int width, int height) {
        Bitmap image = BitmapFactory.decodeResource(getResources(),
                getResources().getIdentifier(drawableName, "drawable", getActivity().getPackageName()));
        return Bitmap.createScaledBitmap(image, width, height, false);
    }
}