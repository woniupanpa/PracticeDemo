package com.example.admin.frameworkdemo.Picasso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.admin.frameworkdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv_main;
    private List<News> list_new;
    private lv_Adapter lAdapter;

    public static void ListViewStar(Context context)
    {
        Intent intent = new Intent(context,ListViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_activity_list_view);

        initControls();

        initData();
    }

    /**
     * 初始化控件
     */
    private void initControls() {
        lv_main = (ListView)findViewById(R.id.lv_main);
        list_new = new ArrayList<>();
        lAdapter = new lv_Adapter(list_new,this);
        lv_main.setAdapter(lAdapter);
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        for(int i=0; i<10000;i++){
            News news = new News();
            news.setTitle("清纯的美女"+i);
            news.setContents("我不说什么，大家自己看");
            news.setPicUrl("http://g.hiphotos.baidu.com/image/pic/item/6c224f4a20a446230761b9b79c22720e0df3d7bf.jpg");
            list_new.add(news);
        }


        /*News news2 = new News();
        news2.setTitle("好看的美女");
        news2.setContents("我不说什么，大家自己看");
        news2.setPicUrl("http://f.hiphotos.baidu.com/image/pic/item/11385343fbf2b211eee0554ac88065380dd78eec.jpg");
        list_new.add(news2);

        News news1 = new News();
        news1.setTitle("狂野的美女");
        news1.setContents("我不说什么，大家自己看");
        news1.setPicUrl("http://a.hiphotos.baidu.com/image/h%3D200/sign=623f372f0b24ab18ff16e63705fbe69a/267f9e2f070828382f690e1dba99a9014c08f157.jpg");
        list_new.add(news1);

        News news4 = new News();
        news4.setTitle("小护士");
        news4.setContents("我不说什么，大家自己看");
        news4.setPicUrl("http://f.hiphotos.baidu.com/image/pic/item/738b4710b912c8fc6684dceaf9039245d68821a5.jpg");
        list_new.add(news4);

        News news5 = new News();
        news5.setTitle("古典的美女");
        news5.setContents("我不说什么，大家自己看");
        news5.setPicUrl("http://c.hiphotos.baidu.com/image/pic/item/342ac65c10385343498219169613b07eca8088bc.jpg");
        list_new.add(news5);

        News news6 = new News();
        news6.setTitle("清纯的美女");
        news6.setContents("我不说什么，大家自己看");
        news6.setPicUrl("http://c.hiphotos.baidu.com/image/pic/item/a044ad345982b2b7a2f0f7cd33adcbef76099b48.jpg");
        list_new.add(news6);

        News news7 = new News();
        news7.setTitle("清纯的美女");
        news7.setContents("我不说什么，大家自己看");
        news7.setPicUrl("http://e.hiphotos.baidu.com/image/pic/item/8b13632762d0f7031db73fdc0afa513d2697c5ad.jpg");
        list_new.add(news7);

        News news8 = new News();
        news8.setTitle("清纯的美女");
        news8.setContents("我不说什么，大家自己看");
        news8.setPicUrl("http://b.hiphotos.baidu.com/image/pic/item/9825bc315c6034a857770337ce134954082376ea.jpg");
        list_new.add(news8);*/
        lAdapter.notifyDataSetChanged();
    }
}
