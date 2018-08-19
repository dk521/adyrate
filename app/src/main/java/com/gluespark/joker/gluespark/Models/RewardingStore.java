package com.gluespark.joker.gluespark.Models;

public class RewardingStore {

  private   String id,name,imageUrl,description,discount;

    public RewardingStore(String id, String name, String imageUrl, String description, String discount) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getDiscount() {
        return discount;
    }
}
