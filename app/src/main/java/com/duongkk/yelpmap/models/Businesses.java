package com.duongkk.yelpmap.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DuongKK on 5/16/2017.
 */

public class Businesses implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("image_url")
    private String image_url;
    @SerializedName("is_claimed")
    private boolean is_claimed;
    @SerializedName("is_closed")
    private boolean is_closed;
    @SerializedName("url")
    private String url;
    @SerializedName("price")
    private String price;
    @SerializedName("rating")
    private float rating;
    @SerializedName("review_count")
    private int review_count;
    @SerializedName("phone")
    private String phone;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("hours")
    private List<Hours> hours;
    @SerializedName("categories")
    private List<Categories> categories;
    @SerializedName("coordinates")
    private Coordinates coordinates;
    @SerializedName("location")
    private Location location;
    @SerializedName("transactions")
    private List<String> transactions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean getIs_claimed() {
        return is_claimed;
    }

    public void setIs_claimed(boolean is_claimed) {
        this.is_claimed = is_claimed;
    }

    public boolean getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Hours> getHours() {
        return hours;
    }

    public void setHours(List<Hours> hours) {
        this.hours = hours;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public static class Open {
        @SerializedName("is_overnight")
        private boolean is_overnight;
        @SerializedName("end")
        private String end;
        @SerializedName("day")
        private int day;
        @SerializedName("start")
        private String start;

        public boolean getIs_overnight() {
            return is_overnight;
        }

        public void setIs_overnight(boolean is_overnight) {
            this.is_overnight = is_overnight;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }
    }

    public static class Hours {
        @SerializedName("hours_type")
        private String hours_type;
        @SerializedName("open")
        private List<Open> open;
        @SerializedName("is_open_now")
        private boolean is_open_now;

        public String getHours_type() {
            return hours_type;
        }

        public void setHours_type(String hours_type) {
            this.hours_type = hours_type;
        }

        public List<Open> getOpen() {
            return open;
        }

        public void setOpen(List<Open> open) {
            this.open = open;
        }

        public boolean getIs_open_now() {
            return is_open_now;
        }

        public void setIs_open_now(boolean is_open_now) {
            this.is_open_now = is_open_now;
        }
    }

    public static class Categories implements Parcelable {
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.alias);
            dest.writeString(this.title);
        }

        public Categories() {
        }

        protected Categories(Parcel in) {
            this.alias = in.readString();
            this.title = in.readString();
        }

        public static final Creator<Categories> CREATOR = new Creator<Categories>() {
            @Override
            public Categories createFromParcel(Parcel source) {
                return new Categories(source);
            }

            @Override
            public Categories[] newArray(int size) {
                return new Categories[size];
            }
        };
    }

    public static class Coordinates implements Parcelable {

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.latitude);
            dest.writeDouble(this.longitude);
        }

        public Coordinates() {
        }

        protected Coordinates(Parcel in) {
            this.latitude = in.readDouble();
            this.longitude = in.readDouble();
        }

        public static final Creator<Coordinates> CREATOR = new Creator<Coordinates>() {
            @Override
            public Coordinates createFromParcel(Parcel source) {
                return new Coordinates(source);
            }

            @Override
            public Coordinates[] newArray(int size) {
                return new Coordinates[size];
            }
        };
    }

    public static class Location implements Parcelable {

        @SerializedName("address1")
        private String address1;
        @SerializedName("address2")
        private String address2;
        @SerializedName("address3")
        private String address3;
        @SerializedName("city")
        private String city;
        @SerializedName("state")
        private String state;
        @SerializedName("zip_code")
        private String zip_code;
        @SerializedName("country")
        private String country;
        @SerializedName("display_address")
        private List<String> display_address;
        @SerializedName("cross_streets")
        private String cross_streets;

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip_code() {
            return zip_code;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<String> getDisplay_address() {
            return display_address;
        }

        public void setDisplay_address(List<String> display_address) {
            this.display_address = display_address;
        }

        public String getCross_streets() {
            return cross_streets;
        }

        public void setCross_streets(String cross_streets) {
            this.cross_streets = cross_streets;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.address1);
            dest.writeString(this.address2);
            dest.writeString(this.address3);
            dest.writeString(this.city);
            dest.writeString(this.state);
            dest.writeString(this.zip_code);
            dest.writeString(this.country);
            dest.writeStringList(this.display_address);
            dest.writeString(this.cross_streets);
        }

        public Location() {
        }

        protected Location(Parcel in) {
            this.address1 = in.readString();
            this.address2 = in.readString();
            this.address3 = in.readString();
            this.city = in.readString();
            this.state = in.readString();
            this.zip_code = in.readString();
            this.country = in.readString();
            this.display_address = in.createStringArrayList();
            this.cross_streets = in.readString();
        }

        public static final Creator<Location> CREATOR = new Creator<Location>() {
            @Override
            public Location createFromParcel(Parcel source) {
                return new Location(source);
            }

            @Override
            public Location[] newArray(int size) {
                return new Location[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.image_url);
        dest.writeByte(this.is_claimed ? (byte) 1 : (byte) 0);
        dest.writeByte(this.is_closed ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.price);
        dest.writeDouble(this.rating);
        dest.writeInt(this.review_count);
        dest.writeString(this.phone);
        dest.writeStringList(this.photos);
        //dest.writeList(this.hours);
        dest.writeList(this.categories);
        dest.writeParcelable(this.coordinates, flags);
        dest.writeParcelable(this.location, flags);
        dest.writeStringList(this.transactions);
    }

    public Businesses() {
    }

    protected Businesses(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.image_url = in.readString();
        this.is_claimed = in.readByte() != 0;
        this.is_closed = in.readByte() != 0;
        this.url = in.readString();
        this.price = in.readString();
        this.rating = in.readFloat();
        this.review_count = in.readInt();
        this.phone = in.readString();
        this.photos = in.createStringArrayList();
        this.hours = new ArrayList<Hours>();
        in.readList(this.hours, Hours.class.getClassLoader());
        this.categories = new ArrayList<Categories>();
        in.readList(this.categories, Categories.class.getClassLoader());
        this.coordinates = in.readParcelable(Coordinates.class.getClassLoader());
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.transactions = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Businesses> CREATOR = new Parcelable.Creator<Businesses>() {
        @Override
        public Businesses createFromParcel(Parcel source) {
            return new Businesses(source);
        }

        @Override
        public Businesses[] newArray(int size) {
            return new Businesses[size];
        }
    };
}
