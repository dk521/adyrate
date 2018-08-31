package com.gluespark.joker.gluespark.Models;

import java.util.ArrayList;

public class ProfileHeaderInfo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public ArrayList<ProfileDetailInfo> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<ProfileDetailInfo> pProductList) {
        productList = pProductList;
    }


    private ArrayList<ProfileDetailInfo> productList = new ArrayList<>();

}
