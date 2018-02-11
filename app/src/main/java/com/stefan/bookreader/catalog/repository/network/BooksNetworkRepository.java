package com.stefan.bookreader.catalog.repository.network;


import android.text.TextUtils;

import com.stefan.bookreader.catalog.navigator.UserSelection;

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


    public Single<Volumes> getVolumes(UserSelection userSelection) {
        StringBuilder stringBuilder = new StringBuilder(" ");
        stringBuilder.append(addExtra(userSelection.getBookTitle(), TITLE));
        stringBuilder.append(addExtra(userSelection.getBookAuthor(), AUTHOR));
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if(stringBuilder.length() == 0){
            stringBuilder.append("\"\"");
        }

        return booksApi.getVolumes(stringBuilder.toString(), API_KEY);
    }

    private StringBuilder addExtra(String extra, String key) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(extra)) {
            stringBuilder.append(key);
            stringBuilder.append(":");
            stringBuilder.append(extra);
            stringBuilder.append("+");
        }
        return stringBuilder;
    }

}
