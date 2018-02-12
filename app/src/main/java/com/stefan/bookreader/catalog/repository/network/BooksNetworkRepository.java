package com.stefan.bookreader.catalog.repository.network;


import android.support.annotation.NonNull;

import com.stefan.bookreader.catalog.navigator.UserSelection;
import com.stefan.bookreader.networking.BooksApi;
import com.stefan.bookreader.networking.model.Volumes;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.stefan.bookreader.BuildConfig.API_KEY;

public class BooksNetworkRepository {

    private final String TITLE = "intitle";
    private final String AUTHOR = "inauthor";
    private BooksApi booksApi;

    @Inject
    public BooksNetworkRepository(BooksApi booksApi) {
        this.booksApi = booksApi;
    }


    public Single<Volumes> getVolumes(@NonNull UserSelection userSelection) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(addExtra(userSelection.getBookTitle(), TITLE));
        stringBuilder.append(addExtra(userSelection.getBookAuthor(), AUTHOR));

        if (stringBuilder.length() == 0) {
            stringBuilder.append("\"\"");
        } else {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return booksApi.getVolumes(stringBuilder.toString(), API_KEY);
    }

    private StringBuilder addExtra(String extra, String key) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (extra != null && !extra.isEmpty()) {
            stringBuilder.append(key);
            stringBuilder.append(":");
            stringBuilder.append(extra);
            stringBuilder.append("+");
        }
        return stringBuilder;
    }

}
