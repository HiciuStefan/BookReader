package com.stefan.bookreader.di;

import com.stefan.bookreader.catalog.repository.network.BooksApi;
import com.stefan.bookreader.networking.ApiCreator;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by stefan on 2/8/2018.
 */

@Module
public class NetworkModule {

    @Inject
    public NetworkModule() {
    }


    @Provides
    public BooksApi getBooksApi(ApiCreator apiCreator) {
        return apiCreator.getBooksApi();
    }
}
