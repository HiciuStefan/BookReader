package com.stefan.bookreader.catalog.repository.network;

import com.stefan.bookreader.TestBase;
import com.stefan.bookreader.catalog.navigator.UserSelection;
import com.stefan.bookreader.networking.BooksApi;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.stefan.bookreader.BuildConfig.API_KEY;
import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BooksNetworkRepositoryTest extends TestBase {

    @Mock
    BooksApi booksApi;

    @InjectMocks
    BooksNetworkRepository booksNetworkRepository;

    @Test
    public void getVolumes_emptyValues() throws Exception {
        booksNetworkRepository.getVolumes(mock(UserSelection.class));
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(booksApi).getVolumes(argumentCaptor.capture(), eq(API_KEY));
        assertEquals("\"\"", argumentCaptor.getValue());
    }

    @Test
    public void getVolumes_emptyTitle() throws Exception {
        UserSelection selection = mock(UserSelection.class);
        String author = "author";
        String authorQuerryText = "inauthor:author";
        when(selection.getBookAuthor()).thenReturn(author);
        booksNetworkRepository.getVolumes(selection);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(booksApi).getVolumes(argumentCaptor.capture(), eq(API_KEY));
        assertEquals(authorQuerryText, argumentCaptor.getValue());
    }

    @Test
    public void getVolumes_emptyAuthor() throws Exception {

        UserSelection selection = mock(UserSelection.class);
        String title = "title";
        String titleQuerryText = "intitle:title";
        when(selection.getBookTitle()).thenReturn(title);
        booksNetworkRepository.getVolumes(selection);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(booksApi).getVolumes(argumentCaptor.capture(), eq(API_KEY));
        assertEquals(titleQuerryText, argumentCaptor.getValue());
    }

    @Test
    public void getVolumes_fullData() throws Exception {
        UserSelection selection = mock(UserSelection.class);
        String title = "title";
        String author = "author";
        String querry = "intitle:title+inauthor:author";
        when(selection.getBookTitle()).thenReturn(title);
        when(selection.getBookAuthor()).thenReturn(author);
        booksNetworkRepository.getVolumes(selection);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(booksApi).getVolumes(argumentCaptor.capture(), eq(API_KEY));
        assertEquals(querry, argumentCaptor.getValue());
    }

}