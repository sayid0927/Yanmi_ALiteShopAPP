package com.aliteshopapp.injector.http.component.activity;


import com.aliteshopapp.injector.http.LoginHttpModule;
import com.aliteshopapp.ui.activity.RegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { LoginHttpModule.class})
public interface RegisterComponent {
    void injectLogin(RegisterActivity registerActivity);
}
