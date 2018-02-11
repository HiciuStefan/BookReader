package com.stefan.bookreader.catalog;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.stefan.bookreader.catalog.navigator.CatalogNavigator;
import com.stefan.bookreader.catalog.navigator.UserSelection;
import com.stefan.bookreader.catalog.repository.network.BooksNetworkRepository;
import com.stefan.bookreader.networking.model.Volumes;
import com.stefan.bookreader.viewmodel.ViewModelSubscriptions;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class CatalogViewModel extends AndroidViewModel implements ViewModelSubscriptions, CatalogActions {

    private UserSelection userSelection;
    private BooksNetworkRepository booksNetworkRepository;
    private CatalogNavigator catalogNavigator;
    CompositeDisposable compositeDisposable;
    public ObservableField<Volumes> volumes;
    public ObservableBoolean loading = new ObservableBoolean();

    @Inject
    public CatalogViewModel(@NonNull Application application, BooksNetworkRepository booksNetworkRepository, CatalogNavigator catalogNavigator) {
        super(application);
        this.booksNetworkRepository = booksNetworkRepository;
        this.catalogNavigator = catalogNavigator;
        volumes = new ObservableField<>();

    }

    @Override
    public void bindSubscriptions() {
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(
                booksNetworkRepository
                        .getVolumes(userSelection)
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(disposable -> loading.set(true))
                        .subscribe(networkVolumes -> {
                                    volumes.set(networkVolumes);
                                    loading.set(false);
                                },
                                throwable -> {
                                    Timber.e(throwable);
                                    loading.set(false);
                                }));
    }

    @Override
    public void unbindSubscriptions() {
        compositeDisposable.dispose();
    }

    public void setUserSelection(UserSelection userSelection) {
        this.userSelection = userSelection;
    }

    @Override
    public void onBookClicked(String bookId) {
        catalogNavigator.goToBookDetails(bookId);
    }
}
