package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiSingleDealModel {

    @SerializedName("shop_address")
    @Expose
    private String shopAddress;
    @SerializedName("shop_logo")
    @Expose
    private String shopLogo;
    @SerializedName("avg_rating")
    @Expose
    private String avgRating;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("points")
    @Expose
    private List<String> points = null;
    @SerializedName("discount")
    @Expose
    private List<String> discount = null;
    @SerializedName("shop_id")
    @Expose
    private String shopId;

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<String> getPoints() {
        return points;
    }

    public void setPoints(List<String> points) {
        this.points = points;
    }

    public List<String> getDiscount() {
        return discount;
    }

    public void setDiscount(List<String> discount) {
        this.discount = discount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}