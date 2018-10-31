package com.example.admin.frameworkdemo.GreenDao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.R;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;

public class GreenDaoTestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "init(autodone)", "add", "delete", "search", "update"};
    private static final String TAG = GreenDaoTestActivity.class.getSimpleName();
    private GreenDaoTest greenDaoTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greendao_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        greenDaoTest = new GreenDaoTest(getApplicationContext());
        greenDaoTest.init();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*if(0 == id){
            greenDaoTest.init();
        }else */
            if(1 == id){
            greenDaoTest.add();
        }else if(2 == id){
            greenDaoTest.delete();
        } else if(3 == id){
            greenDaoTest.search();
        }else if(4 == id) {
            greenDaoTest.update();
        }
    }
}
