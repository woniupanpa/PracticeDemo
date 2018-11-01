package com.example.admin.frameworkdemo.DrawSigpanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.DrawSigpanel.DrawSigpanelTest1Activity;
import com.example.admin.frameworkdemo.R;
import com.example.admin.frameworkdemo.Rxjava.RxjavaTestActivity;

public class DrawSigpanelMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private String[] data = { "test1"};
    private static final String TAG = DrawSigpanelMainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greendao_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(0 == id){
            Intent intent = new Intent(DrawSigpanelMainActivity.this, DrawSigpanelTest1Activity.class);
            startActivity(intent);
        }else if(1 == id){
            //greenDaoTest.add();
        }
    }
}
