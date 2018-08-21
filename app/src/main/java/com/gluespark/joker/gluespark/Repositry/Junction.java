package com.gluespark.joker.gluespark.Repositry;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Database.TopDealModel;
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

public class Junction {


    private static AppDatabase mAppDatabase;
    private static List<ApiTopDealModel> mList;
    private static List<TopDealModel> mLocalDataList;
    //private Executor mExecutor;


    private static Junction INSTANCE;

    public static Junction getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = new Junction(context.getApplicationContext());
        }
        return INSTANCE;
    }

    private Junction(Context applicationContext) {
        mAppDatabase = AppDatabase.getDatabase(applicationContext);
        mLocalDataList = new ArrayList<>();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    public void CallNetwork() {
        getApiData();

    }

    private void getApiData() {

        ApiInterfaceEndpoints apiService = ApiClient.getClient().create(ApiInterfaceEndpoints.class);
        Call<ApiResponse> call = apiService.getTopDeals("https://api.myjson.com/bins/16qouk");
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d("Network Data",""+response.body().getTopDeals().get(0).getShopName());
                Log.d("Network Data",""+response.body().getTopDeals().get(1).getShopName());
                Log.d("Network Data",""+response.body().getTopDeals().get(2).getShopName());
                Log.d("Network Data",""+response.body().getTopDeals().get(3).getShopName());
                Log.d("Network Data",""+response.body().getTopDeals().get(4).getShopName());
                List<ApiTopDealModel> localTopDealModelList = null;
                if (response.body() != null) {
                    localTopDealModelList = response.body().getTopDeals();
                }
                mList = localTopDealModelList;
                if (response.body() != null) {
                    String TotalDeals = response.body().getCount();
                }
                new MyDataSync().execute();

                //Log.d("Network", ""+response.code());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("Network Data", t.toString());
            }
        });
        //Log.d("Network Data:",""+mList);
    }

    static class MyDataSync extends AsyncTask<Void ,Void,Integer> {


        @Override
        protected Integer doInBackground(Void... pLists) {
            ArrayList<TopDealModel> localModels = new ArrayList<>();
            for (ApiTopDealModel aPTopDealsList : mList) {
                String shopId = aPTopDealsList.getShopId();
                String shopName = aPTopDealsList.getShopName();
                String shopImage = aPTopDealsList.getShopLogo();
                String shopAddress = aPTopDealsList.getShopAddress();
                String shopRating = aPTopDealsList.getAvgRating();
                String discount1 = aPTopDealsList.getDiscount().get(0);
                String discount2 = aPTopDealsList.getDiscount().get(1);
                String point1 = aPTopDealsList.getPoints().get(0);
                String point2 = aPTopDealsList.getPoints().get(1);
                Log.d("BASE",shopName);
                TopDealModel localModel=new TopDealModel(shopId, shopAddress, shopImage,
                        shopName, shopRating, discount1, discount2, point1, point2);
                localModels.add(localModel);
                mAppDatabase.getTopDealDAO().addItemToTopDealModel(localModel);
            }
            mLocalDataList=localModels;
            Log.d("NET",mLocalDataList.get(0).getShopName());
            return 0;
        }

    }

}




