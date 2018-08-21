package com.gluespark.joker.gluespark;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gluespark.joker.gluespark.Adapters.CategoryAdapter;
import com.gluespark.joker.gluespark.Adapters.TopDealAdapter;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.Networking.ApiTopDealModel;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toast toast = null;

    private RecyclerView mCategoryRecyclerView;
    private RecyclerView mTopDealsRecyclerView;

    private CategoryAdapter mCategoryAdapter;
    private TopDealAdapter mTopDealAdapter;

    private MainActivityViewModel activityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        activityViewModel.getAllTopDeals().observe(MainActivity.this, new Observer<List<TopDealModel>>() {
            @Override
            public void onChanged(@Nullable List<TopDealModel> pTopDealModelArrayList) {
                mTopDealAdapter.swap(pTopDealModelArrayList);
            }
        });
        addCategory();
        addTopDeals();
    }

    private void addTopDeals() {
        mTopDealsRecyclerView = findViewById(R.id.topDealsRecyclerView);
        mTopDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mTopDealAdapter = new TopDealAdapter(this);

        mTopDealsRecyclerView.setAdapter(mTopDealAdapter);

        //swap adapters from viewModel

    }



    private void addCategory() {
        mCategoryRecyclerView = findViewById(R.id.category_recycler_view);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCategoryAdapter=new CategoryAdapter(this);
        mCategoryRecyclerView.setAdapter(mCategoryAdapter);
        mCategoryAdapter.swap(activityViewModel.getCategories());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_search:
                showToast("Coming Soon");
                break;
            case R.id.action_position:
                showToast("Coming Soon");
        }

        return super.onOptionsItemSelected(item);
    }

    //show toast
    private void showToast(String toastMessage) {

        if (toast == null) {
            toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
        } else {
            toast.cancel();
            toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
        }

        toast.show();

    }


}
