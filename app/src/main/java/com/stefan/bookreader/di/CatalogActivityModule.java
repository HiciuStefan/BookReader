package com.stefan.bookreader.di;


import com.stefan.bookreader.catalog.ui.CatalogActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;

@Module()
public abstract class CatalogActivityModule {
    @ContributesAndroidInjector(modules = {CatalogFragmentsModule.class,CatalogNavigatorModule.class})
    @ActivityKey(CatalogActivity.class)
    abstract CatalogActivity provideCatalogActivity();

}
