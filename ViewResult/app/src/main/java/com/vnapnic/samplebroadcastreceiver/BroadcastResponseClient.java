package com.vnapnic.samplebroadcastreceiver;

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
public class BroadcastResponseClient extends BroadcastReceiver {
    private final String TAG = BroadcastResponseClient.class.getName();

    public static final String ACTION = "com.vnapnic.serviceresult.RESPONSEVIEW";

    public static final String BUNDLE_NAME = "bundleResponse";
    public static final String TYPE = "typeResponse";
    public static final int TYPE_RESULT = 0;
    public static final int TYPE_REQUEST = 1;
    public static final String RESULT = "result";
    private View root;
    private String getResult;

    public BroadcastResponseClient(View root) {
        this.root = root;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("namit view", "Broadcast Response -----------------");
        if (intent == null)
            return;
        Bundle bundle = intent.getBundleExtra(BUNDLE_NAME);
        if (bundle == null)
            return;
        int type = bundle.getInt(TYPE, -1);
        if (type == -1)
            return;

        if (type == TYPE_RESULT) {
            getResult = bundle.getString(RESULT, "");
            ((TextView) root.findViewById(R.id.txtResult)).setText(getResult);

        } else if (type == TYPE_REQUEST) {
            Log.d("namit view", "Send...");
        }
    }
}
