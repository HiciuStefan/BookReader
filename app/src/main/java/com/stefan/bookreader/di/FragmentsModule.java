package com.stefan.bookreader.di;


import com.stefan.bookreader.catalog.ui.BookDetailsFragment;
import com.stefan.bookreader.catalog.ui.CatalogFragment;
import com.stefan.bookreader.catalog.ui.SelectorFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract CatalogFragment provideCatalogFragment();

    @ContributesAndroidInjector
    abstract SelectorFragment provideSelectorFragment();

    @ContributesAndroidInjector
    abstract BookDetailsFragment providesBookDetailsFragment();
}
