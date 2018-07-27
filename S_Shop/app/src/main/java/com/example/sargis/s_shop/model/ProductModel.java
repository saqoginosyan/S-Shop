package com.example.sargis.s_shop.model;

import com.example.sargis.s_shop.Categories;

public class ProductModel {
    private String title;
    private String[] imagesUrl;
    private Enum<Categories> category;
    private String description;
    private String price;
    private String videoUrl;
    private Boolean isLiked;
    private Boolean isToBasket;
    private float rating;

    public ProductModel(String title, String[] imagesUrl, Enum<Categories> category, String description, String price, String videoUrl, Boolean isLiked, Boolean isToBasket, float rating) {
        this.title = title;
        this.imagesUrl = imagesUrl;
        this.category = category;
        this.description = description;
        this.price = price;
        this.videoUrl = videoUrl;
        this.isLiked = isLiked;
        this.isToBasket = isToBasket;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String[] imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Enum<Categories> getCategory() {
        return category;
    }

    public void setCategory(Enum<Categories> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public Boolean getToBasket() {
        return isToBasket;
    }

    public void setToBasket(Boolean toBasket) {
        isToBasket = toBasket;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
