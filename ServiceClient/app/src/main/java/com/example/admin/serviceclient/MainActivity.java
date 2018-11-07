package com.example.admin.serviceclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.frameworkdemo.AIDLTest;


//如果你只是想要启动一个后台服务长期进行某项任务，
// 那么使用startService便可以了。如果你还想要与正在运行的Service取得联系，
// 那么有两种方法：一种是使用broadcast，另一种是使用bindService。
// 前者的缺点是如果交流较为频繁，容易造成性能上的问题，
// 而后者则没有这些问题。因此，这种情况就需要startService和bindService一起使用了。
public class MainActivity extends Activity {
    AIDLTest RemoteService;//监听服务
    private final static String TAG = "yjm";
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Log.d("yjm", "1111111111111111111111");
            // TODO Auto-generated method stub

        }

        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            Log.d("yjm", "2222222222222222222");
            // TODO Auto-generated method stub
            RemoteService = AIDLTest.Stub.asInterface(arg1);
            try {
                String string = RemoteService.hello("aaaaaaaaaaaaaa");
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_LONG).show();
                Log.d("yjm", "QQQQQQQ"+string);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("yjm", "DDDDDDDDDDDD");
        initservice();
    }

    //连接服务
    public void initservice(){
		/* Intent i = new Intent();
         i.setAction("android.intent.action.AIDLService");*/
        //Intent i = new Intent(MainActivity.this, AIDLTest.class);
        //Intent i = new Intent("android.intent.action.AIDLService");
        Intent i = new Intent();
        i.setAction("android.intent.action.AIDLService");
        i.setPackage("com.example.admin.frameworkdemo");
		/* try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}*/
        boolean ret = bindService(i, mConnection, Context.BIND_AUTO_CREATE);
        Log.d(TAG, "bindService Ret " + ret);
    }

    //断开服务
    private void releaseService() {
        unbindService(mConnection);
        mConnection = null;
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

}

