package com.stefan.bookreader.networking;


import com.stefan.bookreader.networking.model.Volumes;
import com.stefan.bookreader.networking.model.Volume;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BooksApi {

    @GET("volumes")
    Single<Volumes> getVolumes(@Query("q") String querry, @Query("key") String apiKey);

    @GET("volumes/{volume}")
    Single<Volume> getVolume(@Path("volume") String id, @Query("key") String apiKey);

}
