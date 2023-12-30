package com.msku.example.hacininyeri.models;

public class MyRecipe {
    private String title;
    private int starCount;
    private String category;
    private String imageUrl;

    public MyRecipe(String title, int starCount, String category, String imageUrl) {
        this.title = title;
        this.starCount = starCount;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
