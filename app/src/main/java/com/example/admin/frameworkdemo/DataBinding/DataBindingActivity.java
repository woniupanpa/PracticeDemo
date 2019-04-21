package com.example.admin.frameworkdemo.DataBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.admin.frameworkdemo.R;
import com.example.admin.frameworkdemo.databinding.DatabindingMainBinding;

public class DataBindingActivity extends Activity{
    private String imgUrl = "http://g.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03e426845ed03f8794a5c226fd.jpg";
    private DatabindingMainBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.databinding_main);
        User user = new User("小茗同学",8,"1838383883",imgUrl);
        user.setGender(1);
        //mBinding.setUser1(user);
        mBinding.btnCancel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"长按了",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mBinding.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
