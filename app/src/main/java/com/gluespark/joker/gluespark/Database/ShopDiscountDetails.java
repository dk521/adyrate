package com.gluespark.joker.gluespark.Database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = SingleShopModel.class,
        parentColumns = "discount_id",
        childColumns = "shop_id",
        onDelete = CASCADE))
public class ShopDiscountDetails {

    @PrimaryKey() @NonNull
    @ColumnInfo(name = "discount_id")
    private Integer discountId=-1;

    @ColumnInfo(name = "shop_id")//foreign key
    private Integer shopId;

    @ColumnInfo(name = "discount_description")
    private String discountDes;

    @ColumnInfo(name = "start_timestamp")
    private Long startTime;

    @ColumnInfo(name = "end_timestamp")
    private Long endTime;

    @ColumnInfo(name = "discount_points")
    private Integer discountPoint;


    public ShopDiscountDetails(@NonNull Integer pDiscountId, Integer pShopId, String pDiscountDes, Long pStartTime, Long pEndTime, Integer pDiscountPoint) {
        discountId = pDiscountId;
        shopId = pShopId;
        discountDes = pDiscountDes;
        startTime = pStartTime;
        endTime = pEndTime;
        discountPoint = pDiscountPoint;
    }

    @NonNull
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(@NonNull Integer pDiscountId) {
        discountId = pDiscountId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer pShopId) {
        shopId = pShopId;
    }

    public String getDiscountDes() {
        return discountDes;
    }

    public void setDiscountDes(String pDiscountDes) {
        discountDes = pDiscountDes;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long pStartTime) {
        startTime = pStartTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long pEndTime) {
        endTime = pEndTime;
    }

    public Integer getDiscountPoint() {
        return discountPoint;
    }

    public void setDiscountPoint(Integer pDiscountPoint) {
        discountPoint = pDiscountPoint;
    }
}
