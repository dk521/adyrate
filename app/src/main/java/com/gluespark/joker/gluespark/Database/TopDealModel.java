package com.gluespark.joker.gluespark.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TopDealModel {

    public TopDealModel() {
    }

    public TopDealModel(int pShopId, String pShopAddress, String pImageUrl, String pShopName, String pShopRating, String pShopDiscountSmall, String pShopDiscountBig) {
        shopId = pShopId;
        shopAddress = pShopAddress;
        ImageUrl = pImageUrl;
        shopName = pShopName;
        shopRating = pShopRating;
        shopDiscountSmall = pShopDiscountSmall;
        shopDiscountBig = pShopDiscountBig;
    }

    @PrimaryKey(autoGenerate = true)
    private int uId;
    @ColumnInfo(name="shop_id")
    private int shopId;
    @ColumnInfo(name = "shop_address")
    private String shopAddress;
    @ColumnInfo(name = "shop_image_url")
    private String ImageUrl;
    @ColumnInfo(name = "shop_name")
    private String shopName;
    @ColumnInfo(name = "shop_rating")
    private String shopRating;
    @ColumnInfo(name = "discount_small")
    private String shopDiscountSmall;
    @ColumnInfo(name = "discount_big")
    private String shopDiscountBig;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int pShopId) {
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

    public String getShopDiscountSmall() {
        return shopDiscountSmall;
    }

    public void setShopDiscountSmall(String pShopDiscountSmall) {
        shopDiscountSmall = pShopDiscountSmall;
    }

    public String getShopDiscountBig() {
        return shopDiscountBig;
    }

    public void setShopDiscountBig(String pShopDiscountBig) {
        shopDiscountBig = pShopDiscountBig;
    }
}