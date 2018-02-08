package com.stefan.bookreader.networking;


import com.stefan.bookreader.BuildConfig;
import com.stefan.bookreader.catalog.repository.network.BooksApi;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCreator {

    private final Retrofit retrofitBuilder;
    private final OkHttpClient httpClient;

    @Inject
    public ApiCreator() {

        httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                return response;
            }
        }).build();


        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public BooksApi getBooksApi(){
        return retrofitBuilder.create(BooksApi.class);
    }

}
