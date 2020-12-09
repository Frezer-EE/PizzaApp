package com.example.pizza;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface IRetrofit2 {
    @POST("/pizza/reg")
    Call<UserResponse> registrationUser(
      @Query("login") String loginUser,
      @Query("email") String eMailUser,
      @Query("password") String passwordUser
    );

    @GET("/pizza")
    Call<PizzaList> getPizzaList();

    @POST("/pizza")
    Call<PizzaListItem> getPizza(
       @Query("id") Integer id
    );

    @POST("/pizza/auth")
    Call<AuthResponse> authorizationUser(
            @Query("login") String loinUser,
            @Query("password") String passwordUser
    );
}
