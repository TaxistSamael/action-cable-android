package samael.sotonovich.socket_io_demo;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*private Socket socket;
    private String token = "fcd657fc04f259af44a350f2c2c735831b8d65ba1fe0dc669a98624518f86806";
    private String CHAT_SERVER = "ws://wate.themindstudios.com/cable?token=" + token;
    //initialize a new instance of Socket.IO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            socket = IO.socket(CHAT_SERVER);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

   *//*     JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("restaurant_id", "67");
        } catch (JSONException e) {
            e.printStackTrace();
        }*//*

        socket.on("RestaurantChannel", onOrderPlaced);
        socket.on(Socket.EVENT_CONNECT, onConnect);
        socket.on(Socket.EVENT_DISCONNECT, onDisconnect);
        socket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        socket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
        socket.on(Socket.EVENT_ERROR, onError);
        int restaurantId = 22; //todo: check which one is correct
        socket.emit("RestaurantChannel", restaurantId, onOrderPlaced);
        socket.connect();
    }

    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("TAG", "disconnected");
        }
    };

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("TAG", "onConnectError");
        }
    };

    private Emitter.Listener onError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("TAG", "onError");
        }
    };

    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("TAG", "connected");
        }
    };

    private Emitter.Listener onOrderPlaced = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d("TAG", "order placed");
                    JSONObject data = (JSONObject) args[0];
                    Log.d("TAG", "order json: " + data.toString());
                }
            });

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "disconnected");
        socket.off("RestaurantChannel", onOrderPlaced);
        socket.disconnect();
    }*/
}
