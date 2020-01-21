package com.azmisahin.software.mobile.droid;

import org.json.JSONException;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class SignalingChannelTest {

    @Test
    public void connect() throws URISyntaxException {

        SignalingChannel signaling = new SignalingChannel();
        signaling.connect("test");
    }

    @Test
    public void send() throws URISyntaxException {

        SignalingChannel signaling = new SignalingChannel();
        signaling.connect("test");
        signaling.send(null);
    }

    @Test
    public void sendMessage() throws URISyntaxException, JSONException {

        SignalingChannel signaling = new SignalingChannel();
        signaling.connect("test");
        signaling.sendMessage("test","hi");
    }
}