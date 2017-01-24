package com.tp1.DocHome;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class GMapsFragment extends Fragment implements OnMapReadyCallback {
    SupportMapFragment mMapView;
    double lat;
    double lng;
    private GoogleMap googleMap;
    private EditText edit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout

        View v = inflater.inflate(R.layout.fragment_gmaps, container,
                false);
        Button commander = (Button) v.findViewById(R.id.commander);
        edit=(EditText)  v.findViewById(R.id.Address);
        commander.setOnClickListener(new View.OnClickListener()

        {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.commander:
                        CommanderFragment commanderFragment = new CommanderFragment();
                        FragmentManager manager = getActivity().getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.relativelayout_for_fragment, commanderFragment, commanderFragment.getTag()).commit();
                        break;
                }




            }


        });

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
        //String location = edit.getText().toString();
        String location = "rue des pinsons ,94000 CRETEIL ";
        Geocoder geocoder = new Geocoder(getActivity());
        List<Address> addressList = null;
        try {
            addressList = geocoder.getFromLocationName(location, 1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Address address = addressList.get(0);
        String locality = address.getLocality();
        Toast.makeText(getActivity(), locality, Toast.LENGTH_SHORT).show();

        lat = address.getLatitude();
        lng = address.getLongitude();
        LatLng ll = new LatLng(lat, lng);
        //Text.setText( String.format( "Value of a: %.2f", lat ) );

        // Log.d("###########", "Value: " + Double.toString(lat));
        googleMap.addMarker(new MarkerOptions()       //line 89
                .position((ll)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom((ll), 15));
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
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }


}