package com.stefan.bookreader.bookdetails.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.stefan.bookreader.R;

import dagger.android.support.DaggerAppCompatActivity;

public class BookDetailsActivity extends DaggerAppCompatActivity {
    public static final String BOOK_ID = "book_id";


    public BookDetailsActivity() {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_frame_activity);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, BookDetailsFragment.newInstance(getIntent().getStringExtra(BOOK_ID))).commit();
    }


}
