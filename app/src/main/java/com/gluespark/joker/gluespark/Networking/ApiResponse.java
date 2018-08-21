package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("top_deals")
    @Expose
    private List<ApiTopDealModel> topDeals = null;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ApiTopDealModel> getTopDeals() {
        return topDeals;
    }

    public void setTopDeals(List<ApiTopDealModel> topDeals) {
        this.topDeals = topDeals;
    }
}
