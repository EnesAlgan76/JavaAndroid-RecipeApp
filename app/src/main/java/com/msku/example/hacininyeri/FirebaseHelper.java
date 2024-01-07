package com.msku.example.hacininyeri;

import com.msku.example.hacininyeri.models.Category;
import com.msku.example.hacininyeri.models.Meal;
import com.msku.example.hacininyeri.models.MyRecipe;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {

    public static List<Meal> getMealList() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("Köfte", "40 mins", "4.5", "https://i.nefisyemektarifleri.com/2023/04/17/sodali-kofte-2.jpg"));
        meals.add(new Meal("Kebap", "50 mins", "4.8", "https://die-frau-am-grill.de/wp-content/uploads/adana-kebap-rezept.jpg"));
        meals.add(new Meal("Manti", "35 mins", "4.2", "https://i.nefisyemektarifleri.com/2023/05/26/hazir-manti-pisirme-tarifi-5.jpg"));

        return meals;
    }


    public static List<Category> getCategoryList() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Tatlı", R.drawable.dessert));
        categories.add(new Category("Balık Ürünü", R.drawable.fish));
        categories.add(new Category("Et Yemekleri", R.drawable.meat));
        categories.add(new Category("Sebze Yemekleri", R.drawable.vegetable));
        categories.add(new Category("Hamur İşleri", R.drawable.pastry));
        categories.add(new Category("Çorba", R.drawable.soup));
        categories.add(new Category("Salata", R.drawable.salad));

        return categories;
    }

    public static List<MyRecipe> getMyRecipeList() {
        List<MyRecipe> myRecipes = new ArrayList<>();

        myRecipes.add(new MyRecipe("Baklava", 5, "Tatlı","https://www.asiltat.com/upload/productsImage/2000x1333/fstkl_baklava.jpeg"));
        myRecipes.add(new MyRecipe("Sütlaç", 4, "Tatlı","https://i0.wp.com/yemektarifial.com/wp-content/uploads/2022/10/Iki-Kisilik-Sutlac-Tarifi.jpg"));
        myRecipes.add(new MyRecipe("İskender", 4, "Ana Yemek","https://d17wu0fn6x6rgz.cloudfront.net/img/w/tarif/mgt/iskender.webp"));


        return myRecipes;
    }
}
