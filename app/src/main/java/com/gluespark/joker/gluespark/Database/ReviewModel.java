package com.gluespark.joker.gluespark.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class ReviewModel {

    @ColumnInfo(name = "id")
    private Integer reviewId;
    @ColumnInfo(name = "comment")
    private String reviewComment;
    @ColumnInfo(name = "rating")
    private String reviewRating;
    @ColumnInfo(name = "timestamp")
    private Long reviewTimestamp;
    @ColumnInfo(name = "shop_id")
    private Integer shopId;
    @ColumnInfo(name = "shop_name")
    private String shopName;
    @ColumnInfo(name = "shop_image_url")
    private String shopImageUrl;

    public ReviewModel(Integer pReviewId, String pReviewComment, String pReviewRating, Long pReviewTimestamp, Integer pShopId, String pShopName, String pShopImageUrl) {
        reviewId = pReviewId;
        reviewComment = pReviewComment;
        reviewRating = pReviewRating;
        reviewTimestamp = pReviewTimestamp;
        shopId = pShopId;
        shopName = pShopName;
        shopImageUrl = pShopImageUrl;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer pReviewId) {
        reviewId = pReviewId;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String pReviewComment) {
        reviewComment = pReviewComment;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String pReviewRating) {
        reviewRating = pReviewRating;
    }

    public Long getReviewTimestamp() {
        return reviewTimestamp;
    }

    public void setReviewTimestamp(Long pReviewTimestamp) {
        reviewTimestamp = pReviewTimestamp;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer pShopId) {
        shopId = pShopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String pShopName) {
        shopName = pShopName;
    }

    public String getShopImageUrl() {
        return shopImageUrl;
    }

    public void setShopImageUrl(String pShopImageUrl) {
        shopImageUrl = pShopImageUrl;
    }
}
