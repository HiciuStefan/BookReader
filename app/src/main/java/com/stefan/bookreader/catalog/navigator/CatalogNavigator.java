package com.stefan.bookreader.catalog.navigator;


import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.stefan.bookreader.catalog.ui.CatalogActivity;


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

    //added here just to have a way to do this , but it's not proper...
    @Deprecated
    public void showError(String localizedMessage) {
        ((Activity)context).runOnUiThread(() -> Toast.makeText(context, localizedMessage, Toast.LENGTH_SHORT).show());

    }
}
