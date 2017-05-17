package com.duongkk.yelpmap.activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.duongkk.yelpmap.API.ApiConstants;
import com.duongkk.yelpmap.API.CustomCallback;
import com.duongkk.yelpmap.R;
import com.duongkk.yelpmap.models.Businesses;
import com.duongkk.yelpmap.models.SearchModel;
import com.duongkk.yelpmap.utils.Constants;
import com.duongkk.yelpmap.utils.MapUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.VisibleRegion;

import retrofit2.Call;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener,GoogleMap.OnCameraIdleListener,GoogleMap.OnMarkerClickListener,GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    ArrayMap<Marker,Businesses> mapMarker;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapMarker = new ArrayMap<>();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (mMap != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.setInfoWindowAdapter(this);
            mMap.setOnMarkerClickListener(this);
            mMap.setOnCameraIdleListener(this);
            mMap.setOnInfoWindowClickListener(this);
            MapUtils.cameraToLocation(new LatLng(37.56879722788206,-121.98064209893346),MapUtils.SIZE_ZOOM,mMap);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED && mMap != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
        }
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
       // MapUtils.focuseLocation(marker.getPosition(),MapUtils.SIZE_ZOOM,mMap);
        marker.showInfoWindow();
        return false;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((LayoutInflater)(this.getSystemService(LAYOUT_INFLATER_SERVICE))).inflate(R.layout.infor_window_custom,null,false);
        view.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvAddress = (TextView) view.findViewById(R.id.tv_address);
        AppCompatRatingBar ratingBar =(AppCompatRatingBar)view.findViewById(R.id.rate);
        tvName.setText(marker.getTitle());
        tvAddress.setText(marker.getSnippet());
        ratingBar.setRating(4);
        for (int i = 0; i < mapMarker.size(); i++) {
            if(mapMarker.keyAt(i).getId().equals(marker.getId())){
                ratingBar.setRating(mapMarker.valueAt(i).getRating());
                break;
            }
        }
        return view;
    }

    LatLng centerLatlng;
    @Override
    public void onCameraIdle() {
        LatLngBounds bounds = mMap.getProjection().getVisibleRegion().latLngBounds;
       float radius =  getRadius();
        if(centerLatlng!=null && bounds.contains(centerLatlng)){
            return;
        }
        centerLatlng=   bounds.getCenter();
        String token = new SPUtils(Constants.SP).getString(ApiConstants.ACCESSTOKEN,"");
        LogUtils.e(centerLatlng.latitude + "----" + centerLatlng.longitude);
        if(token.equals("")){
            Toast.makeText(this,"No AccessToken " ,Toast.LENGTH_LONG).show();
            return;
        }
        Call<SearchModel> apiSearchNearby = getmYelpServices().searchNearby(token,centerLatlng.latitude,centerLatlng.longitude,"restaurants",40000,50);
        apiSearchNearby.enqueue(new CustomCallback<SearchModel>(getApplicationContext(), new CustomCallback.ICallBack<SearchModel>() {
            @Override
            public void onResponse(SearchModel response) {
                mMap.clear();
                mapMarker.clear();
                for (Businesses item : response.getBusinesses()) {
                    LogUtils.e(item.getId());
                    LatLng latlngItem = new LatLng(item.getCoordinates().getLatitude(),item.getCoordinates().getLongitude());
                    Marker marker = MapUtils.addMarker(item.getName(),item.getLocation().getAddress1(),latlngItem,mMap,getApplicationContext());
                    mapMarker.put(marker,item);
                }
            }
        }));
    }

    private float getRadius() {
        VisibleRegion visibleRegion = mMap.getProjection().getVisibleRegion();

        LatLng farRight = visibleRegion.farRight;
        LatLng farLeft = visibleRegion.farLeft;
        LatLng nearRight = visibleRegion.nearRight;
        LatLng nearLeft = visibleRegion.nearLeft;

        float[] distanceWidth = new float[2];
        Location.distanceBetween(
                (farRight.latitude+nearRight.latitude)/2,
                (farRight.longitude+nearRight.longitude)/2,
                (farLeft.latitude+nearLeft.latitude)/2,
                (farLeft.longitude+nearLeft.longitude)/2,
                distanceWidth
        );


        float[] distanceHeight = new float[2];
        Location.distanceBetween(
                (farRight.latitude+nearRight.latitude)/2,
                (farRight.longitude+nearRight.longitude)/2,
                (farLeft.latitude+nearLeft.latitude)/2,
                (farLeft.longitude+nearLeft.longitude)/2,
                distanceHeight
        );

        float distance;

        if (distanceWidth[0]>distanceHeight[0]){
            distance = distanceWidth[0];
        } else {
            distance = distanceHeight[0];
        }

        return distance;
    }



    @Override
    public void onInfoWindowClick(Marker marker) {
        for (int i = 0; i < mapMarker.size(); i++) {
            if(mapMarker.keyAt(i).getId().equals(marker.getId())){

                Intent intent = new Intent(MapsActivity.this,DetailBusinessActivity.class);
                intent.putExtra("msg",mapMarker.valueAt(i).getId());
                startActivity(intent);


                break;
            }
        }
    }
}
