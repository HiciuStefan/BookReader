package com.stefan.bookreader.catalog.bindingadapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.stefan.bookreader.R;
import com.stefan.bookreader.catalog.CatalogActions;
import com.stefan.bookreader.catalog.ui.VolumesViewAdapter;
import com.stefan.bookreader.networking.model.Volume;
import com.stefan.bookreader.networking.model.Volumes;

import java.math.BigDecimal;
import java.util.List;

public class CatalogBindingAdapter {


    private CatalogBindingAdapter() {
        //nothing to be done here
    }

    @BindingAdapter({"books", "eventHandler"})
    public static void setCatalogBooksAndAction(RecyclerView recyclerView, Volumes volumes, CatalogActions catalogActions) {
        if (volumes == null || volumes.getItems() == null) {
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
        Picasso.with(imageView.getContext()).load(imageUrl).fit().into(imageView);
    }


    @BindingAdapter({"img", "holderimage"})
    public static void setImageViewImage(ImageView imageView, String imageUrl, Drawable resPlaceHolder) {
        if (imageUrl == null) {
            return;
        }
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(resPlaceHolder).fit().into(imageView);
    }

    @BindingAdapter("text")
    public static void setComaSeparatedText(TextView textView, List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String string : stringList) {
            sb.append(string);
            sb.append(",");
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        textView.setText(sb.toString());
    }


    @BindingAdapter("ratings")
    public static void setRatingsText(TextView textView, Volume.VolumeInfo volumeInfo) {
        if (volumeInfo == null || volumeInfo.getAverageRating() == null) {
            textView.setVisibility(View.GONE);
            return;
        }
        textView.setVisibility(View.VISIBLE);
        textView.setText(textView.getContext().getResources().getString(R.string.ratings_text, volumeInfo.getAverageRating().setScale(2, BigDecimal.ROUND_HALF_UP).toString(), volumeInfo.getRatingsCount()));
    }


    @BindingAdapter("visibility")
    public static void setVisibility(TextView textView, String string) {
        if (TextUtils.isEmpty(string)) {
            textView.setVisibility(View.GONE);
            return;
        }
        textView.setVisibility(View.VISIBLE);
    }


}
