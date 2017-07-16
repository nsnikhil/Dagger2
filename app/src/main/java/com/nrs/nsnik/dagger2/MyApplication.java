package com.nrs.nsnik.dagger2;

import android.app.Application;

import com.nrs.nsnik.dagger2.interfaces.FirstComponent;

import dagger.android.DaggerApplication;

public class MyApplication extends Application {

    FirstComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        setFirstComponent();
    }

    private void setFirstComponent(){
    }
}
