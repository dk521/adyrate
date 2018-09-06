package com.gluespark.joker.gluespark.Fragments;


import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gluespark.joker.gluespark.activity.LocationTracker;
import com.gluespark.joker.gluespark.Adapters.CategoryAdapter;
import com.gluespark.joker.gluespark.Adapters.OuterAdapter;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;


public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private MainActivityViewModel activityViewModel;
    private Context mContext;
    private RecyclerView mCategoryRecyclerView;
    private RecyclerView mOuterRecyclerView;
    private ConstraintLayout mLayout;
    private CategoryAdapter mCategoryAdapter;
    private OuterAdapter mOuterAdapter;
    private Toast toast;

    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View localView = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = container.getContext();
        mLayout = localView.findViewById(R.id.root);
        mOuterRecyclerView = localView.findViewById(R.id.outerRecyclerView);
        mCategoryRecyclerView = localView.findViewById(R.id.category_recycler_view);
        Toolbar toolbar = localView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        addTopDeals();
        activityViewModel.getAllTopDeals().observe(getActivity(), new Observer<List<TopDealModel>>() {
            @Override
            public void onChanged(@Nullable List<TopDealModel> pTopDealModelArrayList) {

                //    mList=pTopDealModelArrayList;
                mOuterAdapter.swap(pTopDealModelArrayList);
            }
        });

        addCategory();

        return localView;
    }

    private void addTopDeals() {

        mOuterRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mOuterAdapter = new OuterAdapter(mContext);
        mOuterRecyclerView.setAdapter(mOuterAdapter);
    }

    private void addCategory() {

        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mCategoryAdapter = new CategoryAdapter(mContext);
        mCategoryRecyclerView.setAdapter(mCategoryAdapter);
        mCategoryAdapter.swap(activityViewModel.getCategories());

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                showToast("Coming Soon");
                break;
            case R.id.action_position:
                if(isServicesOK()) {
                    Intent intent = new Intent(mContext, LocationTracker.class);
                    startActivity(intent);
                }
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(mContext);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog((AppCompatActivity)getActivity(), available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
          showToast("Can't get location. ERROR!!");
        }
        return false;
    }

    //show toast
    private void showToast(String toastMessage) {

        if (toast == null) {
            toast = Toast.makeText(mContext, toastMessage, Toast.LENGTH_SHORT);
        } else {
            toast.cancel();
            toast = Toast.makeText(mContext, toastMessage, Toast.LENGTH_SHORT);
        }
        toast.show();

    }

}
