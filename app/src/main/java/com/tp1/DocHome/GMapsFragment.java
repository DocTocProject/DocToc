package com.tp1.DocHome;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class GMapsFragment extends Fragment implements OnMapReadyCallback {
    SupportMapFragment mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View v = inflater.inflate(R.layout.fragment_gmaps, container,
                false);
        mMapView = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                googleMap = map;
                initMap();
            }
        });



        // Perform any camera updates here
        return v;
    }

    private void initMap() {
        // latitude and longitude
        double latitude = 48.866667;
        double longitude = 2.333333;

        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Hello Maps");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(48.866667, 2.333333)).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
    /**s   @Override
    public void onMapReady(GoogleMap map) {

// 28 Rue Notre Dame des Champs - 75006 Paris
        double lattd;
        double longtd;
        List<Address> geocodeMatches = null;
        try {
            geocodeMatches =
                    new Geocoder(this).getFromLocationName(
                            "41 rue des Pinsons, 94000 CrÃ©teil France", 1);
        } catch (IOException e) {
            // TODO gÃ©nÃ©rÃ© automatiquement bloc catch
            e.printStackTrace();
        }
        if (!geocodeMatches.isEmpty()) {
            lattd = geocodeMatches.get(0).getLatitude();
            longtd = geocodeMatches.get(0).getLongitude();
            System.out.println("lattd " + lattd + "   longtd" + longtd);


            LatLng cali = new LatLng(lattd, longtd);
            map.addMarker(new MarkerOptions()
                    .position(cali)
                    .title("Pays: France"))
            ;

            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(cali)
                    .zoom(10)
                    .build();

            map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }*/
}