package com.gluespark.joker.gluespark.Networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterfaceEndpoints {


    @GET()
    Call<ApiResponseOuter> getDeals(@Url String url);
}

