package com.example.pizza;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitApiBuilder {

    public static IRetrofit2 getInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://eetk.tesan.ru:8089")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IRetrofit2.class);
    }
}
