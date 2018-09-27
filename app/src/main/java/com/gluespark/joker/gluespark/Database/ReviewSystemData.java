package com.gluespark.joker.gluespark.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class ReviewSystemData {

    @ColumnInfo(name = "id")
    private Integer reviewId;
    @ColumnInfo(name = "rating")
    private String productRating;
    @ColumnInfo(name = "comment")
    private String productComment;
    @ColumnInfo(name = "timestamp")
    private Long timestamp;
    @ColumnInfo(name = "user_id")
    private Integer userId;
    @ColumnInfo(name = "shop_id")
    private  Integer shopId;

    public ReviewSystemData(Integer pReviewId, String pProductRating, String pProductComment, Long pTimestamp, Integer pUserId, Integer pShopId) {
        reviewId = pReviewId;
        productRating = pProductRating;
        productComment = pProductComment;
        timestamp = pTimestamp;
        userId = pUserId;
        shopId = pShopId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer pReviewId) {
        reviewId = pReviewId;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String pProductRating) {
        productRating = pProductRating;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String pProductComment) {
        productComment = pProductComment;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long pTimestamp) {
        timestamp = pTimestamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer pUserId) {
        userId = pUserId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer pShopId) {
        shopId = pShopId;
    }
}
