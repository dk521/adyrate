package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseInner {
    @SerializedName("deal_name")
    @Expose
    private String dealName;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("deals")
    @Expose
    private List<ApiSingleDealModel> deals = null;

    public String getDealType() {
        return dealName;
    }

    public void setDaelType(String dealName) {
        this.dealName = dealName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApiSingleDealModel> getApiInnerModels() {
        return deals;
    }

    public void setApiInnerModels(List<ApiSingleDealModel> deals) {
        this.deals = deals;
    }}
