package com.msku.example.hacininyeri.models;

public class Meal {
    private String name;
    private String preparationTime;
    private String rating;
    private String imageUrl;
    private String category;


    public Meal(String name, String preparationTime, String rating, String imageUrl, String category) {
        this.name = name;
        this.preparationTime = preparationTime;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}