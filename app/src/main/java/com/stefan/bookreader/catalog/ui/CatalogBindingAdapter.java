package com.stefan.bookreader.catalog.ui;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public final class CatalogBindingAdapter {


    private CatalogBindingAdapter() {
        //nothing to be done here
    }

    @BindingAdapter("books")
    public static void setCatalogBooks(RecyclerView recyclerView, CatalogViewModel dummy) {

    }

    @BindingAdapter({"availableLanguages","viewModel"})
    public static void setAvailableLanguages(Spinner spinner, String[] languages,SelectorViewModel selectorViewModel) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectorViewModel.setLanguageSelected(((String )adapterView.getItemAtPosition(position)));
                adapterView.setSelection(position);

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
