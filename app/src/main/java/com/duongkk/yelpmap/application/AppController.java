package com.duongkk.yelpmap.application;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by DuongKK on 5/16/2017.
 */

public class AppController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
