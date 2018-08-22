package com.gluespark.joker.gluespark.Repositry;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.Networking.ApiClient;
import com.gluespark.joker.gluespark.Networking.ApiInterfaceEndpoints;
import com.gluespark.joker.gluespark.Networking.ApiResponseInner;
import com.gluespark.joker.gluespark.Networking.ApiResponseOuter;
import com.gluespark.joker.gluespark.Networking.ApiSingleDealModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Junction {


    private static AppDatabase mAppDatabase;
    private static List<ApiSingleDealModel> mInnerList;
    private static List<ApiResponseInner> mList;
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
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

    public void CallNetwork() {
        getApiData();

    }

    private void getApiData() {

        ApiInterfaceEndpoints apiService = ApiClient.getClient().create(ApiInterfaceEndpoints.class);
        Call<ApiResponseOuter> call = apiService.getDeals("https://api.myjson.com/bins/18umq0");
        call.enqueue(new Callback<ApiResponseOuter>() {
            @Override
            public void onResponse(Call<ApiResponseOuter> call, Response<ApiResponseOuter> response) {

                List<ApiResponseInner> mInnerResponseList=null;
                if (response.body() != null) {
                    mInnerResponseList = response.body().getApiResponseInners();
                }
                mList =mInnerResponseList;
                new MyDataSync().execute();
            }

            @Override
            public void onFailure(Call<ApiResponseOuter> call, Throwable t) {
                // Log error here since request failed
                Log.e("Network Data", t.toString());
            }
        });
        //Log.d("Network Data:",""+mList);
    }

    static class MyDataSync extends AsyncTask<Void ,Void,Integer> {


        @Override
        protected Integer doInBackground(Void... pLists) {
            String DealType=null;
            String DealDescription=null;
            for(ApiResponseInner list:mList){
                DealType=list.getDealType();
                DealDescription=list.getDescription();
                List<ApiSingleDealModel> pList=list.getApiInnerModels();
                for (ApiSingleDealModel aPTopDealsList : pList) {
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
                            shopName, shopRating, discount1, discount2, point1, point2,DealType,DealDescription);
                    mAppDatabase.getTopDealDAO().addItemToTopDealModel(localModel);
                }

            }

            return 0;
        }

    }

}




