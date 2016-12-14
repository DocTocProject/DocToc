package com.tp1.DocHome;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;
import android.location.Address;
import android.location.Geocoder;

/**import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;*/


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mapa;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        /**super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);*/
    }
    @Override
    public void onMapReady(GoogleMap map) {
        mapa = map;
// 28 Rue Notre Dame des Champs - 75006 Paris
        double lattd;
        double longtd;
        List<Address> geocodeMatches=null;
        try {
            geocodeMatches =
                    new Geocoder (this) .getFromLocationName (
                            "41 rue des Pinsons, 94000 CrÃ©teil France", 1);
        } catch (IOException e) {
            // TODO gÃ©nÃ©rÃ© automatiquement bloc catch
            e.printStackTrace ();
        }
        if (! geocodeMatches.isEmpty ()) {
            lattd = geocodeMatches.get(0).getLatitude();
            longtd = geocodeMatches.get(0).getLongitude();
            System.out.println ("lattd " + lattd + "   longtd" + longtd);


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

    }


    /** private static final int ACCESS_FINE_LOCATION_PERMISSIONS_REQUEST = 1;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private SupportMapFragment mapFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);
        mapFragment = SupportMapFragment.newInstance();
        FragmentManager fm = getChildFragmentManager();
        fm.beginTransaction().replace(R.id.map_container, mapFragment).commit();

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MapsInitializer.initialize(getActivity());
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                        ACCESS_FINE_LOCATION_PERMISSIONS_REQUEST);
            }
        } else {
            googleMap.setMyLocationEnabled(true);
            mMap = googleMap;
            LatLng paris = new LatLng(48.8549109, 2.3454709);

            mMap.getUiSettings().setRotateGesturesEnabled(true);

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(paris, 11));

            mMap.setOnMarkerClickListener(onMarkerClickListener());

            mMap.setOnMapClickListener(onMapClickListener());
            buildGoogleApiClient();
        }

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.832337, 2.318676))
                .title("Docteur Michel")
                .snippet("Temps estimé : 8 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8235473, 2.282543))
                .title("Docteur Abboud")
                .snippet("Temps estimé : 5 ans")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))
        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.832249, 2.2905897))
                .title("Docteur Yang")
                .snippet("Temps estimé : 15 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8475015, 2.3017477))
                .title("Docteur Hunt")
                .snippet("Temps estimé : 21 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8558037, 2.3293851))
                .title("Docteur Shepherd")
                .snippet("Temps estimé : 7 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8312391, 2.3133423))
                .title("Docteur Grey")
                .snippet("Temps estimé : 12 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8421482, 2.3496194))
                .title("Docteur House")
                .snippet("Temps estimé : 5 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8650266, 2.3693227))
                .title("Docteur Ousset")
                .snippet("Temps estimé : 9 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8820261, 2.3592392))
                .title("Docteur Xavier")
                .snippet("Temps estimé : 21 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(48.8374949, 2.3666569))
                .title("Centre hospitalier")
                .snippet("SALPÊTRIÈRE")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_local_hospital_black_24dp))

        );
    }

    private GoogleMap.OnMapClickListener onMapClickListener() {
        return null;
    }

    private GoogleMap.OnMarkerClickListener onMarkerClickListener() {
        return null;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        if (requestCode == ACCESS_FINE_LOCATION_PERMISSIONS_REQUEST) {
            if (grantResults.length == 2 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "ACCESS LOCATION permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "ACCESS LOCATION permission denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(this.getClass().getName(), "Google Api Client Connected.");
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                        ACCESS_FINE_LOCATION_PERMISSIONS_REQUEST);
            }
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, buildLocationRequest(), this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(this.getClass().getName(), "Google Api Client Suspended.");
    }

    private LocationRequest buildLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }


    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            Log.i(this.getClass().getName(), "Location X : " + location.getLatitude());
            Log.i(this.getClass().getName(), "Location Y : " + location.getLongitude());
            LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 13));
        }
    }*/
}