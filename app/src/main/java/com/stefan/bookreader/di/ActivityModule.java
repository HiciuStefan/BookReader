package com.stefan.bookreader.di;


import android.app.Application;
import android.content.Context;

import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.ui.CatalogActivity;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;
import dagger.android.DaggerActivity;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {FragmentsModule.class,CatalogNavigatorModule.class})
    @ActivityKey(CatalogActivity.class)
    abstract CatalogActivity provideCatalogActivity();


}
