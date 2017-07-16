package com.nrs.nsnik.dagger2.interfaces;

import com.nrs.nsnik.dagger2.fragments.FirstFragment;
import com.nrs.nsnik.dagger2.modules.FirstModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = FirstModule.class)
public interface FirstComponent {
    void injectInFirstFragment(FirstFragment firstFragment);
}

