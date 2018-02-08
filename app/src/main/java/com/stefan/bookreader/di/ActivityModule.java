package com.stefan.bookreader.di;


import com.stefan.bookreader.catalog.ui.CatalogActivity;

import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {FragmentsModule.class})
    @ActivityKey(CatalogActivity.class)
    abstract CatalogActivity provideCatalogActivity();
}
