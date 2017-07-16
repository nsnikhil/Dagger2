package com.nrs.nsnik.dagger2.modules;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstModule {

    @Provides
    public Object provideObject(){
        return new Object();
    }

}
