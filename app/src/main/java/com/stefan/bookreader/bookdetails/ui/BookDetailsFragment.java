package com.stefan.bookreader.bookdetails.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.bookreader.R;
import com.stefan.bookreader.bookdetails.BookDetailsViewModel;
import com.stefan.bookreader.databinding.FragmentBookDetailsBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

import static com.stefan.bookreader.bookdetails.ui.BookDetailsActivity.BOOK_ID;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends DaggerFragment {

    @Inject
    BookDetailsViewModel bookDetailsViewModel;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_book_details, container, false);
        FragmentBookDetailsBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(bookDetailsViewModel);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        bookDetailsViewModel.setBookId(getArguments().getString(BOOK_ID));
        bookDetailsViewModel.bindSubscriptions();
    }

    @Override
    public void onStop() {
        super.onStop();
        bookDetailsViewModel.unbindSubscriptions();
    }
}
