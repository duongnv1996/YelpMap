package com.duongkk.yelpmap.utils;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.duongkk.yelpmap.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by DuongKK on 5/13/2017.
 */

public class MapUtils {
  public   final static int SIZE_ZOOM = 12;
    public static void focuseLocation(LatLng latLng, float sizeZoom, GoogleMap mMap) {
        LatLng latLng1 = new LatLng(latLng.latitude, latLng.longitude);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng1).zoom(sizeZoom).build();
        CameraUpdate zoom = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(zoom);
    }
    public static void cameraToLocation(LatLng latLng, float sizeZoom, GoogleMap mMap) {
        LatLng latLng1 = new LatLng(latLng.latitude, latLng.longitude);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng1).zoom(sizeZoom).build();
        CameraUpdate zoom = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.moveCamera(zoom);
    }
    public static Marker addMarker(String title, String content, LatLng latLng, GoogleMap mMap, Context context){
      return   mMap.addMarker(new MarkerOptions().title(title)
        .snippet(content)
              .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.map_pin)))
        .position(latLng));


    }
}
