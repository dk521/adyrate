package com.gluespark.joker.gluespark;

import android.content.Context;
import android.util.Log;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Networking.ApiClient;
import com.gluespark.joker.gluespark.Networking.ApiInterfaceEndpoints;
import com.gluespark.joker.gluespark.Networking.ApiResponse;
import com.gluespark.joker.gluespark.Networking.ApiTopDealModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Junction {


    private AppDatabase mAppDatabase;
    private List<ApiTopDealModel> mList;
    private Executor mExecutor;

    private static Junction INSTANCE;

    public static Junction getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new Junction(context.getApplicationContext());
        }
        return INSTANCE;
    }

    //private constructor
    private Junction(Context applicationContext) {
        mAppDatabase = AppDatabase.getDatabase(applicationContext);
        getApiData();
        //can create Database here
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    private List<ApiTopDealModel> getApiData() {

        ApiInterfaceEndpoints apiService = ApiClient.getClient().create(ApiInterfaceEndpoints.class);
        Call<ApiResponse> call = apiService.getTopDeals();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                List<ApiTopDealModel> localTopDealModelList = null;
                if (response.body() != null) {
                    localTopDealModelList = response.body().getResults();
                }
                mList=localTopDealModelList;
                if (response.body() != null) {
                    String TotalDeals=response.body().getTotalResults();
                }
                //Log.d(TAG, "Number of deals received: " + localTopDealModelList.size());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("Network Data", t.toString());
            }
        });
        Log.d("Network Data:",""+mList);
        return mList;
    }
}




