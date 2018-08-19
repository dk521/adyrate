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
import com.gluespark.joker.gluespark.Models.RewardingStore;
import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;

public class RewardingStoreAdapter extends RecyclerView.Adapter<RewardingStoreAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RewardingStore> rewardingStoreArrayList = null;

    public RewardingStoreAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rewarding_store,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return rewardingStoreArrayList == null ? 0 : rewardingStoreArrayList.size();
    }

    public void swap(ArrayList<RewardingStore> rewardingStore) {

        this.rewardingStoreArrayList = rewardingStore;
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

            Glide.with(context).load(rewardingStoreArrayList.get(position).getImageUrl()).into(storeImage);
            storeName.setText(rewardingStoreArrayList.get(position).getName());
            storeDescription.setText(rewardingStoreArrayList.get(position).getDescription());

            String discount = rewardingStoreArrayList.get(position).getDiscount();
            storeDiscount.setText("Earn upto "+discount+"% discount");


        }
    }
}
