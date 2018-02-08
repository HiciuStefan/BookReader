package com.stefan.bookreader.catalog.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;


public class CatalogViewModel extends AndroidViewModel {

    @Inject
    public CatalogViewModel(@NonNull Application application) {
        super(application);
    }
}
