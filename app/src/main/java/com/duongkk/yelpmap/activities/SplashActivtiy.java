package com.duongkk.yelpmap.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.SPUtils;
import com.duongkk.yelpmap.API.ApiConstants;
import com.duongkk.yelpmap.API.ApiUtils;
import com.duongkk.yelpmap.API.CustomCallback;
import com.duongkk.yelpmap.API.YelpServices;
import com.duongkk.yelpmap.R;
import com.duongkk.yelpmap.models.ResponseAuth;
import com.duongkk.yelpmap.utils.Constants;

import retrofit2.Call;

public class SplashActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        YelpServices yelpServices = ApiUtils.getInstance().getRetrofit().create(YelpServices.class);
        Call<ResponseAuth> apiAuth = yelpServices.getAccessToken("client_credentials", ApiConstants.CLIENT_ID,ApiConstants.CLIENT_SECRET);
        apiAuth.enqueue(new CustomCallback<ResponseAuth>(getApplicationContext(), new CustomCallback.ICallBack<ResponseAuth>() {
            @Override
            public void onResponse(ResponseAuth response) {
                new SPUtils(Constants.SP).put(ApiConstants.ACCESSTOKEN,"Bearer " +response.getAccess_token());
                startActivity(new Intent(SplashActivtiy.this,MapsActivity.class));
                finish();
            }
        }));

    }
}
