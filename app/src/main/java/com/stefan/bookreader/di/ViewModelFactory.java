package com.stefan.bookreader.di;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.stefan.bookreader.bookdetails.BookDetailsViewModel;
import com.stefan.bookreader.catalog.CatalogViewModel;
import com.stefan.bookreader.catalog.navigator.CatalogNavigator;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public ViewModelFactory(ViewModelSubComponent viewModelSubComponent) {
        creators = new ArrayMap<>();
        creators.put(CatalogViewModel.class, () -> viewModelSubComponent.provideCatalogViewModel());
        creators.put(BookDetailsViewModel.class, () -> viewModelSubComponent.provideBookDetailViewModel());
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator != null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }

        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

