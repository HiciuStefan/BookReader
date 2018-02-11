package com.stefan.bookreader.di;

import com.stefan.bookreader.bookdetails.ui.BookDetailsActivity;

import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.ContributesAndroidInjector;



@Module
public abstract class BookActivityModule {

    @ContributesAndroidInjector(modules = {BookActivityFragments.class})
    @ActivityKey(BookDetailsActivity.class)
    abstract BookDetailsActivity provideBookDetailsActivity();

}
