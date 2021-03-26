package com.kc.androidlib;

import android.app.Application;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.kc.uiwatch.UiWatcher;

public class MainApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        UiWatcher.getInstance((Application) this.getApplicationContext()).minSkipFrameTime(100).cacheSize(10, 17).startWatch();;
    }
}
