package com.azmisahin.software.mobile.droid.ui.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.azmisahin.software.mobile.droid.R;
import com.azmisahin.software.mobile.droid.SignalingChannel;
import com.azmisahin.software.mobile.droid.ui.Talk.ControllerTalk;

import org.json.JSONException;

import java.net.URISyntaxException;

/**
 * Login Controller
 */
public class ControllerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller_login);
    }

    /**
     * Sign In
     * @param view
     */
    public void signin(View view) throws URISyntaxException, JSONException {

        // Get user name
        EditText userName = (EditText)findViewById(R.id.username);
        String userNameString = userName.getText().toString();

        // Login Request Server
        SignalingChannel signaling = new SignalingChannel();
        signaling.connect(userNameString);
        signaling.sendMessage(userNameString,"start");

        // Talk Controller
        Intent intent = new Intent(this, ControllerTalk.class);

        // Activate
        startActivity(intent);
    }
}
