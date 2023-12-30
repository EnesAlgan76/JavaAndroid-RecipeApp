package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout generaterecipe;
    LinearLayout favorites;
    LinearLayout search;
    ImageView explore;
    CardView addRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        generaterecipe = findViewById(R.id.generate_recipe);
        search = findViewById(R.id.search);
        explore = findViewById(R.id.iv_explore);
        favorites = findViewById(R.id.favorites);
        addRecipe = findViewById(R.id.btn_addNewRecipe);

        generaterecipe.setOnClickListener(view ->{
            startActivity(new Intent(this, GenerateActivity.class));

           });

        explore.setOnClickListener(view ->{
            startActivity(new Intent(this, ExploreActivity.class));

        });

        search.setOnClickListener(view ->{
            startActivity(new Intent(this, SearchActivity.class));

        });

        favorites.setOnClickListener(view ->{
            startActivity(new Intent(this, RecipeListActivity.class));

        });

        addRecipe.setOnClickListener(view ->{
            startActivity(new Intent(this, AddRecipeActivity.class));

        });


    }
}