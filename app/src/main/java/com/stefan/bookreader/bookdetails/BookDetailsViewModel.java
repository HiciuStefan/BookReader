package com.stefan.bookreader.bookdetails;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.stefan.bookreader.bookdetails.repository.BookRepository;
import com.stefan.bookreader.networking.model.Volume;
import com.stefan.bookreader.viewmodel.ViewModelSubscriptions;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class BookDetailsViewModel extends AndroidViewModel implements ViewModelSubscriptions {

    public ObservableField<Volume> volume;
    private BookRepository bookRepository;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    String bookId;

    @Inject
    public BookDetailsViewModel(@NonNull Application application, BookRepository bookRepository) {
        super(application);
        volume = new ObservableField<>();
        this.bookRepository = bookRepository;

    }

    @Override
    public void bindSubscriptions() {
        compositeDisposable.add(getVolumeSingle().subscribeOn(Schedulers.io())
                .subscribe(Functions.emptyConsumer(),
                        throwable -> {
                            Timber.e(throwable);
                        }));

    }

    Single<Volume> getVolumeSingle() {
        return bookRepository.getVolume(bookId)
                .doOnSuccess(book1 -> volume.set(book1));
    }

    @Override
    public void unbindSubscriptions() {

    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
