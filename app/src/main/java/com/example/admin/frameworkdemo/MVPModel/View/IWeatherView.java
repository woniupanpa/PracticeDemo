package com.example.admin.frameworkdemo.MVPModel.View;

public interface IWeatherView {
	public void onInfoUpdate(String info);

	public void showWaitingDialog();

	public void dissmissWaitingDialog();

}
