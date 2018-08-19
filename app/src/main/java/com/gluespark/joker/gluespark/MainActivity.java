package com.gluespark.joker.gluespark;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gluespark.joker.gluespark.Adapters.CategoryAdapter;
import com.gluespark.joker.gluespark.Adapters.RecentReviewsAdapter;
import com.gluespark.joker.gluespark.Adapters.RewardingStoreAdapter;
import com.gluespark.joker.gluespark.Adapters.TopDealAdapter;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private Toast toast = null;
    private RecyclerView rewardingStoreRecycelerView;
    private RecyclerView mCategoryRecyclerView;
    private RecyclerView mTopDealsRecyclerView;
    private RecyclerView mRecentReviewsRecyclerView;
    private CategoryAdapter mCategoryAdapter;
    private RecentReviewsAdapter mRecentReviewsAdapter;
    private RewardingStoreAdapter rewardingStoreAdapter;
    private TopDealAdapter mTopDealAdapter;

    private MainActivityViewModel activityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        addCategory();

        addRewardingStore();

        addTopDeals();
        addRecentReviews();

        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    private void addTopDeals() {
        mTopDealsRecyclerView = findViewById(R.id.topDealsRecyclerView);
        mTopDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mTopDealAdapter = new TopDealAdapter(this);

        mTopDealsRecyclerView.setAdapter(rewardingStoreAdapter);

        //swap adapters from viewModel
        mTopDealAdapter.swap(activityViewModel.getRewardingStore());
    }

    private void addRewardingStore() {
        rewardingStoreRecycelerView = findViewById(R.id.rewardingStoreRecyclerView);
        rewardingStoreRecycelerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rewardingStoreAdapter = new RewardingStoreAdapter(this);

        rewardingStoreRecycelerView.setAdapter(rewardingStoreAdapter);

        //swap adapters from viewModel
        rewardingStoreAdapter.swap(activityViewModel.getRewardingStore());
    }

    private void addCategory() {
        mCategoryRecyclerView = findViewById(R.id.category_recycler_view);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCategoryAdapter=new CategoryAdapter(this);
        mCategoryRecyclerView.setAdapter(mCategoryAdapter);
        mCategoryAdapter.swap(activityViewModel.getCategories());
    }
    private void addRecentReviews() {
       mRecentReviewsRecyclerView = findViewById(R.id.recentReviewsRecyclerView);
       mRecentReviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
       mRecentReviewsAdapter=new RecentReviewsAdapter(this);
       mRecentReviewsRecyclerView.setAdapter(mRecentReviewsAdapter);
        mRecentReviewsAdapter.swap(activityViewModel.getRewardingStore());
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
