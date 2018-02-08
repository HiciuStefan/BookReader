package com.stefan.bookreader.catalog.ui;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stefan.bookreader.R;
import com.stefan.bookreader.databinding.FragmentSelectorBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectorFragment extends DaggerFragment {

    @Inject
    SelectorViewModel selectorViewModel;
    public SelectorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        FragmentSelectorBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(selectorViewModel);
        return view;
    }

    public static SelectorFragment newInstance() {
        return new SelectorFragment();
    }
}
