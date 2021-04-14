package com.example.admin.frameworkdemo.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.frameworkdemo.R;

import java.util.ArrayList;

import io.reactivex.Emitter;
import io.reactivex.Observable;

// ref:https://blog.csdn.net/liang_fei_xp/article/details/77892730
public class InputPassword extends Dialog implements View.OnClickListener {
    private TextView dspTextView;
    private TextView tipTextView;
    private String inputPwdStr = "";
    private ArrayList<String> expectPasswordList = new ArrayList<>();
    private Emitter emitter = null;
    private InputPassword inputPassword = null;

    public InputPassword(Context context, String title) {
        super(context, R.style.ActivityDialog);
        initDialog(title);
    }

    public interface PasswordCallback {
        void callback(String password);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Timber.d("InputPassword -> onCreate");
        super.onCreate(savedInstanceState);
    }


    public PasswordCallback mPasswordCallback;

    public Emitter getEmitter() {
        return emitter;
    }

    public void setEmitter(Emitter emitter) {
        this.emitter = emitter;
    }

    public InputPassword getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(InputPassword inputPassword) {
        this.inputPassword = inputPassword;
    }

    void initDialog(String tip) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_input_password);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        dspTextView = (TextView) findViewById(R.id.dsp_password);
        tipTextView = (TextView) findViewById(R.id.tip);
        tipTextView.setText(tip);

        findViewById(R.id.dialog_close).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_del).setOnClickListener(this);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    /**
     * 重制
     */
    public void clearPasswordText() {
        inputPwdStr = "";
        dspTextView.setText(inputPwdStr);
        dspTextView.requestFocus();
    }

    /**
     * 设置回调
     *
     * @param passwordCallback
     */
    public void setPasswordCallback(PasswordCallback passwordCallback) {
        this.mPasswordCallback = passwordCallback;
    }

    /**
     * Backspace.
     */
    public void backspace() {
        if (inputPwdStr.length() < 1) {
            return;
        }
        inputPwdStr = inputPwdStr.substring(0, inputPwdStr.length() - 1);
        dspTextView.setText(inputPwdStr);
    }

    /**
     * Confirm
     */
    public void confirm() {
        //Timber.d("confirm:" + inputPwdStr);
        mPasswordCallback.callback(inputPwdStr);
    }

    /**
     * Close dialog
     */
    public void closeDialog(boolean result) {
        if (null != getInputPassword() && null != getEmitter()) {
            getInputPassword().dismiss();
            getEmitter().onNext(result);
            getEmitter().onComplete();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_close:
                closeDialog(false);
                return;
            case R.id.btn_del:
                backspace();
                return;
            case R.id.btn_ok:
                confirm();
                return;
            case R.id.btn_1:
                inputPwdStr += "1";
                break;
            case R.id.btn_2:
                inputPwdStr += "2";
                break;
            case R.id.btn_3:
                inputPwdStr += "3";
                break;
            case R.id.btn_4:
                inputPwdStr += "4";
                break;
            case R.id.btn_5:
                inputPwdStr += "5";
                break;
            case R.id.btn_6:
                inputPwdStr += "6";
                break;
            case R.id.btn_7:
                inputPwdStr += "7";
                break;
            case R.id.btn_8:
                inputPwdStr += "8";
                break;
            case R.id.btn_9:
                inputPwdStr += "9";
                break;
            case R.id.btn_0:
                inputPwdStr += "0";
                break;
        }
        dspTextView.setText(inputPwdStr);
    }

    private void clearPassword(){
        expectPasswordList.clear();
    }

    private void addPassword(String passWord){
        expectPasswordList.add(passWord);
    }


    public static Observable inputPassword(Context context, String title, String password) {
        return Observable.create(emitter -> {
            InputPassword inputPasswordDialog = new InputPassword(context, title);
            inputPasswordDialog.setEmitter(emitter);
            inputPasswordDialog.clearPassword();
            inputPasswordDialog.addPassword(password);
            inputPasswordDialog.setInputPassword(inputPasswordDialog);
            inputPasswordDialog.setPasswordCallback(new PasswordCallback() {
                @Override
                public void callback(String password) {
                    if (inputPasswordDialog.expectPasswordList.contains(password)) {
                        inputPasswordDialog.closeDialog(true);
                    } else {
                        Toast.makeText(context, context.getString(R.string.password_error), Toast.LENGTH_SHORT).show();
                        inputPasswordDialog.clearPasswordText();
                    }
                }
            });
            inputPasswordDialog.clearPasswordText();
            inputPasswordDialog.show();
        });
    }
}