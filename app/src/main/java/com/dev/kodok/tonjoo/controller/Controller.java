package com.dev.kodok.tonjoo.controller;

import android.util.Log;

import com.dev.kodok.tonjoo.model.api.RestApiManager;
import com.dev.kodok.tonjoo.model.pojo.Kontak;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by root on 08/08/17.
 */

public class Controller {
    private static final String TAG = Controller.class.getSimpleName();
    private KontakCallbackListener kontakCallbackListener;
    private RestApiManager restApiManager;

    public Controller(KontakCallbackListener kontakCallbackListener) {
        this.kontakCallbackListener = kontakCallbackListener;
        restApiManager = new RestApiManager();
    }

    public void startFetching() {
        restApiManager.getContactApi().getKontak(new Callback<String>() {
            @Override
            public void success(String s, Response response) {

                Log.d(TAG, "JSON :: " + s);

                JSONObject object = null;
                try {
                    object = new JSONObject(s);
                    JSONArray Jarray  = object.getJSONArray("data");

                    for (int i = 0; i < Jarray.length(); i++)
                    {
                        JSONObject jsonObject = Jarray.getJSONObject(i);
                        Kontak kontak = new Kontak.Builder()
                                .setFist_name(jsonObject.getString("first_name"))
                                .setLast_name(jsonObject.getString("last_name"))
                                .setGender(jsonObject.getString("email"))
                                .setEmail(jsonObject.getString("gender"))
                                .setAvatar(jsonObject.getString("avatar"))
                                .build();
                        kontakCallbackListener.onFetchProgress(kontak);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



//                Log.d(TAG, "JSON :: " + s);
//
//                try {
//                    JSONArray array = new JSONArray(s);
//
//                    for (int i = 0; i < array.length(); i++) {
//                        JSONObject object = array.getJSONObject(i);
//
//                        Kontak kontak = new Kontak.Builder()
//                                .setFist_name(object.getString("first_name"))
//                                .setLast_name(object.getString("last_name"))
//                                .setGender(object.getString("email"))
//                                .setEmail(object.getString("gender"))
//                                .setAvatar(object.getString("avatar"))
//                                .build();
//                        kontakCallbackListener.onFetchProgress(kontak);
//
//                        Log.d("Flow ", "1");
//                    }
//
//                } catch (JSONException e) {
//                    kontakCallbackListener.onFetchFailed();
//
//                    Log.d("Flow ", "2");
//                }
//
//                kontakCallbackListener.onFetchComplete();    //callback kumplite
//
//                Log.d("Flow ", "3");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                kontakCallbackListener.onFetchComplete();

                Log.d("Flow ", "4");
            }
        });
    }
    public interface KontakCallbackListener {

        void onFetchStart();
        void onFetchProgress(Kontak kontak);
        void onFetchProgress(List<Kontak> kontaks);
        void onFetchComplete();
        void onFetchFailed();
    }
}
