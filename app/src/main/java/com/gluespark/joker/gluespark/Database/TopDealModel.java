package com.gluespark.joker.gluespark.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity
public class TopDealModel {

    public TopDealModel() {
    }

    public TopDealModel(@NonNull String pShopId, String pShopAddress, String pImageUrl, String pShopName, String pShopRating, String pShopDiscount1, String pShopDiscount2, String pShopPoints1, String pShopPoints2) {
        shopId = pShopId;
        shopAddress = pShopAddress;
        ImageUrl = pImageUrl;
        shopName = pShopName;
        shopRating = pShopRating;
        shopDiscount1 = pShopDiscount1;
        shopDiscount2 = pShopDiscount2;
        shopPoints1 = pShopPoints1;
        shopPoints2 = pShopPoints2;
    }



    @PrimaryKey()@NonNull
    @ColumnInfo(name = "shop_id")
    private String shopId;
    @ColumnInfo(name = "shop_address")
    private String shopAddress;
    @ColumnInfo(name = "shop_image_url")
    private String ImageUrl;
    @ColumnInfo(name = "shop_name")
    private String shopName;
    @ColumnInfo(name = "shop_rating")
    private String shopRating;
    @ColumnInfo(name = "discount_1")
    private String shopDiscount1;
    @ColumnInfo(name = "discount_2")
    private String shopDiscount2;
    @ColumnInfo(name = "points_1")
    private String shopPoints1;
    @ColumnInfo(name = "points_2")
    private String shopPoints2;



    public String getShopDiscount1() {
        return shopDiscount1;
    }

    public void setShopDiscount1(String pShopDiscount1) {
        shopDiscount1 = pShopDiscount1;
    }

    public String getShopDiscount2() {
        return shopDiscount2;
    }

    public void setShopDiscount2(String pShopDiscount2) {
        shopDiscount2 = pShopDiscount2;
    }

    public String getShopPoints1() {
        return shopPoints1;
    }

    public void setShopPoints1(String pShopPoints1) {
        shopPoints1 = pShopPoints1;
    }

    public String getShopPoints2() {
        return shopPoints2;
    }

    public void setShopPoints2(String pShopPoints2) {
        shopPoints2 = pShopPoints2;
    }



    public String getShopId() {
        return shopId;
    }

    public void setShopId(String pShopId) {
        shopId = pShopId;
    }


    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String pShopAddress) {
        shopAddress = pShopAddress;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String pImageUrl) {
        ImageUrl = pImageUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String pShopName) {
        shopName = pShopName;
    }

    public String getShopRating() {
        return shopRating;
    }

    public void setShopRating(String pShopRating) {
        shopRating = pShopRating;
    }


}