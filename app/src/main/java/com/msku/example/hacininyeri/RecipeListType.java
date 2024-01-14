package com.msku.example.hacininyeri;

public class RecipeListType {
    public static void Search(String word, String categoryName) {

        System.out.println("Searching for word: " + word + " in category: " + categoryName);
    }

    public static void Category(String categoryName) {
        System.out.println("Filtering by category: " + categoryName);
    }

    public static void Favorites() {
        System.out.println("Displaying favorites");
    }
}

