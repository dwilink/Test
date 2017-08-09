package com.dev.kodok.tonjoo.model.api;

import com.dev.kodok.tonjoo.model.utility.Constants;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by root on 08/08/17.
 */

public class RestApiManager {
    private KontakApi kontakApi;

    public KontakApi getContactApi() {

        if(kontakApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            kontakApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(KontakApi.class);
        }
        return kontakApi;
    }
}
