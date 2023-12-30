package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.msku.example.hacininyeri.models.MyRecipe;

import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        List<MyRecipe> myRecipeList = FirebaseHelper.getMyRecipeList();

        RecyclerView recyclerView = findViewById(R.id.rv_recipes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(this, myRecipeList);
        recyclerView.setAdapter(myRecipeAdapter);
    }
}