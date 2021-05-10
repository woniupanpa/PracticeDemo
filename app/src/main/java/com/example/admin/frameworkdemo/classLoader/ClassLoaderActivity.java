package com.example.admin.frameworkdemo.classLoader;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.admin.frameworkdemo.R;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dalvik.system.DexClassLoader;
import timber.log.Timber;

/**
 * @author yanjim
 * @Date 2020/11/18 9:22
 */
public class ClassLoaderActivity extends AppCompatActivity {
    public static final String TAG = "ClassLoaderActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_class_activity);
        //PathClassLoader
        ClassLoader classLoader = getClassLoader();
        while (classLoader != null) {
            Timber.d("classLoader: " + classLoader);
            //BootClassLoader
            classLoader = classLoader.getParent();
        }
        //loadClass();
    }

    private void loadClass(){
        Intent mIntent = new Intent();
        mIntent.setClassName("com.arke.thaiSCB",
                "com.arke.util.ToolUtil");
        PackageManager pm = this.getPackageManager();
        List<ResolveInfo> mList = pm.queryIntentActivities(mIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        ResolveInfo info = mList.get(0);

        String apkPath = info.activityInfo.applicationInfo.sourceDir;
        String optPath = this.getCodeCacheDir().getAbsolutePath();
        String libPath = info.activityInfo.applicationInfo.nativeLibraryDir;

        DexClassLoader clsLoader = new DexClassLoader(apkPath, optPath,
                libPath, this.getClass().getClassLoader());
        try {

            Class cls = clsLoader
                    .loadClass("com.arke.util.ToolUtil");
            Object obj = cls.newInstance();
            Method invokeMethod = cls.getDeclaredMethod("getLong",
                    new Class[] { String.class });
            invokeMethod.setAccessible(true);
            long a = (long)invokeMethod.invoke(obj, "2222");
            Log.d(TAG, String.valueOf(a));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
