package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.msku.example.hacininyeri.models.Category;

import java.util.List;

public class AddRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        List<Category> categoryList = FirebaseHelper.getCategoryList();

        RecyclerView recyclerViewCategory = findViewById(R.id.rv_add_categories);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);

        recyclerViewCategory.setAdapter(categoryAdapter);
    }
}