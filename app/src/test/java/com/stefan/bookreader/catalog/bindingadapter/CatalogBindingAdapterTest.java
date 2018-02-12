package com.stefan.bookreader.catalog.bindingadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.stefan.bookreader.R;
import com.stefan.bookreader.catalog.CatalogActions;
import com.stefan.bookreader.catalog.ui.VolumesViewAdapter;
import com.stefan.bookreader.networking.model.Volume;
import com.stefan.bookreader.networking.model.Volumes;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


public class CatalogBindingAdapterTest {

    @Test
    public void setCatalogBooks_emptyOrNull() throws Exception {
        RecyclerView recyclerViewMock = mock(RecyclerView.class);
        Volumes volumesMock = mock(Volumes.class);
        CatalogActions catalogActionsMock = mock(CatalogActions.class);
        CatalogBindingAdapter.setCatalogBooksAndAction(recyclerViewMock, null, catalogActionsMock);
        verify(recyclerViewMock, times(0)).setAdapter(any());
        when(volumesMock.getItems()).thenReturn(null);
        CatalogBindingAdapter.setCatalogBooksAndAction(recyclerViewMock, volumesMock, catalogActionsMock);
        verify(recyclerViewMock, times(0)).setAdapter(any());
    }

    @Test
    public void setCatalogBooks_settingAgain_noAction() throws Exception {
        RecyclerView recyclerViewMock = mock(RecyclerView.class);
        Volumes volumesMock = mock(Volumes.class);
        CatalogActions catalogActionsMock = mock(CatalogActions.class);
        when(volumesMock.getItems()).thenReturn(new ArrayList<>());
        CatalogBindingAdapter.setCatalogBooksAndAction(recyclerViewMock, volumesMock, catalogActionsMock);
        verify(recyclerViewMock, times(1)).setAdapter(any());
        clearInvocations(recyclerViewMock);
        when(recyclerViewMock.getAdapter()).thenReturn(mock(RecyclerView.Adapter.class));
        CatalogBindingAdapter.setCatalogBooksAndAction(recyclerViewMock, volumesMock, catalogActionsMock);
        verify(recyclerViewMock, times(0)).setAdapter(any());
    }

    @Test
    public void setCatalogBooks_correctData() throws Exception {
        RecyclerView recyclerViewMock = mock(RecyclerView.class);
        Volumes volumesMock = mock(Volumes.class);
        CatalogActions catalogActionsMock = mock(CatalogActions.class);
        when(volumesMock.getItems()).thenReturn(new ArrayList<>());
        CatalogBindingAdapter.setCatalogBooksAndAction(recyclerViewMock, volumesMock, catalogActionsMock);
        ArgumentCaptor<VolumesViewAdapter> argumentCaptor = ArgumentCaptor.forClass(VolumesViewAdapter.class);
        verify(recyclerViewMock, times(1)).setAdapter(argumentCaptor.capture());
        assertEquals(volumesMock, argumentCaptor.getValue().getVolumes());
    }


    @Test
    public void testSetComaSeparatedText_null_empty_valid() throws Exception {
        TextView textView = mock(TextView.class);
        Context context = mock(Context.class);
        Resources resources = mock(Resources.class);
        when(context.getResources()).thenReturn(resources);
        when(textView.getContext()).thenReturn(context);
        List<String> mockText = null;
        CatalogBindingAdapter.setComaSeparatedText(textView, mockText);
        verifyZeroInteractions(textView);
        mockText = new ArrayList<>();
        CatalogBindingAdapter.setComaSeparatedText(textView, mockText);
        verifyZeroInteractions(textView);

        mockText = new ArrayList<>();
        mockText.add("test");
        CatalogBindingAdapter.setComaSeparatedText(textView, mockText);
        StringBuilder sb = new StringBuilder("test");
        verify(textView).setText(eq(sb.toString()));
    }

    @Test
    public void setRatingsText_null_empty_valid() throws Exception {
        TextView textView = mock(TextView.class);
        Context context = mock(Context.class);
        Resources resources = mock(Resources.class);
        when(context.getResources()).thenReturn(resources);
        when(textView.getContext()).thenReturn(context);
        Volume.VolumeInfo volumeInfo = null;
        CatalogBindingAdapter.setRatingsText(textView, volumeInfo);
        verify(textView).setVisibility(eq(View.GONE));
        verify(textView, times(0)).setText(any());
        volumeInfo = mock(Volume.VolumeInfo.class);
        CatalogBindingAdapter.setRatingsText(textView, volumeInfo);
        verify(textView, times(2)).setVisibility(eq(View.GONE));
        verify(textView, times(0)).setText(any());
        clearInvocations(textView);
        when(volumeInfo.getAverageRating()).thenReturn(new BigDecimal(0));
        CatalogBindingAdapter.setRatingsText(textView, volumeInfo);
        verify(textView, times(0)).setVisibility(eq(View.GONE));
        verify(textView).setVisibility(eq(View.VISIBLE));
        verify(textView).setText(any());
    }

}