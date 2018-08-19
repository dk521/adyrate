package com.gluespark.joker.gluespark.Database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TopDealDAO {

    @Query("select * from TopDealModel")
    LiveData<ArrayList<TopDealModel>> getAllTopDealModel();

    @Query("select * from TopDealModel where shop_id=:id")
    TopDealModel getItemById(String id);

    @Insert(onConflict = REPLACE)
    void addItemToTopDealModel(TopDealModel pTopDealModel);

    @Delete
    void deleteTopDealModel(TopDealModel pTopDealModel);

}