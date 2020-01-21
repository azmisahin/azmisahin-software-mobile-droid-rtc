package com.azmisahin.software.mobile.droid;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.*;

class SignalingChannel {

    private Socket socket;
    private String hostname;
    IO.Options opts;
    /**
     * SignalingChannel
     *
     */
    SignalingChannel() throws URISyntaxException {

        // Signal Options
        IO.Options signal = new IO.Options();
        signal.forceNew = false;
        signal.reconnection = false;

        // Signal Server
        hostname = "https://azmisahin-software-web-rtc.azurewebsites.net:443";

        // Socket
        socket = IO.socket(hostname,signal);

        // Connection Response
        socket.on("connection-response", new Emitter.Listener()  {

            @Override
            public void call(Object... data) {

                // Server On New Count
                eventEmit("new-connection-count", data);
            }
        });

        // Disconnect Login Response
        socket.on("disconnect-login-response", new Emitter.Listener()  {

            @Override
            public void call(Object... data) {

                // Server On New Count
                eventEmit("new-connection-count", data);
            }
        });

        // Login Response
        socket.on("login-response", new Emitter.Listener() {

            @Override
            public void call(Object... data) {
                // Server On New Count
                eventEmit("new-connection-count", data);
            }

        });

        // Login Count Response
        socket.on("login-count-response", new Emitter.Listener() {

            @Override
            public void call(Object... data) {
                // Server On New Count
                eventEmit("new-connection-count", data);
            }
        });

        // Message Response
        socket.on("message-response", new Emitter.Listener() {

            @Override
            public void call(Object... data) {
                // Server On New Message
                eventEmit("new-message", data);
            }
        });

        // Connect
        socket.connect();
    }

    /**
     * Event Emit
     * @param name Name
     * @param data Data
     */
    private void eventEmit(String name, Object data){

        // Trace
        System.out.println("Name:" + name + " " + "Data:" + data);
    }

    /**
     * Connect User
     *
     * @param user
     */
     public void connect(String user) {

        // Login request
        socket.emit("login-request", user);
    }

    /**
     * Signaling Channel Send Message
     * @param {string} from User
     * @param {string} message string message
     */
    public void send(Object model) {

        socket.emit("data", model);
    }

    /**
     * Signaling Channel Send Message
     * @param {string} from User
     * @param {string} message string message
     */
    public void sendMessage(String from, String message) throws JSONException {

        JSONObject model = new JSONObject();
        model.put("user", from);
        model.put("content", message);

        socket.emit("message", model);
    }
}