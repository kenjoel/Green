package com.kenjoel.green.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.kenjoel.green.Food_;
import com.kenjoel.green.R;
import com.squareup.picasso.Picasso;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.RestaurantViewHolder> {

    private List<Food_> mFoodList;
    private Context mContext;

    public FoodListAdapter(Context context, List<Food_> foodList) {
        mContext = context;
        mFoodList = foodList;
    }

    @Override
    public FoodListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mFoodList.get(position));


    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }



    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
                itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
            mContext.startActivity(intent);

        }

        public void bindRestaurant(Food_ food_) {
            Picasso.get().load(food_.getImage()).into(mRestaurantImageView);
            mNameTextView.setText(food_.getLabel());
            mCategoryTextView.setText(food_.getCategory()  );
            mRatingTextView.setText("Fat" + food_.getNutrients().getFAT() + "Calories" + food_.getNutrients().getENERCKCAL());
        }




    }
}


