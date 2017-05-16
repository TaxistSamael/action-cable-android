package samael.sotonovich.socket_io_demo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonElement;
import com.hosopy.actioncable.ActionCable;
import com.hosopy.actioncable.ActionCableException;
import com.hosopy.actioncable.Channel;
import com.hosopy.actioncable.Consumer;
import com.hosopy.actioncable.Subscription;

import java.net.URI;
import java.net.URISyntaxException;

public class ActionCableActivity extends AppCompatActivity {

    private String token = "34fa9c13786e5b70661ce36b1e866fec725c022697491496bb5a8fb9a0830a65";
    private String CHAT_SERVER = "ws://wate.themindstudios.com/cable?token=" + token;
    private String TAG = "debug";
    private Consumer consumer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URI uri = null;
        try {
            uri = new URI(CHAT_SERVER);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

/*        Consumer.Options options = new Consumer.Options();*/

       /* Map<String, String> headers = new HashMap();
        headers.put("Authorization", "Bearer 34fa9c13786e5b70661ce36b1e866fec725c022697491496bb5a8fb9a0830a65");
        options.headers = headers;*/

//        Consumer consumer = ActionCable.createConsumer(uri, options);

        consumer = ActionCable.createConsumer(uri);

        final int restaurantId = 67; //todo: check appropriate
        Channel restaurantChannel = new Channel("RestaurantChannel");
        restaurantChannel.addParam("restaurant_id", restaurantId);
        Subscription subscription = consumer.getSubscriptions().create(restaurantChannel);

        subscription.onConnected(subscriptionCallback)
        .onReceived(receivedCallback)
        .onRejected(rejectedCallback)
        .onDisconnected(disconnectedCallback)
        .onFailed(failedCallback);

        consumer.connect();
    }

    private Subscription.ConnectedCallback subscriptionCallback = new Subscription.ConnectedCallback() {
        @Override
        public void call() {
            Log.d(TAG, "connected");
        }
    };

    private Subscription.RejectedCallback rejectedCallback = new Subscription.RejectedCallback() {
        @Override
        public void call() {
            Log.d(TAG, "rejected");
        }
    };

    private Subscription.ReceivedCallback receivedCallback = new Subscription.ReceivedCallback() {

        @Override
        public void call(JsonElement jsonElement) {
            Log.d(TAG, "received element: "+ jsonElement.toString());
        }
    };

    private Subscription.DisconnectedCallback disconnectedCallback = new Subscription.DisconnectedCallback() {
        @Override
        public void call() {
            Log.d(TAG, "disconnected");
        }
    };

    private Subscription.FailedCallback failedCallback = new Subscription.FailedCallback() {
        @Override
        public void call(ActionCableException e) {
            Log.d(TAG, "failed");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        consumer.disconnect();
    }
}
