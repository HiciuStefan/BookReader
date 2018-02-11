package com.stefan.bookreader.di;


import android.app.Application;

import com.stefan.bookreader.BookReaderApp;
import com.stefan.bookreader.catalog.ui.CatalogActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerActivity;
import dagger.android.DaggerApplication;
import dagger.android.support.DaggerAppCompatActivity;


@Component(modules = {AndroidInjectionModule.class, AppModule.class, CatalogActivityModule.class,CatalogNavigatorModule.class,NetworkModule.class,BookActivityModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Override
    void inject(DaggerApplication application);

    void inject(BookReaderApp hypnoWebApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
