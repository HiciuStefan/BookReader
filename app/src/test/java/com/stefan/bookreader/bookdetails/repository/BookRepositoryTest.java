package com.stefan.bookreader.bookdetails.repository;

import com.stefan.bookreader.BuildConfig;
import com.stefan.bookreader.TestBase;
import com.stefan.bookreader.networking.BooksApi;
import com.stefan.bookreader.networking.model.Volume;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import io.reactivex.Single;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookRepositoryTest extends TestBase {

    private BookRepository bookRepository;
    @Mock
    private BooksApi booksApi;

    @Before
    public void setUp() {
        bookRepository = new BookRepository(booksApi);
    }

    @Test
    public void getVolume() throws Exception {
        String test = "test";
        Volume mockedVolume = mock(Volume.class);
        when(booksApi.getVolume(eq(test), eq(BuildConfig.API_KEY))).thenReturn(Single.just(mockedVolume));
        bookRepository.getVolume(test).test().assertNoErrors().assertComplete().assertValue(mockedVolume);

    }

}