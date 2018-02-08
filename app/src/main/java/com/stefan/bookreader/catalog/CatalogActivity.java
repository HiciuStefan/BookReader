package com.stefan.bookreader.catalog;

import android.app.Activity;
import android.os.Bundle;

import com.stefan.bookreader.R;

import dagger.android.DaggerActivity;

public class CatalogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
