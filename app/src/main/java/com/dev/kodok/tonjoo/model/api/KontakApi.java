package com.dev.kodok.tonjoo.model.api;

import com.dev.kodok.tonjoo.model.pojo.User;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;

/**
 * Created by root on 08/08/17.
 */

public interface KontakApi {
    @FormUrlEncoded
    @POST("/api/login")
    void basicLogin(@Field("username") String username,
                    @Field("password") String password,
                    Callback<Response> Response);

    @GET("/api/contacts")
    void getKontak(Callback<String> stringCallback);
}
