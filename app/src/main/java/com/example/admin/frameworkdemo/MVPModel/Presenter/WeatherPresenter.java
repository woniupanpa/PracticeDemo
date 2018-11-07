package com.example.admin.frameworkdemo.MVPModel.Presenter;

import com.example.admin.frameworkdemo.MVPModel.Model.IWeathreImpl;
import com.example.admin.frameworkdemo.MVPModel.Model.IWeathreModel;
import com.example.admin.frameworkdemo.MVPModel.View.IWeatherView;

public class WeatherPresenter {

    IWeathreModel mModel;
    IWeatherView mView;

    public WeatherPresenter(IWeatherView mView) {
        this.mView = mView;
        mModel = new IWeathreImpl();
    }

    public void requestWetherInfo(){
        getNetworkInfo();
    }

    private void showWaitingDialog(){
        if (mView != null) {
            mView.showWaitingDialog();
        }
    }

    private void dissmissWaitingDialog(){
        if (mView != null) {
            mView.dissmissWaitingDialog();
        }
    }

    private void updateWetherInfo(String info){
        if (mView != null) {
            mView.onInfoUpdate(info);
        }
    }

    private void saveInfo(String info){
        mModel.setInfo(info);
    }

    private String localInfo(){
        return mModel.getInfo();
    }

    private void getNetworkInfo(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //打开等待对话框
                    showWaitingDialog();
                    //模拟网络耗时
                    Thread.sleep(6000);

                    String info = "21度，晴转多云";
                    //保存到Model层
                    saveInfo(info);
                    //从Model层获取数据，为了演示效果，实际开发中根据情况需要。
                    String localinfo = localInfo();

                    //通知View层改变视图
                    updateWetherInfo(localinfo);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //取消对话框
                    dissmissWaitingDialog();
                }
            }
        }).start();
    }
}
