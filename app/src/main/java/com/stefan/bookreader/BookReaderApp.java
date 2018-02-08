package com.stefan.bookreader;


import com.stefan.bookreader.di.AppComponent;
import com.stefan.bookreader.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


public class BookReaderApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this)
                .build();
        appComponent.inject(this);
        return appComponent;
    }
}
