package com.vnapnic.serviceresult;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BroadcastResponse broadcastResponse = new BroadcastResponse() {
        @Override
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            Log.d("namit", "aaaaaaaaaaaaaaaaaa");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(broadcastResponse, new IntentFilter(BroadcastResponse.ACTION));
    }
}
