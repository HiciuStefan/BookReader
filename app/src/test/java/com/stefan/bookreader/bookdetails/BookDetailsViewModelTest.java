package com.stefan.bookreader.bookdetails;

import android.app.Application;

import com.stefan.bookreader.TestBase;
import com.stefan.bookreader.bookdetails.repository.BookRepository;
import com.stefan.bookreader.networking.model.Volume;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import io.reactivex.Single;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BookDetailsViewModelTest extends TestBase {

    @Mock
    Application application;
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookDetailsViewModel bookDetailsViewModel;
    private String bookId = "test";

    @Before
    public void setUp() {
        bookDetailsViewModel.setBookId(bookId);
    }

    @Test
    public void testGetVolumeSingle() {
        Volume volume = mock(Volume.class);
        when(bookRepository.getVolume(eq(bookId))).thenReturn(Single.just(volume));
        bookDetailsViewModel.getVolumeSingle().test().assertComplete().assertValue(volume);
        verify(bookRepository).getVolume(eq(bookId));
        assertEquals(volume, bookDetailsViewModel.volume.get());
    }

    @Test
    public void test_setBookId() {
        bookDetailsViewModel.setBookId(bookId);
        assertEquals(bookId, bookDetailsViewModel.bookId);
    }


}