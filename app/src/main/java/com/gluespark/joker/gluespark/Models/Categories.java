package com.gluespark.joker.gluespark.Models;



public class Categories {
    private int id;
    private int CategoryImage;
    private String ImageTitle;
    public Categories(int pId, int pCategoryImage, String pImageTitle) {
        id = pId;
        CategoryImage = pCategoryImage;
        ImageTitle = pImageTitle;
    }

    public int getId() {

        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public int getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(int pCategoryImage) {
        CategoryImage = pCategoryImage;
    }

    public String getImageTitle() {
        return ImageTitle;
    }

    public void setImageTitle(String pImageTitle) {
        ImageTitle = pImageTitle;
    }


}
