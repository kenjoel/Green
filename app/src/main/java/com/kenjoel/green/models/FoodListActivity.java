package com.kenjoel.green.models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.kenjoel.green.Adapters.FoodListAdapter;
import com.kenjoel.green.Food;
import com.kenjoel.green.Food_;
import com.kenjoel.green.R;
import com.kenjoel.green.network.FoodApi;
import com.kenjoel.green.network.FoodClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FoodListActivity extends AppCompatActivity {

//    private SharedPreferences mSharedPreferences;
//
//    private String mRecentAddress;

    public static final String TAG = FoodListActivity.class.getSimpleName();


    //    @BindView(R.id.locationTextView) TextView mLocationTextView;
//    @BindView(R.id.listView) ListView mListView;
    private  FoodAdapter mAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    public List<Food> restaurants;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;
    private Call<Food> call;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String foodstuff = intent.getStringExtra("location");
         FoodApi client = FoodClient.getClient();

        if (mRecentAddress != null) {
            call = client.getRecipe(mRecentAddress,"&app_id=8770f6e0&app_key=918ba09def4bd0527dda6d67c9b567d3"); //not going to work till you include the whole code in the if statement
            getCall();
        }else {
            call = client.getRecipe(foodstuff, "&app_id=8770f6e0&app_key=918ba09def4bd0527dda6d67c9b567d3");
            getCall();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public Call<Food> getCall() {
        call.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if (response.isSuccessful()) {
                    hideProgressBar();
                    List<Food_> restaurantsList = response.body().getFood();
                    mAdapter = new FoodListAdapter(FoodListActivity.this, restaurantsList);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(FoodListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showRestaurants();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                hideProgressBar();
                showFailureMessage();

            }

        });
        return call;
    }








    private void addToSharedPreferences(String location){
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}