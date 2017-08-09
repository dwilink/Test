package com.dev.kodok.tonjoo.model.api;

import com.dev.kodok.tonjoo.model.pojo.User;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.POST;

/**
 * Created by root on 09/08/17.
 */

public interface LoginService {
    @POST("/api/login")
    void basicLogin(@Field("username") String username,
                    @Field("password") String password,
                    Callback<String> cb);
}
