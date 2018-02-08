package com.stefan.bookreader.splashscreen;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.stefan.bookreader.catalog.CatalogActivity;

public final class SplashScreenBindingAdapter {

    private SplashScreenBindingAdapter() {
    }

    @BindingAdapter("animatedText")
    public static void setAnimatedText(TextSwitcher textSwitcher, String text) {
        if (textSwitcher != null) {
            Context context = textSwitcher.getContext();
            textSwitcher.setFactory(() -> {
                TextView textView = new TextView(context);
                textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                textView.setTextSize(44);


                return textView;
            });
            Animation in = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            in.setDuration(1000);
            textSwitcher.setInAnimation(in);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.WHITE), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new BackgroundColorSpan(Color.BLACK), 3, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.BLACK), 5, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textSwitcher.post(() -> textSwitcher.setText(spannableStringBuilder));
            in.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    context.startActivity(new Intent(context, CatalogActivity.class));
                    ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
