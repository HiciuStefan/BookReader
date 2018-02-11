package com.stefan.bookreader.di;

import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.ui.CatalogActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by stefan on 2/10/2018.
 */


@Module
public class CatalogNavigatorModule {

    @Provides
    static CatalogNavigator catalogNavigator(CatalogActivity catalogActivity) {
        return new CatalogNavigator(catalogActivity);
    }
}
