package com.stefan.bookreader.bookdetails;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.stefan.bookreader.networking.model.Volume;
import com.stefan.bookreader.bookdetails.repository.BookRepository;
import com.stefan.bookreader.viewmodel.ViewModelSubscriptions;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class BookDetailsViewModel extends AndroidViewModel implements ViewModelSubscriptions {

    public ObservableField<Volume> volume;
    private BookRepository bookRepository;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private String bookId;

    @Inject
    public BookDetailsViewModel(@NonNull Application application, BookRepository bookRepository) {
        super(application);
        volume = new ObservableField<>();
        this.bookRepository = bookRepository;

    }

    @Override
    public void bindSubscriptions() {
        compositeDisposable.add(bookRepository.getVolume(bookId)
                .subscribeOn(Schedulers.io())
                .subscribe(book1 -> {
                            volume.set(book1);
                        },
                        throwable -> {
                            Timber.e(throwable);
                        }));

    }

    @Override
    public void unbindSubscriptions() {

    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
