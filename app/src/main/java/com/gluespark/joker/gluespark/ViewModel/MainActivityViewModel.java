package com.gluespark.joker.gluespark.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gluespark.joker.gluespark.Database.AppDatabase;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.Junction;
import com.gluespark.joker.gluespark.Models.Categories;
import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<TopDealModel>> mTopDealData;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        Junction localJunction = Junction.getInstance(application.getApplicationContext());
        AppDatabase localDatabase = localJunction.getAppDatabase();
       mTopDealData= localDatabase.getTopDealDAO().getAllTopDealModel();
    }

    public LiveData<List<TopDealModel>> getAllTopDeals() {
        return mTopDealData;
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
