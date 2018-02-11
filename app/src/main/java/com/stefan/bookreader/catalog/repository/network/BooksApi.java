package com.stefan.bookreader.catalog.repository.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {

    @GET("volumes")
    Single<Volumes> getVolumes(@Query("q") String querry,@Query("key") String apiKey);

}
