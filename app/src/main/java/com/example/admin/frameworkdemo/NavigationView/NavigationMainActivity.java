package com.example.admin.frameworkdemo.NavigationView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.frameworkdemo.R;

public class NavigationMainActivity extends Activity{
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = (DrawerLayout)findViewById(R.id.nadrawerlayout);
        View headerView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //在这里处理item的点击事件
                switch (menuItem.getItemId()){
                    case R.id.favorite:
                        Snackbar.make(navigationView,"收藏", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.wallet:
                        Snackbar.make(navigationView,"钱包", Snackbar.LENGTH_LONG).show();
                        break;

                }
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

}
