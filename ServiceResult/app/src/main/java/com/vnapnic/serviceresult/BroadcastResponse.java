package com.vnapnic.serviceresult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by vn apnic on 4/13/2016.
 */
public class BroadcastResponse extends BroadcastReceiver {
    private final String TAG = BroadcastResponse.class.getName();

    public static final String ACTION = "com.vnapnic.serviceresult.RESPONSE";

    public static final String BUNDLE_NAME = "bundleResponse";
    public static final String TYPE = "typeResponse";
    public static final int TYPE_RESULT = 0;
    public static final int TYPE_REQUEST = 1;
    public static final String RESULT = "result";
    private View view;

    public BroadcastResponse() {
        super();
        Log.d("namit", "BroadcastResponse -----------------");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("namit", "Broadcast Response -----------------");
        if (intent == null)
            return;
        Bundle bundle = intent.getBundleExtra(BUNDLE_NAME);
        if (bundle == null)
            return;
        int type = bundle.getInt(TYPE, -1);
        if (type == -1)
            return;

        if (type == TYPE_RESULT) {
            Log.d("namit", "result ...");

        } else if (type == TYPE_REQUEST) {

            int valueA = bundle.getInt(BroadcastRequest.VALUE_A, 0);
            int valueB = bundle.getInt(BroadcastRequest.VALUE_B, 0);

            Intent request = new Intent();
            request.setAction(BroadcastRequest.ACTION);

            Bundle bundleRequest = new Bundle();
            bundleRequest.putInt(BroadcastRequest.TYPE, BroadcastRequest.TYPE_RESPONSE);
            bundleRequest.putInt(BroadcastRequest.VALUE_A, valueA);
            bundleRequest.putInt(BroadcastRequest.VALUE_B, valueB);
            request.putExtra(BroadcastRequest.BUNDLE_NAME, bundleRequest);

            context.sendBroadcast(request);
        }
    }
}
