package com.example.admin.frameworkdemo.ui.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.frameworkdemo.R;

/**
 * @author yanjim
 * @Date 2021/3/29 11:05
 */
//https://blog.csdn.net/liang_fei_xp/article/details/77892730
public class InputPasswordDialogTestActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pwd_dialog_test);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });

    }

    private void clickButton(){
        InputPassword.inputPassword(this, "", "5555")
                .subscribe(result -> {
                    if ((Boolean) result) {
                        //this.getApplication().onTerminate();
                        //finish();
                    } else {
                        return;
                    }
                }, throwable -> {
                    // Timber.e(throwable.toString());
                });
    }
}
