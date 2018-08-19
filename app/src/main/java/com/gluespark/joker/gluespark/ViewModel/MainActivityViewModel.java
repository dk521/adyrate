package com.gluespark.joker.gluespark.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gluespark.joker.gluespark.Junction;
import com.gluespark.joker.gluespark.Models.RewardingStore;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<ArrayList<RewardingStore>> rewardingStoreList;
    private Junction junction;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        junction = Junction.getInstance(application.getApplicationContext());

    }

    public ArrayList<RewardingStore> getRewardingStore(){

        ArrayList<RewardingStore> stores = new ArrayList<>();
        stores.add(new RewardingStore("1","Pirates of Grill","https://static1.squarespace.com/static/53cc1616e4b0f4361f8ace24/t/59dbd676b7411c84d510910e/1507579512573/","Nort Indian","30"));
        stores.add(new RewardingStore("2","AM PM","https://i.pinimg.com/originals/0d/d2/f8/0dd2f8ac24be86cbb16ff9686647c425.jpg","Street Food, Sount Indian","20"));
        stores.add(new RewardingStore("3","The Throwback","https://cdn.styleblueprint.com/wp-content/uploads/2016/01/SB-BHM-Sky-Castle-1.jpg","Chines Continental","50"));
        stores.add(new RewardingStore("1","Pirates of Grill","https://static1.squarespace.com/static/53cc1616e4b0f4361f8ace24/t/59dbd676b7411c84d510910e/1507579512573/","Nort Indian","30"));
        stores.add(new RewardingStore("3","The Throwback","https://cdn.styleblueprint.com/wp-content/uploads/2016/01/SB-BHM-Sky-Castle-1.jpg","Chines Continental","50"));
        stores.add(new RewardingStore("2","AM PM","https://i.pinimg.com/originals/0d/d2/f8/0dd2f8ac24be86cbb16ff9686647c425.jpg","Street Food, Sount Indian","20"));

        return stores;

    }

}
