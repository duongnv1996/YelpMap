package com.duongkk.yelpmap.API;

import com.duongkk.yelpmap.models.Businesses;
import com.duongkk.yelpmap.models.ResponseAuth;
import com.duongkk.yelpmap.models.ResponseReview;
import com.duongkk.yelpmap.models.SearchModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DuongKK on 5/13/2017.
 */

public interface YelpServices {
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET(ApiConstants.API_SEARCH)
    Call<SearchModel> searchNearby(@Header("Authorization") String token, @Query("latitude") double lat, @Query("longitude") double lng, @Query("term") String term,@Query("radius") int radius,@Query("limit") int limit );

    @FormUrlEncoded
    @POST(ApiConstants.API_AUTH)
    Call<ResponseAuth> getAccessToken(@Field("grant_type") String type,@Field("client_id") String client_id,@Field("client_secret") String client_secret);
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET(ApiConstants.API_DETAIL_BUSINESSES)
    Call<Businesses> getDetailBusiness(@Header("Authorization") String token, @Path("id") String id);
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @GET(ApiConstants.API_GET_ALL_REVIEW)
    Call<ResponseReview> getReviews(@Header("Authorization") String token, @Path("id") String id);
}
