package com.stefan.bookreader.catalog.ui;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.stefan.bookreader.R;
import com.stefan.bookreader.catalog.CatalogActions;
import com.stefan.bookreader.catalog.SelectorViewModel;
import com.stefan.bookreader.catalog.repository.network.Volumes;

import java.math.BigDecimal;
import java.util.List;

public final class CatalogBindingAdapter {


    private CatalogBindingAdapter() {
        //nothing to be done here
    }

    @BindingAdapter({"books", "eventHandler"})
    public static void setCatalogBooks(RecyclerView recyclerView, Volumes volumes, CatalogActions catalogActions) {
        if (volumes == null || volumes.getItems()==null) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            VolumesViewAdapter adapter = new VolumesViewAdapter(volumes, catalogActions);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        }
    }

    @BindingAdapter("img")
    public static void setImageViewImage(ImageView imageView, String imageUrl) {
        if (imageUrl == null) {
            Picasso.with(imageView.getContext()).load(R.drawable.no_book_cover).fit().into(imageView);
            return;
        }
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(R.drawable.no_book_cover).fit().into(imageView);
    }

    @BindingAdapter("text")
    public static void setCatalogBooks(TextView textView, List<String> stringList) {
        if (stringList == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String string : stringList) {
            sb.append(string);
            sb.append(",");
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        textView.setText(sb);
    }


    @BindingAdapter("ratings")
    public static void setRatingsText(TextView textView, Volumes.Volume.VolumeInfo volumeInfo) {
        if (volumeInfo == null || volumeInfo.getAverageRating() == null) {
            textView.setVisibility(View.GONE);
            return;
        }
        textView.setVisibility(View.VISIBLE);
        textView.setText(textView.getContext().getResources().getString(R.string.ratings_text, volumeInfo.getAverageRating().setScale(2, BigDecimal.ROUND_HALF_UP).toString(), volumeInfo.getRatingsCount()));
    }
/*

    @BindingAdapter({"availableLanguages", "viewModel"})
    public static void setAvailableLanguages(Spinner spinner, String[] languages, SelectorViewModel selectorViewModel) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectorViewModel.setLanguageSelected(((String) adapterView.getItemAtPosition(position)));
                adapterView.setSelection(position);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }*/

    @BindingAdapter("visibility")
    public static void setVisibility(TextView textView, String string) {
        if (TextUtils.isEmpty(string)) {
            textView.setVisibility(View.GONE);
            return;
        }
        textView.setVisibility(View.VISIBLE);
    }


}
