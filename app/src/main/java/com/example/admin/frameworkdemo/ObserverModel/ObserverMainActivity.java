package com.example.admin.frameworkdemo.ObserverModel;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class ObserverMainActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user1 = new User("张三");
        User user2 = new User("李四");
        WechatServer server = new WechatServer();
        server.register(user1);
        server.register(user2);
        server.setInfo("我要下班了");
    }
}
