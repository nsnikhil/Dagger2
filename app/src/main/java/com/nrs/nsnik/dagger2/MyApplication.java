package com.nrs.nsnik.dagger2;

import android.app.Application;

import com.nrs.nsnik.dagger2.interfaces.DaggerFirstComponent;
import com.nrs.nsnik.dagger2.interfaces.DaggerSecondComponent;
import com.nrs.nsnik.dagger2.interfaces.FirstComponent;
import com.nrs.nsnik.dagger2.interfaces.SecondComponent;
import com.nrs.nsnik.dagger2.modules.SharedPrefModule;


public class MyApplication extends Application {

    FirstComponent mFirstComponent;
    SecondComponent mSecondComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        setFirstComponent();
        setSecondComponent();
    }

    private void setFirstComponent() {
        mFirstComponent = DaggerFirstComponent.builder().build();
    }

    public FirstComponent getFirstComponent() {
        return mFirstComponent;
    }

    public void setSecondComponent() {
        mSecondComponent = DaggerSecondComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
    }

    public SecondComponent getSecondComponent() {
        return mSecondComponent;
    }
}
