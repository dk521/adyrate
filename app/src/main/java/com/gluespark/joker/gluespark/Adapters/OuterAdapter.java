package com.gluespark.joker.gluespark.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.R;

import java.util.List;

public class OuterAdapter extends RecyclerView.Adapter<OuterAdapter.OuterHolder> {

    private List<TopDealModel> mList = null;
    private Context mContext;
    private RecyclerView.RecycledViewPool viewPool;
    public OuterAdapter(Context pContext) {
        mContext = pContext;
      //  viewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public OuterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_inner_recycler_view, parent, false);
        return new OuterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OuterHolder holder, int position) {
      holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
    public void swap(List<TopDealModel> pDealModelArrayList) {

        this.mList = pDealModelArrayList;
        notifyDataSetChanged();

    }

    class OuterHolder extends RecyclerView.ViewHolder {

        private TextView dealTitle;
        private TextView dealDiscription;
        private RecyclerView innerRecyclerView;

        public OuterHolder(View itemView) {
            super(itemView);
            dealTitle = itemView.findViewById(R.id.text_deal_type);
            dealDiscription = itemView.findViewById(R.id.text_deal_description);
            innerRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
        }

        public void onBind(int position) {

            dealTitle.setText(mList.get(position).getDealTitle());
            Log.d("nii",mList.get(position).getDealTitle());
            dealDiscription.setText(mList.get(position).getDealDescription());
           // innerRecyclerView.setRecycledViewPool(viewPool);
            innerRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            innerRecyclerView.setNestedScrollingEnabled(false);
            InnerAdapter mInnerAdapter = new InnerAdapter(mContext);
            mInnerAdapter.swap(mList);
            innerRecyclerView.setAdapter(mInnerAdapter);
        }
    }
}
