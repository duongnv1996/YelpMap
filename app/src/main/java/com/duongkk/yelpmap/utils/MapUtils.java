package com.duongkk.yelpmap.utils;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by DuongKK on 5/13/2017.
 */

public class MapUtils {
  public   final static int SIZE_ZOOM = 16;
    public static void focuseLocation(LatLng latLng, float sizeZoom, GoogleMap mMap) {
        LatLng latLng1 = new LatLng(latLng.latitude, latLng.longitude);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng1).zoom(sizeZoom).build();
        CameraUpdate zoom = CameraUpdateFactory.newCameraPosition(cameraPosition);
        mMap.animateCamera(zoom);
    }
}
