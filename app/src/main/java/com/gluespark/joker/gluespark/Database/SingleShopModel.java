package com.gluespark.joker.gluespark.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = TotalDealModel.class,
        parentColumns = "shop_id",
        childColumns = "deal_id",
        onDelete = CASCADE))
public class SingleShopModel {

    public SingleShopModel() {
    }

    public SingleShopModel(@NonNull Integer pShopId, String pShopName, String pShopDescription, String pShopAddress, String pImageUrl, String pShopRating, String pShopCategory, int pShopCategoryId, long pTimeStamp) {
        shopId = pShopId;
        shopName = pShopName;
        shopDescription = pShopDescription;
        shopAddress = pShopAddress;
        ImageUrl = pImageUrl;
        shopRating = pShopRating;
        shopCategory = pShopCategory;
        shopCategoryId = pShopCategoryId;
        timeStamp = pTimeStamp;
    }

    @ColumnInfo(name = "deal_id")//Foreign Key
    private Integer dealId;

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "shop_id")
    private Integer shopId = -1;

    @ColumnInfo(name = "shop_name")
    private String shopName;

    @ColumnInfo(name = "shop_description")
    private String shopDescription;

    @ColumnInfo(name = "shop_address")
    private String shopAddress;

    @ColumnInfo(name = "shop_image_url")
    private String ImageUrl;

    @ColumnInfo(name = "shop_rating")
    private String shopRating;

    @ColumnInfo(name = "shop_category")
    private String shopCategory;

    @ColumnInfo(name = "shop_category_id")
    private int shopCategoryId;

    @ColumnInfo(name = "timestamp")
    private long timeStamp;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer pDealId) {
        dealId = pDealId;
    }

    @NonNull
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(@NonNull Integer pShopId) {
        shopId = pShopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String pShopName) {
        shopName = pShopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String pShopDescription) {
        shopDescription = pShopDescription;
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

    public String getShopRating() {
        return shopRating;
    }

    public void setShopRating(String pShopRating) {
        shopRating = pShopRating;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String pShopCategory) {
        shopCategory = pShopCategory;
    }

    public int getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(int pShopCategoryId) {
        shopCategoryId = pShopCategoryId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long pTimeStamp) {
        timeStamp = pTimeStamp;
    }
}