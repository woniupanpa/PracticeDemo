package com.example.admin.frameworkdemo.AidlService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.admin.frameworkdemo.AIDLTest;

public class AidlService extends Service{

    @Override
    public IBinder onBind(Intent arg0) {
		/*return new AIDLTest.Stub() {

			@Override
			public String hello(String name) throws RemoteException {
				// TODO Auto-generated method stub
				return "hello"+name;
			}
		};*/
        return mBinder;
    }

    //一个类，继承了Binder，那么它的对象就可以被远程的进程使用了(前提是远程进程获取了这个类的对象【对象的引用】
    private final AIDLTest.Stub mBinder = new AIDLTest.Stub() {

        @Override
        public String hello(String name) throws RemoteException {
            // TODO Auto-generated method stub
            return "hello"+name;
        }
    };

}

