package com.gluespark.joker.gluespark;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Models.RewardingStore;

import java.util.ArrayList;

public class Junction {

    private LiveData<ArrayList<RewardingStore>> rewardingList;
    private AppDatabase mAppDatabase;

    private static Junction INSTANCE;

    public static Junction getInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = new Junction(context.getApplicationContext());
        }

        return INSTANCE;
    }

    //private constructor
    private Junction(Context applicationContext){
         mAppDatabase=AppDatabase.getDatabase(applicationContext);
        //can create Database here
    }
    public AppDatabase getAppDatabase(){
        return  mAppDatabase;
    }



}
