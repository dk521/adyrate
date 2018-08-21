package com.gluespark.joker.gluespark.Networking;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaceEndpoints {


    @GET("16quok")
    Call<ApiResponse> getTopDeals();
}

