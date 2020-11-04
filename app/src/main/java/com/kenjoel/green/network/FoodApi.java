package com.kenjoel.green.network;

import com.kenjoel.green.Food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {
    @GET("parser?ingr=")
    Call<Food> getRecipe(
            @Query("query") String query,
            @Query("credentials") String term
    );
}
