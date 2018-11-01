package com.example.admin.frameworkdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.DrawSigpanel.DrawSigpanelMainActivity;
import com.example.admin.frameworkdemo.DrawSigpanel.DrawSigpanelTest1Activity;
import com.example.admin.frameworkdemo.GreenDao.GreenDaoTest;
import com.example.admin.frameworkdemo.GreenDao.GreenDaoTestActivity;
import com.example.admin.frameworkdemo.PaseXML.PaseXmlTestActivity;
import com.example.admin.frameworkdemo.Picasso.PicassoMainActivity;
import com.example.admin.frameworkdemo.RecycleView.RecycleviewTestActivity;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;
import com.example.admin.frameworkdemo.SelfdefineView.SelfdefineViewMainActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "Rxjava", "GreenDao", "Picasso", "RecycleView",
            "自定义view", "XML解析", "自定义写字板", "Strawberry", "Cherry", "Mango" };
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
        }else if(2 == id){//Picasso
           Intent piIntent = new Intent(this, PicassoMainActivity.class);
           startActivity(piIntent);
       }else if(3  == id){//Recycleview
           Intent reIntent = new Intent(this, RecycleviewTestActivity.class);
           startActivity(reIntent);
       }else if(4 == id){//自定义View
           Intent seIntent = new Intent(this, SelfdefineViewMainActivity.class);
           startActivity(seIntent);
       }else if(5 == id){//XML解析
           Intent paIntent = new Intent(this, PaseXmlTestActivity.class);
           startActivity(paIntent);
       }else if(6 == id){//自定义写字板
           Intent paIntent = new Intent(this, DrawSigpanelMainActivity.class);
           startActivity(paIntent);
       }
    }
}
