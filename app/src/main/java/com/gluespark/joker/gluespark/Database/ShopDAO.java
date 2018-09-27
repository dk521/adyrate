package com.gluespark.joker.gluespark.Database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ShopDAO {

    @Query("select * from SingleShopModel")
    LiveData<List<SingleShopModel>> getAllTopDealModel();

    @Query("select * from SingleShopModel where shop_id=:id")
    SingleShopModel getItemById(String id);

    @Insert(onConflict = REPLACE)
    void addItemToTopDealModel(SingleShopModel pSingleShopModel);

    @Delete
    void deleteTopDealModel(SingleShopModel pSingleShopModel);

}