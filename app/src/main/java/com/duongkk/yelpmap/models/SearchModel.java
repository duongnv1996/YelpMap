package com.duongkk.yelpmap.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DuongKK on 5/16/2017.
 */

public class SearchModel {

    @SerializedName("total")
    private int total;
    @SerializedName("businesses")
    private List<Businesses> businesses;
    @SerializedName("region")
    private Region region;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Businesses> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Businesses> businesses) {
        this.businesses = businesses;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public static class Categories {
        @SerializedName("alias")
        private String alias;
        @SerializedName("title")
        private String title;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Coordinates {
        @SerializedName("latitude")
        private double latitude;
        @SerializedName("longitude")
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    public static class Location {
        @SerializedName("city")
        private String city;
        @SerializedName("country")
        private String country;
        @SerializedName("address2")
        private String address2;
        @SerializedName("address3")
        private String address3;
        @SerializedName("state")
        private String state;
        @SerializedName("address1")
        private String address1;
        @SerializedName("zip_code")
        private String zip_code;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAddress3() {
            return address3;
        }

        public void setAddress3(String address3) {
            this.address3 = address3;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getZip_code() {
            return zip_code;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }
    }

//    public static class Businesses {
//        @SerializedName("rating")
//        private int rating;
//        @SerializedName("price")
//        private String price;
//        @SerializedName("phone")
//        private String phone;
//        @SerializedName("id")
//        private String id;
//        @SerializedName("is_closed")
//        private boolean is_closed;
//        @SerializedName("categories")
//        private List<Categories> categories;
//        @SerializedName("review_count")
//        private int review_count;
//        @SerializedName("name")
//        private String name;
//        @SerializedName("url")
//        private String url;
//        @SerializedName("coordinates")
//        private Coordinates coordinates;
//        @SerializedName("image_url")
//        private String image_url;
//        @SerializedName("location")
//        private Location location;
//        @SerializedName("distance")
//        private double distance;
//        @SerializedName("transactions")
//        private List<String> transactions;
//
//        public int getRating() {
//            return rating;
//        }
//
//        public void setRating(int rating) {
//            this.rating = rating;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
//        }
//
//        public String getPhone() {
//            return phone;
//        }
//
//        public void setPhone(String phone) {
//            this.phone = phone;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public boolean getIs_closed() {
//            return is_closed;
//        }
//
//        public void setIs_closed(boolean is_closed) {
//            this.is_closed = is_closed;
//        }
//
//        public List<Categories> getCategories() {
//            return categories;
//        }
//
//        public void setCategories(List<Categories> categories) {
//            this.categories = categories;
//        }
//
//        public int getReview_count() {
//            return review_count;
//        }
//
//        public void setReview_count(int review_count) {
//            this.review_count = review_count;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public Coordinates getCoordinates() {
//            return coordinates;
//        }
//
//        public void setCoordinates(Coordinates coordinates) {
//            this.coordinates = coordinates;
//        }
//
//        public String getImage_url() {
//            return image_url;
//        }
//
//        public void setImage_url(String image_url) {
//            this.image_url = image_url;
//        }
//
//        public Location getLocation() {
//            return location;
//        }
//
//        public void setLocation(Location location) {
//            this.location = location;
//        }
//
//        public double getDistance() {
//            return distance;
//        }
//
//        public void setDistance(double distance) {
//            this.distance = distance;
//        }
//
//        public List<String> getTransactions() {
//            return transactions;
//        }
//
//        public void setTransactions(List<String> transactions) {
//            this.transactions = transactions;
//        }
//    }

    public static class Center {
        @SerializedName("latitude")
        private double latitude;
        @SerializedName("longitude")
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    public static class Region {
        @SerializedName("center")
        private Center center;

        public Center getCenter() {
            return center;
        }

        public void setCenter(Center center) {
            this.center = center;
        }
    }
}
