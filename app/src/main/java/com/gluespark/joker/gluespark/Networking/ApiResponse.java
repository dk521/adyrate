package com.gluespark.joker.gluespark.Networking;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    @SerializedName("top_deals")
    private List<ApiTopDealModel> results;
    @SerializedName("count")
    private String  totalResults;

    public List<ApiTopDealModel> getResults() {
        return results;
    }

    public void setResults(List<ApiTopDealModel> pResults) {
        results = pResults;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String pTotalResults) {
        totalResults = pTotalResults;
    }
}
