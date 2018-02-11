package com.stefan.bookreader.di;

import com.stefan.bookreader.bookdetails.ui.BookDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BookActivityFragments {


    @ContributesAndroidInjector
    abstract BookDetailsFragment providesBookDetailsFragment();

}
