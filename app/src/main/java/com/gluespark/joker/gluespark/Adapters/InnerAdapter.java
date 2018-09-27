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
import com.gluespark.joker.gluespark.Database.SingleShopModel;
import com.gluespark.joker.gluespark.R;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter {

    private Context context;
    private boolean flag = false;
    private int mposition = 0;
    private List<SingleShopModel> mDealModelArrayList = null;

    public InnerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case SingleShopModel.IMAGE_TYPE:
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dael_next_layout, parent, false);
                return new NextHolder(v);
            case SingleShopModel.DEAL_TYPE:
                View localView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_single_shop_design, parent, false);
                return new ViewHolder(localView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (position){
            case 4:
                ((NextHolder)holder).onBind2(position);
                break;
                default: ((ViewHolder)holder).onBind1(position);
        }

    }

    @Override
    public int getItemCount() {
        return mDealModelArrayList == null ? 0 : mDealModelArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 4: return SingleShopModel.IMAGE_TYPE;
            default: return SingleShopModel.DEAL_TYPE;
        }
    }

    public void swap(List<SingleShopModel> pDealModelArrayList) {

        this.mDealModelArrayList = pDealModelArrayList;
        notifyDataSetChanged();

    }

    class NextHolder extends RecyclerView.ViewHolder {

        private ImageView next;

        public NextHolder(View itemView) {
            super(itemView);
            next = itemView.findViewById(R.id.next);
        }

        void onBind2(int position) {
            Glide.with(context).load(R.drawable.next).into(next);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView storeImage;
        private TextView storeName, storeDescription, storeDiscount;

        ViewHolder(View itemView) {
            super(itemView);
            storeImage = itemView.findViewById(R.id.rewardingStoreImageView);
            storeName = itemView.findViewById(R.id.rewardingStoreNameTV);
            storeDescription = itemView.findViewById(R.id.rewardingStoreDescTV);
            storeDiscount = itemView.findViewById(R.id.rewardingStoreDiscTV);
        }

        void onBind1(int position) {
            Glide.with(context).load(mDealModelArrayList.get(position).getImageUrl()).into(storeImage);
            storeName.setText(mDealModelArrayList.get(position).getShopName());
            storeDescription.setText(mDealModelArrayList.get(position).getShopAddress());
            String discount = mDealModelArrayList.get(position).getShopDiscount1();
            String dis = "Earn upto " + discount + " discount";
            storeDiscount.setText(dis);


        }
    }
}
