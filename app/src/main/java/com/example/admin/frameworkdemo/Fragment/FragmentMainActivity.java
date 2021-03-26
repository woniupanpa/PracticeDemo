package com.example.admin.frameworkdemo.Fragment;

import com.example.admin.frameworkdemo.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

//https://blog.csdn.net/djun100/article/details/84470612?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
public class FragmentMainActivity extends Activity implements LeftFragment.MyListener {
    private Button button01, button02;
    private Fragment fragment01;
    /** 得到RightFragment中显示信息的控件 */
    private TextView showMessageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_main);
        System.out.println("Activity--->onCreate");

        //FragmentManager主要用于在Activity中操作Fragment
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();  //开启一个事务
        // 动态增加Fragment
        RightFragment rightFragment = new RightFragment();
        LeftFragment leftFragment = new LeftFragment();
        //transaction.add往Activity中添加一个Fragment
        //transaction.remove()
        // 从Activity中移除一个Fragment，如果被移除的Fragment没有添加到回退栈（回退栈后面会详细说），这个Fragment实例将会被销毁。
        transaction.add(R.id.left_layout, leftFragment, "leftfragment");
        transaction.add(R.id.right_layout, rightFragment, "rightfragment");
        transaction.commit(); //提交一个事务

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        System.out.println("Activity--->onResume"); //注意：findview放到这里
        showMessageView = (TextView) findViewById(R.id.right_show_message);
    }

    public void showMessage(int index)
    {
        if (1 == index)
            showMessageView.setText("第一页");
        if (2 == index)
            showMessageView.setText("第二页");
        if (3 == index)
            showMessageView.setText("第三页");
    }



}