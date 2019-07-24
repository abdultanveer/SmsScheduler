package com.example.smsscheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();
        Property property = intent.getParcelableExtra("property");

//now collect all property values
        String streetName = property.getStreetName();
        Integer streetNumber = property.getStreetNumber();
        String suburb = property.getSuburb();
        String state = property.getState();
        String description = property.getDescription();
        Double price = property.getPrice();
        Integer bedrooms = property.getBedrooms();
        Integer bathrooms = property.getBathrooms();
        Integer carspots = property.getCarspots();
        String image = property.getImage();
        Integer imageID = this.getResources().getIdentifier(image, "drawable", this.getPackageName());
        String address = streetNumber + " " + streetName + ", " + suburb + ", " + state;
    }
}
