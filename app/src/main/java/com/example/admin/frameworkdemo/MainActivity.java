package com.example.admin.frameworkdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.ButterKnife.ButterKnifeMainActivity;
import com.example.admin.frameworkdemo.DrawLayout.DrawlayoutMainActivity;
import com.example.admin.frameworkdemo.DrawSigpanel.DrawSigpanelMainActivity;
import com.example.admin.frameworkdemo.EventBus.EventBusMainActivity;
import com.example.admin.frameworkdemo.Fragment.FragmentMainActivity;
import com.example.admin.frameworkdemo.GestureLock.GestureLockMainActivity;
import com.example.admin.frameworkdemo.GreenDao.GreenDaoTestActivity;
import com.example.admin.frameworkdemo.LeakCanary.LeakMainActivity;
import com.example.admin.frameworkdemo.MVPModel.MvpMainActivity;
import com.example.admin.frameworkdemo.NavigationView.NavigationMainActivity;
import com.example.admin.frameworkdemo.OntouchAndOngesture.OntouchAndOngestureMainActivity;
import com.example.admin.frameworkdemo.PaseXML.PaseXmlTestActivity;
import com.example.admin.frameworkdemo.Picasso.PicassoMainActivity;
import com.example.admin.frameworkdemo.RecycleView.RecycleviewTestActivity;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;
import com.example.admin.frameworkdemo.ScrollerView.ScrollerMainActivity;
import com.example.admin.frameworkdemo.SelfdefineView.SelfdefineViewMainActivity;
import com.example.admin.frameworkdemo.AidlService.ServiceMainActivity;
import com.example.admin.frameworkdemo.Service.ServiceTestActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "Rxjava", "GreenDao", "Picasso", "RecycleView",
            "自定义view", "XML解析", "自定义写字板", "Fragment", "OnTouchAndOnGesture",
            "手势解锁", "MVP模式", "DrawLayout", "NavigationView", "EventBus",
            "ButterKnife", "LeakCanary", "AIDLService", "Service", "ScrollerView"};
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
       }else if(7 == id){//Fragment
           Intent frIntent = new Intent(this, FragmentMainActivity.class);
           startActivity(frIntent);
       }else if(8 == id){//手势捕获
           Intent onIntent = new Intent(this, OntouchAndOngestureMainActivity.class);
           startActivity(onIntent);
       }else if(9 == id){//手势解锁
           Intent geIntent = new Intent(this, GestureLockMainActivity.class);
           startActivity(geIntent);
       }else if(10 == id){//MVP模式
           Intent mvpIntent = new Intent(this, MvpMainActivity.class);
           startActivity(mvpIntent);
       }else if(11 == id){//Drawlayout
           Intent drIntent = new Intent(this, DrawlayoutMainActivity.class);
           startActivity(drIntent);
       }else if(12 == id){//Navigationview
           Intent naIntent = new Intent(this, NavigationMainActivity.class);
           startActivity(naIntent);
       }else if(13 == id){//EventBus
           Intent evIntent = new Intent(this, EventBusMainActivity.class);
           startActivity(evIntent);
       }else if(14 == id) {//Butterknife
           Intent buIntent = new Intent(this, ButterKnifeMainActivity.class);
           startActivity(buIntent);
       }else if(15 == id){//LeakCanary
           Intent leIntent = new Intent(this, LeakMainActivity.class);
           startActivity(leIntent);
       }else if(16 == id){//AIDLService
           Intent seIntent = new Intent(this, ServiceMainActivity.class);
           startActivity(seIntent);
       }else if(17 == id) {//Service
           Intent myIntent = new Intent(this, ServiceTestActivity.class);
           startActivity(myIntent);
       }else if(18 == id){//Scrollerview
           Intent myIntent = new Intent(this, ScrollerMainActivity.class);
           startActivity(myIntent);
       }
    }
}
