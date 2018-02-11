package com.stefan.bookreader.catalog.navigator;


import android.content.Context;

import com.stefan.bookreader.catalog.ui.CatalogActivity;

import javax.inject.Inject;


public class CatalogNavigator {

    private Context context;


    public CatalogNavigator(Context context) {
        this.context = context;
    }

    public void goToCatalog(UserSelection userSelection) {
        ((CatalogActivity) context).goToCatalogFragment(userSelection);
    }

    public void goToBookDetails(String bookId) {
        ((CatalogActivity) context).goToBookDetails(bookId);
    }
}
