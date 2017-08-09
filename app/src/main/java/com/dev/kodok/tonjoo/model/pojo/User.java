package com.dev.kodok.tonjoo.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 08/08/17.
 */

public class User {
    private String token;
    private String user_id;

    public User(String token, String user_id) {
        this.token = token;
        this.user_id = user_id;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "token='" + token + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
