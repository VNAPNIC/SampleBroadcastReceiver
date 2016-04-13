package com.vnapnic.samplebroadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnResult;
    private EditText edtA, edtB;
    public static final String VALUE_A = "dataB";
    public static final String VALUE_B = "dataB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnResult = (Button) findViewById(R.id.btnResult);
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnResult.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int a = Integer.parseInt(edtA.getText().toString().trim());
        int b = Integer.parseInt(edtB.getText().toString().trim());
        //TODO
        Intent intent = new Intent();
        intent.setAction("com.vnapnic.serviceresult.RESPONSE");
        Bundle bundle = new Bundle();
        bundle.putInt(BroadcastResponseClient.TYPE, BroadcastResponseClient.TYPE_REQUEST);
        bundle.putInt(VALUE_A, a);
        bundle.putInt(VALUE_B, b);
        intent.putExtra(BroadcastResponseClient.BUNDLE_NAME, bundle);

        sendBroadcast(intent);
    }
}
