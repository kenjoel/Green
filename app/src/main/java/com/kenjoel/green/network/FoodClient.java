package com.kenjoel.green.network;


import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FoodClient {

    public static Retrofit retrofit = null;

    public static FoodApi getClient(){
        if(retrofit == null){
            OkHttpClient OkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor(){
                        @Override
                        public Response intercept(Chain chain) throws IOException{
                            Request newRequest = chain.request().newBuilder()
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.edamam.com/api/food-database/v2/")
                    .client(OkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FoodApi.class);
    }
}
