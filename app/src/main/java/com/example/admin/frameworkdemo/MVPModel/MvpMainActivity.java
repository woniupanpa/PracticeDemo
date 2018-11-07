package com.example.admin.frameworkdemo.MVPModel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.frameworkdemo.MVPModel.Presenter.WeatherPresenter;
import com.example.admin.frameworkdemo.MVPModel.View.IWeatherView;
import com.example.admin.frameworkdemo.R;

public class MvpMainActivity extends Activity implements IWeatherView {
    private static final String TAG = "MvpMainActivity";

    WeatherPresenter mPresenter;
    private TextView mTvInfo;
    private Button mButton;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity_main);

        mPresenter = new WeatherPresenter(this);

        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mButton = (Button) findViewById(R.id.btn_request);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.requestWetherInfo();
            }
        });
    }

    @Override
    public void onInfoUpdate(final String info) {
        Log.d(TAG, "onInfoUpdate: " + info);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvInfo.setText(info);
            }
        });
    }

    @Override
    public void showWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }

                mDialog = ProgressDialog.show(MvpMainActivity.this, "", "正在获取中...");
            }
        });

    }

    @Override
    public void dissmissWaitingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        });

    }
}
