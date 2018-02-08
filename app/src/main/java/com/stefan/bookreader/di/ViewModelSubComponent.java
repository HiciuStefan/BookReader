package com.stefan.bookreader.di;


import com.stefan.bookreader.catalog.ui.CatalogViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    CatalogViewModel provideCatalogViewModel();
}
