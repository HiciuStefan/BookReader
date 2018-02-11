package com.stefan.bookreader.di;

import android.support.v4.app.FragmentActivity;

import com.stefan.bookreader.catalog.CatalogActions;
import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.ui.CatalogActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.DaggerAppCompatActivity;

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
