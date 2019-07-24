package com.example.smsscheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MYKEY = "somekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickHandler(View view) {
        Intent otherIntent = new Intent(this,OtherActivity.class);
      //  serviceIntent.putExtra(MYKEY,"http://google.com");
        Property property = new Property(123,
                "streetname","suburb","state",
                "description",123.321,"imageurl",
                3,3,3,true);

        switch (view.getId()){
            case R.id.alarm_button:
                //createAlarm();
                break;
            case R.id.button_startservice:
                otherIntent.putExtra("property",property);
                startActivity(otherIntent);
                ///startService(serviceIntent);
                break;
            case R.id.button_stop_service:
               // stopService(serviceIntent);
                break;
        }

        
    }



    private void createAlarm() {
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();


        Intent dialIntent = new Intent(MainActivity.this,SmsActivity.class);
        PendingIntent smsPendingIntent =
                PendingIntent.getActivity(this,
                        007,dialIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        long triggerTime = System.currentTimeMillis()+30*1000;
        int alarmType = AlarmManager.RTC_WAKEUP;
        AlarmManager alarmManager =
                (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setExact(alarmType,triggerTime,smsPendingIntent);
    }
}
