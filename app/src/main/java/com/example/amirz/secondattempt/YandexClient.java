package com.example.amirz.secondattempt;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amirz on 1/17/2018.
 */

public interface YandexClient {
    @GET("translate")
    Call<ResponseModel> translate(@Query("key") String key,
                                  @Query("text") String text,
                                  @Query("lang") String lang);


}
