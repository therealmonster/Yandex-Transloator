package com.example.amirz.secondattempt;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amirz on 1/17/2018.
 */

public class ApiService {
    public static Retrofit gettingBuilder() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder()
                                .addHeader("Accept", "application/x-www-form-urlencoded");
                        return chain.proceed(builder.build());
                    }
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
