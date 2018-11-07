package com.example.admin.frameworkdemo.AidlService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import com.example.admin.frameworkdemo.R;

public class ServiceMainActivity extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity_main);
        intent = new Intent(ServiceMainActivity.this, AidlService.class);
        startService(intent);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }

}

