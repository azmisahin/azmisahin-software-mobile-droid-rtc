package com.azmisahin.software.mobile.droid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.json.JSONException;
import java.net.URISyntaxException;

public class Home extends AppCompatActivity {

    SignalingChannel signaling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller_home);

        try {
            signaling = new SignalingChannel();
            String deviceInformation = "";
            deviceInformation += "\r\n" + System.getProperty("os.version"); // OS version
            deviceInformation += "\r\n" + android.os.Build.VERSION.SDK;     // API Level
            deviceInformation += "\r\n" + android.os.Build.DEVICE;          // Device
            deviceInformation += "\r\n" + android.os.Build.MODEL;           // Model
            deviceInformation += "\r\n" + android.os.Build.PRODUCT;         // Product

            String user =  System.getProperty("user.name");

            signaling.sendMessage(user, deviceInformation);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
