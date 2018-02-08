package com.stefan.bookreader;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BookReaderApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        return null;
    }
}
