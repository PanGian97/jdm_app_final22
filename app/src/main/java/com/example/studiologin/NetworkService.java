package com.example.studiologin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;

    private static final String BASE_URL = "https//jsonplaceholder.typicode.com/todos";

    private Retrofit mRetrofit;

    private NetworkService() {

        mRetrofit = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .build();

    }

    public static NetworkService getInstance() {

        if (mInstance == null) {

            mInstance = new NetworkService();

        }

        return mInstance;

    }
    public ApiClient getJSONApi() {
        return mRetrofit.create(ApiClient.class);
    }


}
