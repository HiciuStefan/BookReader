package com.stefan.bookreader.catalog.ui;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.bookreader.R;
import com.stefan.bookreader.catalog.CatalogViewModel;
import com.stefan.bookreader.catalog.navigator.UserSelection;
import com.stefan.bookreader.databinding.FragmentCatalogBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogFragment extends DaggerFragment {

    private final static String USER_SELECTION = "user_selection";

    @Inject
    CatalogViewModel catalogViewModel;

    public static CatalogFragment newInstance(UserSelection userSelection) {

        Bundle args = new Bundle();
        args.putParcelable(USER_SELECTION, userSelection);
        CatalogFragment fragment = new CatalogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CatalogFragment() {
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
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        FragmentCatalogBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(catalogViewModel);
        catalogViewModel.setUserSelection(getArguments().getParcelable(USER_SELECTION));
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        catalogViewModel.bindSubscriptions();
    }

    @Override
    public void onPause() {
        super.onPause();
        catalogViewModel.unbindSubscriptions();
    }
}
