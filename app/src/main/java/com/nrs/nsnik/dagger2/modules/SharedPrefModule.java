package com.nrs.nsnik.dagger2.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class SharedPrefModule {

    private Context mContext;


    public SharedPrefModule(Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

}
