package com.example.admin.frameworkdemo.Rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.R;


/*
步骤：
1：build.gradle添加
implementation "io.reactivex.rxjava2:rxjava:2.0.7"
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
2:不支持lambada表达式的情况下，在build.gradle里面添加
compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
 */

public class RxjavaTestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "Observable", "Single", "Completable", "Complicated", "addThenTest",
            "flatMap", "zipWithTest", "retryTest", "retryWhen", "switchIfEmpty", "contactMap"};
    private RxjavaTest rxjavaTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                RxjavaTestActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        rxjavaTest = new RxjavaTest(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(0 == id){//Observable
            rxjavaTest.ObservableTest();
        }else if(1 == id){
            rxjavaTest.SingleTest();
        }else if(2 == id){
            rxjavaTest.CompletableTest();
        }else if(3 == id){
            rxjavaTest.ComplicatedTest();
        }else if(4 == id){
            rxjavaTest.andThenTesst();
        }else if(5 == id){
            rxjavaTest.flatmapTest();
        }else if(6 == id){
            rxjavaTest.zipWithTest();
        }else if(7 == id){
            rxjavaTest.retryTest();
        }else if(8 == id){
            rxjavaTest.retryWhenTest();
        }else if(9 == id){
            rxjavaTest.switchIfEmptyTest();
        }else if(10 == id){
            rxjavaTest.contactMapTest();
        }
    }
}
