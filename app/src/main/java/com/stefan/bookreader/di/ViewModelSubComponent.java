package com.stefan.bookreader.di;


import android.app.Activity;
import android.content.Context;

import com.stefan.bookreader.catalog.CatalogViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    CatalogViewModel provideCatalogViewModel();
}
