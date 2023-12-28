package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.msku.example.hacininyeri.models.Category;
import com.msku.example.hacininyeri.models.Meal;
import com.msku.example.hacininyeri.models.MyRecipe;

import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        List<Meal> mealList = FirebaseHelper.getMealList();
        List<Category> categoryList = FirebaseHelper.getCategoryList();
        List<MyRecipe> myRecipeList = FirebaseHelper.getMyRecipeList();


        RecyclerView recyclerView1 = findViewById(R.id.recyclerView2);
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView3);
        RecyclerView recyclerView3 = findViewById(R.id.recyclerView4);


        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);


        MealAdapter mealAdapter = new MealAdapter(this, mealList);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList);
        MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(this, myRecipeList);

        recyclerView1.setAdapter(mealAdapter);
        recyclerView2.setAdapter(categoryAdapter);
        recyclerView3.setAdapter(myRecipeAdapter);
    }
}