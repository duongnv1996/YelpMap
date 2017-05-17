package com.duongkk.yelpmap.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DuongKK on 5/17/2017.
 */

public class ResponseReview {
    @SerializedName("reviews")
    List<Review> listReviews;
    @SerializedName("total")
    int total;
public ResponseReview(){};
    public List<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<Review> listReviews) {
        this.listReviews = listReviews;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
