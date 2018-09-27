package com.gluespark.joker.gluespark.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class TotalDealModel {

    @PrimaryKey()
    @ColumnInfo(name = "deal_id")
    private Integer dealId;

    @ColumnInfo(name = "deal_title")
    private String dealTitle;

    @ColumnInfo(name = "deal_description")
    private String dealDescription;

    public TotalDealModel(Integer pDealId, String pDealTitle, String pDealDescription) {
        dealId = pDealId;
        dealTitle = pDealTitle;
        dealDescription = pDealDescription;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer pDealId) {
        dealId = pDealId;
    }

    public String getDealTitle() {
        return dealTitle;
    }

    public void setDealTitle(String pDealTitle) {
        dealTitle = pDealTitle;
    }

    public String getDealDescription() {
        return dealDescription;
    }

    public void setDealDescription(String pDealDescription) {
        dealDescription = pDealDescription;
    }
}
