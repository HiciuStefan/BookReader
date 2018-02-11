package com.stefan.bookreader.catalog.navigator;


import android.os.Parcel;
import android.os.Parcelable;

public final class UserSelection implements Parcelable {

    private final String bookTitle;
    private final String bookAuthor;

    public UserSelection(String bookTitle, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }


    protected UserSelection(Parcel in) {
        bookTitle = in.readString();
        bookAuthor = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookTitle);
        dest.writeString(bookAuthor);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<UserSelection> CREATOR = new Parcelable.Creator<UserSelection>() {
        @Override
        public UserSelection createFromParcel(Parcel in) {
            return new UserSelection(in);
        }

        @Override
        public UserSelection[] newArray(int size) {
            return new UserSelection[size];
        }
    };
}
