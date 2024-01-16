package com.msku.example.hacininyeri;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msku.example.hacininyeri.models.Category;
import com.msku.example.hacininyeri.models.Meal;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    OnCategoryClickListener categoryClickListener;
    public ExploreFragment(OnCategoryClickListener categoryClickListener) {
        this.categoryClickListener = categoryClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        List<Meal> mealList = FirebaseHelper.getMealList();
        List<Category> categoryList = FirebaseHelper.getCategoryList();
        ArrayList<Meal> myRecipeList = FirebaseHelper.getMyRecipeList();


        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView2);
        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView3);
        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView4);


        LinearLayoutManager layoutManager1 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(requireContext());

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);


        MealAdapter mealAdapter = new MealAdapter(requireContext(), mealList);
        CategoryAdapter categoryAdapter = new CategoryAdapter(requireContext(),categoryClickListener,categoryList);
        MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(requireContext(), myRecipeList);

        recyclerView1.setAdapter(mealAdapter);
        recyclerView2.setAdapter(categoryAdapter);
        recyclerView3.setAdapter(myRecipeAdapter);

        return view;
    }
}