package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiTopDealModel {

    @SerializedName("shop_address")
    private String shopAddress;

    @SerializedName("shop_logo")
    private String shopImage;

    @SerializedName("avg_rating")
    private String shopRating;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("points")
    private List<String> points;

    @SerializedName("discount")
    private List<String> discount;

    @SerializedName("shop_id")
    private String shopId;

    public ApiTopDealModel(String pShopAddress, String pShopImage, String pShopRating, String pShopName, List<String> pPoints, List<String> pDiscount, String pShopId) {
        shopAddress = pShopAddress;
        shopImage = pShopImage;
        shopRating = pShopRating;
        shopName = pShopName;
        points = pPoints;
        discount = pDiscount;
        shopId = pShopId;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String pShopAddress) {
        shopAddress = pShopAddress;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String pShopImage) {
        shopImage = pShopImage;
    }

    public String getShopRating() {
        return shopRating;
    }

    public void setShopRating(String pShopRating) {
        shopRating = pShopRating;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String pShopName) {
        shopName = pShopName;
    }

    public List<String> getPoints() {
        return points;
    }

    public void setPoints(List<String> pPoints) {
        points = pPoints;
    }

    public List<String> getDiscount() {
        return discount;
    }

    public void setDiscount(List<String> pDiscount) {
        discount = pDiscount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String pShopId) {
        shopId = pShopId;
    }
}