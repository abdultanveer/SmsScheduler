package com.example.smsscheduler;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable {
    //property basics
    private int streetNumber;
    private String streetName;
    private String suburb;
    private String state;
    private String description;
    private String image;
    private Double price;
    private int bedrooms;
    private int bathrooms;
    private int carspots;
    private Boolean featured;

    //main constructor
    public Property(int streetNumber, String streetName, String suburb, String state, String description, Double price, String image, int bedrooms, int bathrooms, int carspots, Boolean featured) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.state = state;
        this.description = description;
        this.price = price;
        this.image = image;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.carspots = carspots;
        this.featured = featured;
    }


    public Property(Parcel parcel){
        streetName = parcel.readString();
        suburb = parcel.readString();
        state = parcel.readString();
        description = parcel.readString();
        image = parcel.readString();
        streetNumber = parcel.readInt();
        featured = (Boolean) parcel.readValue(null);
        price = parcel.readDouble();
        bedrooms = parcel.readInt();
        bathrooms = parcel.readInt();
        carspots = parcel.readInt();
    }

    public static final Creator<Property> CREATOR = new Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel in) {
            return new Property(in);//line 36 is called
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };

    //getters
    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public int getCarspots() {
        return carspots;
    }

    public Boolean getFeatured() {
        return featured;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(streetName);
        dest.writeString(suburb);
        dest.writeString(state);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeInt(streetNumber);
        dest.writeValue(featured);
        dest.writeDouble(price);
        dest.writeInt(bedrooms);
        dest.writeInt(bathrooms);
        dest.writeInt(carspots);
    }
}