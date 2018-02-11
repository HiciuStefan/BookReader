package com.stefan.bookreader.di;


import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.ui.CatalogActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {ViewModelSubComponent.class})
public class AppModule {

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ViewModelFactory(viewModelSubComponent.build());
    }

    @Provides
    Context providesContext(Application application) {
        return application.getApplicationContext();
    }

}
