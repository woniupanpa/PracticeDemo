package com.example.admin.frameworkdemo.ViewGroupSelfDef;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.frameworkdemo.R;

public class ViewGroupSelfDefMainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewgroup_def);
    }
}
