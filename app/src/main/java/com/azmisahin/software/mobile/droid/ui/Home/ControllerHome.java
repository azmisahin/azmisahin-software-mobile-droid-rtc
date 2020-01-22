package com.azmisahin.software.mobile.droid.ui.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.azmisahin.software.mobile.droid.R;
import com.azmisahin.software.mobile.droid.ui.Login.ControllerLogin;

import java.util.ResourceBundle;

/**
 * Home Controller
 */
public class ControllerHome extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller_home);
    }

    /**
     * Login Start
     * @param view
     */
    public void login(View view) {

        // Login Controller
        Intent intent = new Intent(this, ControllerLogin.class);

        // Activate
        startActivity(intent);
    }
}
