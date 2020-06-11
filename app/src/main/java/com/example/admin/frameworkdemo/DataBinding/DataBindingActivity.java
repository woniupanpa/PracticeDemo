package com.example.admin.frameworkdemo.DataBinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.admin.frameworkdemo.R;
import com.example.admin.frameworkdemo.databinding.DatabindingMainBinding;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class DataBindingActivity extends Activity{
    private static final String TAG = DataBindingActivity.class.getSimpleName();
    private String imgUrl = "http://g.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03e426845ed03f8794a5c226fd.jpg";
    private DatabindingMainBinding mBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.databinding_main);
        User user = new User("小茗同学",8,"1838383883",null);
        user.setGender(1);
        mBinding.setUser1(user);
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

        //ObjectValueTest();
    }


    public void ObjectValueTest(){
        Map<String, Student> stuMap = new LinkedHashMap<>();
        Student st1 = new Student(18, "jake");
        Student st2 = new Student(19, "mike");
        Student st3 = new Student(20, "jordan");
        stuMap.put("stu1", st1);
        stuMap.put("stu2", st2);
        stuMap.put("stu3", st3);
        for(String key:stuMap.keySet()){
            Log.d(TAG, "beforeName--->" + stuMap.get(key).getName());
            setMapValue(stuMap.get(key));
            Log.d(TAG, "afterName--->" + stuMap.get(key).getName());
        }
    }

    public void setMapValue(Student stu){
        Student student = new Student();
        student = stu;
        student.setName("YanJimiao");
    }
    private class Student{
        private int age;
        private String name;

        public Student() {
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
