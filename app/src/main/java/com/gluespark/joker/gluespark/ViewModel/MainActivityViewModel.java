package com.gluespark.joker.gluespark.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gluespark.joker.gluespark.Junction;
import com.gluespark.joker.gluespark.Models.Categories;
import com.gluespark.joker.gluespark.Models.RewardingStore;
import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<ArrayList<RewardingStore>> rewardingStoreList;
    private Junction junction;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        junction = Junction.getInstance(application.getApplicationContext());

    }

    public ArrayList<RewardingStore> getRewardingStore() {

        ArrayList<RewardingStore> stores = new ArrayList<>();
        stores.add(new RewardingStore("1", "Pirates of Grill", "https://static1.squarespace.com/static/53cc1616e4b0f4361f8ace24/t/59dbd676b7411c84d510910e/1507579512573/", "Nort Indian", "30"));
        stores.add(new RewardingStore("2", "AM PM", "https://i.pinimg.com/originals/0d/d2/f8/0dd2f8ac24be86cbb16ff9686647c425.jpg", "Street Food, Sount Indian", "20"));
        stores.add(new RewardingStore("3", "The Throwback", "https://cdn.styleblueprint.com/wp-content/uploads/2016/01/SB-BHM-Sky-Castle-1.jpg", "Chines Continental", "50"));
        stores.add(new RewardingStore("1", "Pirates of Grill", "https://static1.squarespace.com/static/53cc1616e4b0f4361f8ace24/t/59dbd676b7411c84d510910e/1507579512573/", "Nort Indian", "30"));
        stores.add(new RewardingStore("3", "The Throwback", "https://cdn.styleblueprint.com/wp-content/uploads/2016/01/SB-BHM-Sky-Castle-1.jpg", "Chines Continental", "50"));
        stores.add(new RewardingStore("2", "AM PM", "https://i.pinimg.com/originals/0d/d2/f8/0dd2f8ac24be86cbb16ff9686647c425.jpg", "Street Food, Sount Indian", "20"));

        return stores;

    }

    public ArrayList<Categories> getCategories() {
        ArrayList<Categories> localCategoriesArrayList = new ArrayList<>();
        int[] images = {R.drawable.category_image1,
                R.drawable.category_image2,
                R.drawable.category_image3,
                R.drawable.category_image4,
                R.drawable.category_image5,
                R.drawable.category_image6,
                R.drawable.category_image7,
                R.drawable.category_image8,
                R.drawable.category_image9,
                R.drawable.category_image10,
                R.drawable.category_image11,
                R.drawable.category_image12};
        String[] title = {"Electronics", "Fitness", "Hotel", "Food", "Medical", "Discounts", "Travel"
        ,"Games","Drinks","Footwear","Grocery","Salon"};
        int[] ids = {1, 2, 3, 4, 5, 6, 7,8,9,10,11,12};
        for (int i = 0; i < images.length; i++) {
            localCategoriesArrayList.add(new Categories(ids[i], images[i], title[i]));
        }
        return localCategoriesArrayList;
    }

}
