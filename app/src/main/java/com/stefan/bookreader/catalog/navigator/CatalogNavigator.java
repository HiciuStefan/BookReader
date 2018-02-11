package com.stefan.bookreader.catalog.navigator;


import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.stefan.bookreader.catalog.ui.CatalogActivity;

import javax.inject.Inject;

import dagger.android.ActivityKey;



public class CatalogNavigator {

    private Context context;

    public CatalogNavigator(Context context) {
        this.context = context;
    }

    public void goToCatalog(UserSelection userSelection) {
        ((CatalogActivity)context).goToCatalogFragment(userSelection);
    }

    public void goToBookDetails(String bookId) {
        ((CatalogActivity)context).goToBookDetails(bookId);
    }
}
