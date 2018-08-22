package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseOuter {
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("deal_types")
    @Expose
    private List<ApiResponseInner> dealTypes = null;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ApiResponseInner> getApiResponseInners() {
        return dealTypes;
    }

    public void setApiResponseInners(List<ApiResponseInner> dealTypes) {
        this.dealTypes = dealTypes;
    }
}
