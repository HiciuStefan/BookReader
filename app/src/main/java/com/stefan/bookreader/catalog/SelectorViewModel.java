package com.stefan.bookreader.catalog;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;

import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.navigator.UserSelection;

import javax.inject.Inject;

public class SelectorViewModel extends AndroidViewModel {

    public ObservableField<String> bookName = new ObservableField<>();
    public ObservableField<String> authorName = new ObservableField<>();
    private CatalogNavigator catalogNavigator;

    @Inject
    public SelectorViewModel(Application application, CatalogNavigator catalogNavigator) {
        super(application);
        this.catalogNavigator = catalogNavigator;
    }



    public void onContinue() {
        UserSelection userSelection = new UserSelection(bookName.get(), authorName.get());
        catalogNavigator.goToCatalog(userSelection);
    }
}
