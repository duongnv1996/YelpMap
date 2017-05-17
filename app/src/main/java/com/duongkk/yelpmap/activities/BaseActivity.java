package com.duongkk.yelpmap.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.duongkk.yelpmap.API.ApiUtils;
import com.duongkk.yelpmap.API.YelpServices;

/**
 * Created by DuongKK on 5/16/2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected YelpServices mYelpServices;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mYelpServices = ApiUtils.getInstance().getRetrofit().create(YelpServices.class);
    }

    public YelpServices getmYelpServices() {
        return mYelpServices;
    }
}
