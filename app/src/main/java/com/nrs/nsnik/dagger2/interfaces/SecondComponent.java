package com.nrs.nsnik.dagger2.interfaces;

import com.nrs.nsnik.dagger2.fragments.SecondFragment;
import com.nrs.nsnik.dagger2.modules.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = SharedPrefModule.class)
public interface SecondComponent {
    void injectSecondFragment(SecondFragment secondFragment);
}

