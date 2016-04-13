package com.vnapnic.serviceresult;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by vn apnic on 4/13/2016.
 */
public class BroadcastRequest extends BroadcastReceiver {
    private final String TAG = BroadcastRequest.class.getName();
    public static final String ACTION = "com.vnapnic.serviceresult.REQUEST";

    public static final String BUNDLE_NAME = "request_bundle";
    public static final String TYPE = "typebundle";
    public static final int TYPE_SERVICE = 0;
    public static final int TYPE_RESPONSE = 1;
    public static final String RESULT = "result";

    public static final String VALUE_A = "dataB";
    public static final String VALUE_B = "dataB";
    private int getValueA;
    private int getValueB;
    private String getResult;

    public BroadcastRequest() {
        super();
        Log.d("namit", "BroadcastRequest -----------------");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("namit", "Broadcast Request -----------------");
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(BUNDLE_NAME);
            if (bundle != null) {
                int type = bundle.getInt(TYPE, -1);
                if (type == -1) return;

                if (type == TYPE_RESPONSE) {
                    getValueA = bundle.getInt(VALUE_A, 0);
                    getValueB = bundle.getInt(VALUE_B, 0);
                    Intent service = new Intent(context, ServiceResult.class);
                    Bundle bService = new Bundle();
                    bService.putInt(VALUE_A, getValueA);
                    bService.putInt(VALUE_B, getValueB);
                    service.putExtra(ServiceResult.BUNDLE_NAME, bService);

                    context.startService(service);
                } else if (type == TYPE_SERVICE) {
                    //TODO
                    getResult = bundle.getString(RESULT, "");

                    Intent response = new Intent();
                    response.setAction("com.vnapnic.serviceresult.RESPONSE_CLIENT");

                    Bundle bResponse = new Bundle();
                    bResponse.putInt(BroadcastResponse.TYPE, BroadcastResponse.TYPE_RESULT);
                    bResponse.getString(BroadcastResponse.RESULT, getResult);
                    response.putExtra(BroadcastResponse.BUNDLE_NAME, bResponse);

                    context.sendBroadcast(intent);
                } else {
                    //TODO
                }
            }
        }

    }
}
