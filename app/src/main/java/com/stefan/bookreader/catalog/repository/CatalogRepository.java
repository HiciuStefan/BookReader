package com.stefan.bookreader.catalog.repository;


import com.stefan.bookreader.catalog.navigator.UserSelection;
import com.stefan.bookreader.catalog.repository.network.BooksNetworkRepository;
import com.stefan.bookreader.networking.model.Volumes;

import javax.inject.Inject;

import io.reactivex.Single;

public class CatalogRepository {

    private BooksNetworkRepository booksNetworkRepository;

    @Inject

    public CatalogRepository(BooksNetworkRepository booksNetworkRepository) {
        this.booksNetworkRepository = booksNetworkRepository;
    }


    public Single<Volumes> getVolumes(UserSelection userSelection) {
        return booksNetworkRepository.getVolumes(userSelection);
    }
}
