package com.kenjoel.green.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kenjoel.green.Food_;
import com.kenjoel.myrestaurante.models.Business;
import com.kenjoel.myrestaurante.ui.RestaurantDetailFragment;

import java.util.List;


public class FoodPagerAdapter extends FragmentPagerAdapter {

        private List<Food_> mFoodList;

        public FoodPagerAdapter(FragmentManager fm, int behavior, List<Food_> food_list) {
            super(fm, behavior);
            mFoodList = food_list;
        }

        @Override
        public Fragment getItem(int position) {
            return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
        }

        @Override
        public int getCount() {
            return mRestaurants.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mRestaurants.get(position).getName();
        }
    }

