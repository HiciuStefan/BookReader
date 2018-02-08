package com.stefan.bookreader.di;


import android.app.Application;

import com.stefan.bookreader.BookReaderApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Override
    void inject(DaggerApplication application);

    void inject(BookReaderApp hypnoWebApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
