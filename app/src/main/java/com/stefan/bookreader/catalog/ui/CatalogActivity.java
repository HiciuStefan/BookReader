package com.stefan.bookreader.catalog.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import com.stefan.bookreader.R;

import dagger.android.support.DaggerAppCompatActivity;


public class CatalogActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, SelectorFragment.newInstance()).commit();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("kR");
        spannableStringBuilder.setSpan(new BackgroundColorSpan(Color.BLACK), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(spannableStringBuilder);

    }
}
