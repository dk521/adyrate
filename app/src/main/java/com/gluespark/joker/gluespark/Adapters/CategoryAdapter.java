package com.gluespark.joker.gluespark.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gluespark.joker.gluespark.Models.Categories;
import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategotyHolder> {

    private Context mContext;
    private ArrayList<Categories> mCategories = null;

    public CategoryAdapter(Context pContext) {
        mContext = pContext;
    }

    @NonNull
    @Override
    public CategotyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View localView = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_tab_item_design, parent, false);
        return new CategotyHolder(localView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategotyHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mCategories == null ? 0 : mCategories.size();
    }

    public void swap(ArrayList<Categories> pCategories ) {

        this.mCategories = pCategories;
        notifyDataSetChanged();

    }

    class CategotyHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public CategotyHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.category_tab_image);
            mTextView = itemView.findViewById(R.id.category_tab_title);

        }

        public void onBind(int position) {
            mTextView.setText(mCategories.get(position).getImageTitle());
            Glide.with(mContext)
                    .load(mCategories.get(position).getCategoryImage())
                    .into(mImageView);
        }
    }
}
