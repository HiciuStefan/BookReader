package com.stefan.bookreader.splashscreen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stefan.bookreader.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        DataBindingUtil.setContentView(SplashActivity.this, R.layout.splashscreen_activity);

    }
}
