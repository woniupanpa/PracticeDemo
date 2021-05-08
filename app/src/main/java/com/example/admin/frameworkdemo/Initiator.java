package com.example.admin.frameworkdemo;

import timber.log.Timber;

/**
 * @author yanjim
 * @Date 2021/5/6 18:48
 */
public class Initiator {
    public void activate(){
        // Init log
        initLog();
    }

    /**
     * Init log
     */
    private void initLog() {
        if (BuildConfig.DEBUG ) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
