package com.stefan.bookreader.bookdetails.repository;

import com.stefan.bookreader.BuildConfig;
import com.stefan.bookreader.networking.BooksApi;
import com.stefan.bookreader.networking.model.Volume;

import javax.inject.Inject;

import io.reactivex.Single;

public class BookRepository {

    private BooksApi booksApi;

    @Inject
    public BookRepository(BooksApi booksApi) {
        this.booksApi = booksApi;
    }

    public Single<Volume> getVolume(String id){
        return booksApi.getVolume(id, BuildConfig.API_KEY);
    }
}
