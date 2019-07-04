package com.martin.retrofitwrapper.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by martin on 2/7/18.
 */
public interface RetrofitInterface {

    @GET("/user")
    Call<String> getUser(@Header("Authorization") String auth);

}


