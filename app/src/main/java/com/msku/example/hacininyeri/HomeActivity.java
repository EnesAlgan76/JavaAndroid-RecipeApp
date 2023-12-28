package com.msku.example.hacininyeri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout generaterecipe;
    ImageView explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        generaterecipe = findViewById(R.id.generate_recipe);
        explore = findViewById(R.id.iv_explore);

        generaterecipe.setOnClickListener(view ->{
            startActivity(new Intent(this, GenerateActivity.class));

           });

        explore.setOnClickListener(view ->{
            startActivity(new Intent(this, ExploreActivity.class));

        });


    }
}