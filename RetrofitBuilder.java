package com.martin.retrofitwrapper.retrofit;

import android.support.annotation.Nullable;

import com.martin.retrofitwrapper.retrofit.interceptors.ContentJsonInterceptor;
import com.martin.retrofitwrapper.retrofit.interceptors.RetryRequestInterceptor;
import com.martin.retrofitwrapper.retrofit.interceptors.authenticator.TokenAuthenticator;
import com.martin.retrofitwrapper.retrofit.interceptors.validator.Validator;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by martin on 2/7/18.
 */

class RetrofitBuilder {

    private RetrofitBuilder() {}

    private static String baseUrl = ""; //TODO Set base url

    @Nullable
    private static RetrofitInterface retrofitInterface = null;

    public static RetrofitInterface getRetrofitInterface() {

        if (retrofitInterface == null) {
            OkHttpClient okHttpClient = createOkHttpClient();
            createRetrofitInterface(okHttpClient);
        }

        return retrofitInterface;
    }

    private static void createRetrofitInterface(OkHttpClient okHttpClient) {
        retrofitInterface = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitInterface.class);
    }

    private static OkHttpClient createOkHttpClient() {

        return new OkHttpClient.Builder()
                .authenticator(new TokenAuthenticator())
                .addInterceptor(new ContentJsonInterceptor())
                .addInterceptor(new Validator())
                .addInterceptor(new RetryRequestInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
