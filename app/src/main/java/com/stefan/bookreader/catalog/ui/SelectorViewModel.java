package com.stefan.bookreader.catalog.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;

import javax.inject.Inject;

public class SelectorViewModel extends AndroidViewModel {

    public ObservableField<String> bookName = new ObservableField<>();
    public String selectedLanguage = new String();

    @Inject
    public SelectorViewModel(Application application) {
        super(application);
    }

    public void setLanguageSelected(String itemAtPosition) {
        selectedLanguage = itemAtPosition;
    }


    public void onContinue(){

    }
}
