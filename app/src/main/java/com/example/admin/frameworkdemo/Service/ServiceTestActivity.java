
package com.example.admin.frameworkdemo.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.frameworkdemo.R;

public class ServiceTestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] data = {"startService", "bindService", "stopService", "unbindService"};
    private static final String TAG = ServiceTestActivity.class.getSimpleName();
    private MyConnection conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test_activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        conn = new MyConnection();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (0 == id) {
            startservice();
        } else if (1 == id) {
            bindservice();
        } else if (2 == id) {
            stopservice();
        }else if(3 == id){
            unbindService();
        }
    }

    public void startservice() {
        Intent service = new Intent(this, MyService.class);
        startService(service);
    }

    public void stopservice() {
        Intent service = new Intent(this, MyService.class);
        stopService(service);
    }

    public void bindservice() {
        //开启服务
        Intent service = new Intent(this, MyService.class);
        //第一个参数：Intent意图
        // 第二个参数：是一个接口，通过这个接口接收服务开启或者停止的消息，并且这个参数不能为null
        // 第三个参数：开启服务时的操作，BIND_AUTO_CREATE代表自动创建service
        bindService(service, conn, BIND_AUTO_CREATE);
    }

    private class MyConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //只有当我们自己写的MyService的onBind方法返回值不为null时，才会被调用
            MyService.MyBinder myBinder = (MyService.MyBinder)service;
            Log.d("call",myBinder.getData());
            Log.d("call", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //这个方法只有出现异常时才会调用，服务器正常退出不会调用.
            Log.d("call", "onServiceDisconnected");
        }
    }

    public void unbindService(){
        unbindService(conn);
    }

}

