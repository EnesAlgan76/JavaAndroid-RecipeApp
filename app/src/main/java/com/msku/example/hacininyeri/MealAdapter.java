package com.msku.example.hacininyeri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.msku.example.hacininyeri.models.Meal;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {
    private List<Meal> mealList;
    private Context mContext;

    public MealAdapter(Context mContext, List<Meal> mealList) {
        this.mealList = mealList;
        this.mContext = mContext;
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personalized_recipes, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        Meal meal = mealList.get(position);

        holder.mealName.setText(meal.getName());
        holder.preparationTime.setText(meal.getPreparationTime());
        holder.ratingBar.setText(meal.getRating());

        Glide.with(mContext).load(meal.getImageUrl()).into(holder.mealImage);
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {

         ImageView mealImage;
         TextView mealName;
         TextView preparationTime;
        TextView ratingBar;
         CardView saveButton;

        public MealViewHolder(View itemView) {
            super(itemView);
            mealImage = itemView.findViewById(R.id.iv_personalized_meal);
            mealName = itemView.findViewById(R.id.tv_meal_name);
            preparationTime = itemView.findViewById(R.id.tv_time);
            ratingBar = itemView.findViewById(R.id.tv_rating);
            saveButton = itemView.findViewById(R.id.btn_save);
        }
    }
}
