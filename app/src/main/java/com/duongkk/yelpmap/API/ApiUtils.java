package com.duongkk.yelpmap.API;

import retrofit2.Retrofit;

/**
 * Created by DuongKK on 5/13/2017.
 */

public class ApiUtils {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();
}
