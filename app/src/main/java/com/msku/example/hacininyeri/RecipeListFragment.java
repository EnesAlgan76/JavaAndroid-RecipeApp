package com.msku.example.hacininyeri;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msku.example.hacininyeri.models.Meal;

import java.util.List;

public class RecipeListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_recipe_list, container, false);

        List<Meal> myRecipeList = FirebaseHelper.getMyRecipeList();

        RecyclerView recyclerView = view.findViewById(R.id.rv_recipes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(requireContext(), myRecipeList);
        recyclerView.setAdapter(myRecipeAdapter);

        return view;
    }
}