package com.vnapnic.serviceresult;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by vn apnic on 4/13/2016.
 */
public class ServiceResult extends IntentService {
    private final String TAG = BroadcastRequest.class.getName();
    public static final String BUNDLE_NAME = ServiceResult.class.getName();

    public ServiceResult() {
        super("");
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("namit", "Service onStart -----------------");
        SendBroadcast("loading...");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("namit", "Service onHandleIntent -----------------");
        Bundle bundle = intent.getBundleExtra(BUNDLE_NAME);
        int a = bundle.getInt(BroadcastRequest.VALUE_A, 0);
        int b = bundle.getInt(BroadcastRequest.VALUE_B, 0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SendBroadcast("Result: " + (a + b));
    }

    private void SendBroadcast(String send) {
        Intent intent = new Intent();
        intent.setAction(BroadcastRequest.ACTION);

        Bundle bundle = new Bundle();
        bundle.putInt(BroadcastRequest.TYPE, BroadcastRequest.TYPE_SERVICE);
        bundle.putString(BroadcastRequest.RESULT, send);
        intent.putExtra(BroadcastRequest.BUNDLE_NAME, bundle);

        getApplicationContext().sendBroadcast(intent);
    }
}
