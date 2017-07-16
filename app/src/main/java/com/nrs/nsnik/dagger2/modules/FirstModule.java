package com.nrs.nsnik.dagger2.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class FirstModule {

    @Singleton
    @Provides
    Object provideObject() {
        return new Object();
    }

}

