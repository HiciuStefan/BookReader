package com.stefan.bookreader.catalog.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.bookreader.R;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends DaggerFragment {

    public static final String BOOK_ID = "book_id";

    public static BookDetailsFragment newInstance(String bookId) {
        BookDetailsFragment detailsFragment = new BookDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BOOK_ID, bookId);
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }

    public BookDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false);
    }


}
