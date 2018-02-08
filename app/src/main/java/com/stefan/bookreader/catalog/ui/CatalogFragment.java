package com.stefan.bookreader.catalog.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.bookreader.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogFragment extends DaggerFragment {

    @Inject
    CatalogViewModel catalogViewModel;

    public static CatalogFragment newInstance() {

        Bundle args = new Bundle();
        CatalogFragment fragment = new CatalogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CatalogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);

        /*FragmentCatalogBinding binding = DataBindingUtil.bind(view);*/

        return view;
    }

}
