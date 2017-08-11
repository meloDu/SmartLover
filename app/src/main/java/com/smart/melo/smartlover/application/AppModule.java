package com.smart.melo.smartlover.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by melo on 2017/8/7.
 */
@Module
public class AppModule {
    MyApp mMyApp;


    public AppModule(MyApp application) {
        this.mMyApp = application;
    }


    //提供全局的context
    @Singleton
    @Provides
    public MyApp provideApplication() {
        return mMyApp;
    }

    //sharepreferences，之类都可以在这里提供

}
