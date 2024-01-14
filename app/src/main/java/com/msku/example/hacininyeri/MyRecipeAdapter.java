package com.msku.example.hacininyeri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.msku.example.hacininyeri.models.Meal;

import java.util.List;

public class MyRecipeAdapter extends RecyclerView.Adapter<MyRecipeAdapter.MyRecipeViewHolder> {
    private List<Meal> myRecipeList;
    private Context mContext;

    public MyRecipeAdapter(Context context,List<Meal> myRecipeList) {
        this.myRecipeList = myRecipeList;
        this.mContext = context;
    }

    @Override
    public MyRecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myrecipes, parent, false);
        return new MyRecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecipeViewHolder holder, int position) {
        Meal myRecipe = myRecipeList.get(position);
        holder.recipeTitle.setText(myRecipe.getName());
       // holder.starCount.setText(String.valueOf(myRecipe.getStarCount()));
        Glide.with(mContext).load(myRecipe.getImageUrl()).into(holder.recipeImage);
    }

    @Override
    public int getItemCount() {
        return myRecipeList.size();
    }

    public class MyRecipeViewHolder extends RecyclerView.ViewHolder {

        ImageView recipeImage;
        TextView recipeTitle;
        TextView category;

        public MyRecipeViewHolder(View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.myrecipes_meal);
            recipeTitle = itemView.findViewById(R.id.myrecipes_title);
            category = itemView.findViewById(R.id.myrecipes_category);
        }
    }
}
