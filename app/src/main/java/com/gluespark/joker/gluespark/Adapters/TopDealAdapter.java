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
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;
import java.util.List;

public class TopDealAdapter extends RecyclerView.Adapter<TopDealAdapter.ViewHolder> {

    private Context context;
    private List<TopDealModel> mDealModelArrayList = null;

    public TopDealAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rewarding_tab_item_design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mDealModelArrayList == null ? 0 : mDealModelArrayList.size();
    }


    public void swap(List<TopDealModel> pDealModelArrayList) {

        this.mDealModelArrayList = pDealModelArrayList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView storeImage;
        private TextView storeName,storeDescription,storeDiscount;

        public ViewHolder(View itemView) {
            super(itemView);

            storeImage = itemView.findViewById(R.id.rewardingStoreImageView);
            storeName = itemView.findViewById(R.id.rewardingStoreNameTV);
            storeDescription = itemView.findViewById(R.id.rewardingStoreDescTV);
            storeDiscount = itemView.findViewById(R.id.rewardingStoreDiscTV);

        }

        public void bind(int position) {

            Glide.with(context).load(mDealModelArrayList.get(position).getImageUrl()).into(storeImage);
            storeName.setText(mDealModelArrayList.get(position).getShopName());
            storeDescription.setText(mDealModelArrayList.get(position).getShopAddress());

            String discount = mDealModelArrayList.get(position).getShopDiscount1();
            storeDiscount.setText("Earn upto "+discount+"% discount");


        }
    }
}
