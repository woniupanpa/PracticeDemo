package com.example.admin.frameworkdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.GreenDao.GreenDaoTest;
import com.example.admin.frameworkdemo.GreenDao.GreenDaoTestActivity;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "Rxjava", "GreenDao", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "id--->" + id);
       if(0 == id){//Rxjava
           Intent rxIntent = new Intent(this, RxjavaTestActivity.class);
           startActivity(rxIntent);
       }else if(1 == id){//GreenDao
            Intent grIntent = new Intent(this, GreenDaoTestActivity.class);
            startActivity(grIntent);
        }
    }
}
