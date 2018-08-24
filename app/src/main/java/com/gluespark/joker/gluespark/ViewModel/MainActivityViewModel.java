package com.gluespark.joker.gluespark.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.Models.Categories;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.Repositry.Junction;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<TopDealModel>> mTopDealData;
    private AppDatabase localDatabase;
    private Junction localJunction;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        Log.d("Network", "VIEWMODEL");
        localJunction = Junction.getInstance(application.getApplicationContext());
        localDatabase = localJunction.getAppDatabase();
    }

    public LiveData<List<TopDealModel>> getAllTopDeals() {
        localJunction.CallNetwork();
        return localDatabase.getTopDealDAO().getAllTopDealModel();
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
                , "Games", "Drinks", "Footwear", "Grocery", "Salon"};
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int i = 0; i < images.length; i++) {
            localCategoriesArrayList.add(new Categories(ids[i], images[i], title[i]));
        }
        return localCategoriesArrayList;
    }

}
