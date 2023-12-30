package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.msku.example.hacininyeri.CategoryAdapter;
import com.msku.example.hacininyeri.FirebaseHelper;
import com.msku.example.hacininyeri.MyRecipeAdapter;
import com.msku.example.hacininyeri.R;
import com.msku.example.hacininyeri.models.Category;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerViewCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        List<Category> categoryList = FirebaseHelper.getCategoryList();


        recyclerViewCategory = findViewById(R.id.recyclerView_category);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);

        recyclerViewCategory.setAdapter(categoryAdapter);
    }
}