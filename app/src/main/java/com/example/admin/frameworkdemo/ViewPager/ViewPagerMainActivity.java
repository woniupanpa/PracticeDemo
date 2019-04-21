package com.example.admin.frameworkdemo.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.admin.frameworkdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerMainActivity extends AppCompatActivity {

    private View view1, view2, view3;
    private ViewPager viewPager;  //对应的viewPager

    private List<View> viewList;//view数组

    private TabLayout tablayout;

    //数据源
    private String[] titles = {"头条", "新闻", "娱乐", "体育", "美女", "科技", "财经", "汽车", "彩票", "国际", "推荐",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.viewpager_activity_main);

        tablayout = (TabLayout) findViewById(R.id.tablayout);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.viewpager_layout1, null);
        view2 = inflater.inflate(R.layout.viewpager_layout2,null);
        view3 = inflater.inflate(R.layout.viewpager_layout3, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //pagerAdapter
        viewPager.setAdapter(pagerAdapter);

        //FragmentPagerAdapter + TagLayout

        /*MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tablayout.setupWithViewPager(viewPager);*/
    }


    PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return viewList.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            // TODO Auto-generated method stub
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(viewList.get(position));


            return viewList.get(position);
        }
    };

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            TestFragment testFragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", titles[position]);
            testFragment.setArguments(bundle);
            return testFragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }
}
