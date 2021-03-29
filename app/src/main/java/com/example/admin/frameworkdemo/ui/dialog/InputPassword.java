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
    public static final String DEFAULT_PWD = "0000";
    public static final String DEVELOP_PWD = "369369";
    private TextView dspTextView;
    private TextView tipTextView;
    private String inputPwdStr = "";
    private ArrayList<String> expectPasswordList = new ArrayList<>();
    private Emitter emitter = null;
    private InputPassword inputPassword = null;
    public boolean onlySuperAdminPassword = false;


    public InputPassword(Context context, boolean onlySuperAdminPassword) {
        super(context, R.style.ActivityDialog);
        setOnlySuperAdminPassword(onlySuperAdminPassword);
        initDilaog("");
    }

    public InputPassword(Context context, String title) {
        super(context, R.style.ActivityDialog);
        initDilaog(title);
    }

    public interface PasswordCallback {
        void callback(String password);
    }

    @Override
    public void onAttachedToWindow() {
        // FIX ISSUE #47-A8MBBMY01.23.1
        // REF:https://blog.csdn.net/kernel_jim_wu/article/details/9415775
        // Android 下 Dialog 及 Activity 屏蔽 Home 键
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
//        }
        super.onAttachedToWindow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    /**
     * Init check password
     */
    private void initPassword() {
        expectPasswordList.clear();
       /* DynamicPassword dynamicPassword = new DynamicPassword();
        if (ITMS.isAllParametersInitialized()) {
            expectPasswordList.add(dynamicPassword.getSuperadminPassword());
            if (!isOnlySuperAdminPassword()) {
                expectPasswordList.add(dynamicPassword.getTechnicianPassword());
            }
            // FOR DEVELOP TEST
            expectPasswordList.add(DEVELOP_PWD);
        } else {
            expectPasswordList.add(DEFAULT_PWD);
        }*/
        expectPasswordList.add(DEFAULT_PWD);
    }

    void initDilaog(String tip) {
        initPassword();
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
//            if(result){
            getEmitter().onNext(result);
            getEmitter().onComplete();
//            }else{
//                getEmitter().onError(new Throwable(ArkeApplication.getContext().getString(R.string.cancel)));
//            }
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

    public boolean isOnlySuperAdminPassword() {
        return onlySuperAdminPassword;
    }

    public void setOnlySuperAdminPassword(boolean onlySuperAdminPassword) {
        this.onlySuperAdminPassword = onlySuperAdminPassword;
    }

    private void clearPassword(){
        expectPasswordList.clear();
    }

    private void addPassword(String passWord){
        expectPasswordList.add(passWord);
    }


    public static Observable inputPassword(Context context, boolean onlySuperAdminPassword) {
        return Observable.create(emitter -> {
            InputPassword inputPasswordDialog = new InputPassword(context, onlySuperAdminPassword);
            inputPasswordDialog.setEmitter(emitter);
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

    public static Observable inputPassword(Context context, String title) {
        return Observable.create(emitter -> {
            InputPassword inputPasswordDialog = new InputPassword(context, title);
            inputPasswordDialog.setEmitter(emitter);
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