package com.azmisahin.software.mobile.droid.ui.Talk;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.azmisahin.software.mobile.droid.R;
import com.azmisahin.software.mobile.droid.SignalingChannel;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.emitter.Emitter;

/**
 * Talk Controller
 */
public class ControllerTalk extends AppCompatActivity {
    // Signaling Server
    SignalingChannel signaling = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller_talk);


        try {
            signaling = new SignalingChannel();

            signaling.event.on("new-message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    //JSONObject obj = (JSONObject)args[0];
                    //String value = null;
                    //try {
                    //    value = obj.getString("content");
                    //} catch (JSONException e) {
                    //    e.printStackTrace();
                    //}
                    //System.out.print(value);
                }
            });

            signaling.event.on("login-count-response", new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                    System.out.print("COUNT");
                    System.out.print(args);
                }
            });

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(View view) throws JSONException {

        // Get Message
        EditText message = (EditText)findViewById(R.id.message);
        String messageString = message.getText().toString();

        signaling.sendMessage("", messageString);
    }
}
