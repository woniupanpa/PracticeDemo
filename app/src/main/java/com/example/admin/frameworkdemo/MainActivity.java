package com.example.admin.frameworkdemo;

import android.content.Intent;
import android.support.design.circularreveal.CircularRevealHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.ActivityTest.ActivityTestMainActivity;
import com.example.admin.frameworkdemo.Annotation.AnnotationMainActivity;
import com.example.admin.frameworkdemo.ButterKnife.ButterKnifeMainActivity;
import com.example.admin.frameworkdemo.ConstraintLayout.ConstraintLayoutActivity;
import com.example.admin.frameworkdemo.DataBinding.DataBindingActivity;
import com.example.admin.frameworkdemo.Dispatch.DispatchMainActivity;
import com.example.admin.frameworkdemo.DrawLayout.DrawlayoutMainActivity;
import com.example.admin.frameworkdemo.DrawSigpanel.DrawSigpanelMainActivity;
import com.example.admin.frameworkdemo.EventBus.EventBusMainActivity;
import com.example.admin.frameworkdemo.Fragment.FragmentMainActivity;
import com.example.admin.frameworkdemo.GestureLock.GestureLockMainActivity;
import com.example.admin.frameworkdemo.GreenDao.GreenDaoTestActivity;
import com.example.admin.frameworkdemo.LaunchMode.LaunchMainActivity;
import com.example.admin.frameworkdemo.LeakCanary.LeakMainActivity;
import com.example.admin.frameworkdemo.MVPModel.MvpMainActivity;
import com.example.admin.frameworkdemo.NavigationView.NavigationMainActivity;
import com.example.admin.frameworkdemo.ObserverModel.Observer;
import com.example.admin.frameworkdemo.ObserverModel.ObserverMainActivity;
import com.example.admin.frameworkdemo.OntouchAndOngesture.OntouchAndOngestureMainActivity;
import com.example.admin.frameworkdemo.Parcelable.ParcelableMainActivity;
import com.example.admin.frameworkdemo.PaseXML.PaseXmlTestActivity;
import com.example.admin.frameworkdemo.Picasso.PicassoMainActivity;
import com.example.admin.frameworkdemo.Proxy.proxy;
import com.example.admin.frameworkdemo.ProxyModel.ProxyMainActivity;
import com.example.admin.frameworkdemo.RecycleView.RecycleviewTestActivity;
import com.example.admin.frameworkdemo.Reflect.ReflectMainActivity;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;
import com.example.admin.frameworkdemo.ScrollerView.ScrollerMainActivity;
import com.example.admin.frameworkdemo.SelfdefineView.SelfdefineViewMainActivity;
import com.example.admin.frameworkdemo.AidlService.ServiceMainActivity;
import com.example.admin.frameworkdemo.SelfdefineView.tickview.TickView;
import com.example.admin.frameworkdemo.SelfdefineView.tickview.TickviewMainActivity;
import com.example.admin.frameworkdemo.Service.ServiceTestActivity;
import com.example.admin.frameworkdemo.SocketTest.SocketMainActivity;
import com.example.admin.frameworkdemo.StrategyModel.StrategyMainActivity;
import com.example.admin.frameworkdemo.ThreadPool.ThreadPoolMainActivity;
import com.example.admin.frameworkdemo.ViewGroupSelfDef.ViewGroupSelfDefMainActivity;
import com.example.admin.frameworkdemo.ViewPager.ViewPagerMainActivity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] data = {"Rxjava", "GreenDao", "Picasso", "RecycleView",
            "自定义view", "XML解析", "自定义写字板", "Fragment", "OnTouchAndOnGesture",
            "手势解锁", "MVP模式", "DrawLayout", "NavigationView", "EventBus",
            "ButterKnife", "LeakCanary", "AIDLService", "Service", "ScrollerView",
            "ViewPager", "Dispatch", "LaunchMode", "ObserverMode", "ProxyModel",
            "Reflect", "策略模式", "OKHttp", "ThreadPool", "ViewGroup自定义",
            "Annotation(注解)", "ActivityTest", "Parcelable序列化", "dataBinding",
            "ConstraintLayout", "34:Socket", "35:反射＼代理模式", "36:tickView"};
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
        if (0 == id) {//Rxjava
            Intent rxIntent = new Intent(this, RxjavaTestActivity.class);
            startActivity(rxIntent);
        } else if (1 == id) {//GreenDao
            Intent grIntent = new Intent(this, GreenDaoTestActivity.class);
            startActivity(grIntent);
        } else if (2 == id) {//Picasso
            Intent piIntent = new Intent(this, PicassoMainActivity.class);
            startActivity(piIntent);
        } else if (3 == id) {//Recycleview
            Intent reIntent = new Intent(this, RecycleviewTestActivity.class);
            startActivity(reIntent);
        } else if (4 == id) {//自定义View
            Intent seIntent = new Intent(this, SelfdefineViewMainActivity.class);
            startActivity(seIntent);
        } else if (5 == id) {//XML解析
            Intent paIntent = new Intent(this, PaseXmlTestActivity.class);
            startActivity(paIntent);
        } else if (6 == id) {//自定义写字板
            Intent paIntent = new Intent(this, DrawSigpanelMainActivity.class);
            startActivity(paIntent);
        } else if (7 == id) {//Fragment
            Intent frIntent = new Intent(this, FragmentMainActivity.class);
            startActivity(frIntent);
        } else if (8 == id) {//手势捕获
            Intent onIntent = new Intent(this, OntouchAndOngestureMainActivity.class);
            startActivity(onIntent);
        } else if (9 == id) {//手势解锁
            Intent geIntent = new Intent(this, GestureLockMainActivity.class);
            startActivity(geIntent);
        } else if (10 == id) {//MVP模式
            Intent mvpIntent = new Intent(this, MvpMainActivity.class);
            startActivity(mvpIntent);
        } else if (11 == id) {//Drawlayout
            Intent drIntent = new Intent(this, DrawlayoutMainActivity.class);
            startActivity(drIntent);
        } else if (12 == id) {//Navigationview
            Intent naIntent = new Intent(this, NavigationMainActivity.class);
            startActivity(naIntent);
        } else if (13 == id) {//EventBus
            Intent evIntent = new Intent(this, EventBusMainActivity.class);
            startActivity(evIntent);
        } else if (14 == id) {//Butterknife
            Intent buIntent = new Intent(this, ButterKnifeMainActivity.class);
            startActivity(buIntent);
        } else if (15 == id) {//LeakCanary
            Intent leIntent = new Intent(this, LeakMainActivity.class);
            startActivity(leIntent);
        } else if (16 == id) {//AIDLService
            Intent seIntent = new Intent(this, ServiceMainActivity.class);
            startActivity(seIntent);
        } else if (17 == id) {//Service
            Intent myIntent = new Intent(this, ServiceTestActivity.class);
            startActivity(myIntent);
        } else if (18 == id) {//Scrollerview
            Intent myIntent = new Intent(this, ScrollerMainActivity.class);
            startActivity(myIntent);
        } else if (19 == id) {
            Intent myIntent = new Intent(this, ViewPagerMainActivity.class);
            startActivity(myIntent);
        } else if (20 == id) {
            Intent myIntent = new Intent(this, DispatchMainActivity.class);
            startActivity(myIntent);
        } else if (21 == id) {
            Intent myIntent = new Intent(this, LaunchMainActivity.class);
            startActivity(myIntent);
        } else if (22 == id) {//观察者模式
            Intent myIntent = new Intent(this, ObserverMainActivity.class);
            startActivity(myIntent);
        } else if (23 == id) {//代理模式
            Intent myIntent = new Intent(this, ProxyMainActivity.class);
            startActivity(myIntent);
        } else if (24 == id) {//反射机制
            Intent myIntent = new Intent(this, ReflectMainActivity.class);
            startActivity(myIntent);
        } else if (25 == id) {//策略模式
            Intent myIntent = new Intent(this, StrategyMainActivity.class);
            startActivity(myIntent);
        } else if (26 == id) {
            //缓存文件夹
            File cacheFile = new File(getExternalCacheDir().toString(), "cache");
            //缓存大小为10M
            int cacheSize = 10 * 1024 * 1024;
            //创建缓存对象
            Cache cache = new Cache(cacheFile, cacheSize);
            OkHttpClient client = new OkHttpClient
                    .Builder()
                    //.addInterceptor(new LoggingInterceptor())//日志拦截器
                    .cache(cache)
                    .build();
            Request request = new Request.Builder()
                    .url("http://www.baidu.com")
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("OkHttp", "Call Failed:" + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.d("OkHttp", "Call succeeded:" + response.message());
                }
            });
        } else if (27 == id) {
            Intent myIntent = new Intent(this, ThreadPoolMainActivity.class);
            startActivity(myIntent);
        } else if (28 == id) {
            Intent myIntent = new Intent(this, ViewGroupSelfDefMainActivity.class);
            startActivity(myIntent);
        } else if (29 == id) {
            Intent myIntent = new Intent(this, AnnotationMainActivity.class);
            startActivity(myIntent);
        } else if (30 == id) {
            Intent myIntent = new Intent(this, ActivityTestMainActivity.class);
            startActivity(myIntent);
        } else if (31 == id) {
            Intent myIntent = new Intent(this, ParcelableMainActivity.class);
            startActivity(myIntent);
        } else if (32 == id) {
            Intent myIntent = new Intent(this, DataBindingActivity.class);
            startActivity(myIntent);
        } else if (33 == id) {
            Intent myIntent = new Intent(this, ConstraintLayoutActivity.class);
            startActivity(myIntent);
        } else if (34 == id) {
            Intent myIntent = new Intent(this, SocketMainActivity.class);
            startActivity(myIntent);
        } else if (35 == id) {
            proxy proxy1 = new proxy();
            proxy1.test();
        } else if(36 == id){
            Intent seIntent = new Intent(this, TickviewMainActivity.class);
            startActivity(seIntent);
        }
    }
}
