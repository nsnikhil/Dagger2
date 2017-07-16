package com.nrs.nsnik.dagger2.interfaces;

import com.nrs.nsnik.dagger2.modules.FirstModule;

import dagger.Component;

@Component(modules = FirstModule.class)
public interface FirstComponent {
    Object getObject();
}
