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
import com.gluespark.joker.gluespark.Adapters.RewardingStoreAdapter;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private Toast toast = null;
    private RecyclerView rewardingStoreRecycelerView;
    private RecyclerView mCategoryRecyclerView;
    private CategoryAdapter mCategoryAdapter;
    private RewardingStoreAdapter rewardingStoreAdapter;

    private MainActivityViewModel activityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mCategoryRecyclerView = findViewById(R.id.category_recycler_view);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCategoryAdapter=new CategoryAdapter(this);
        mCategoryRecyclerView.setAdapter(mCategoryAdapter);
        mCategoryAdapter.swap(activityViewModel.getCategories());

        rewardingStoreRecycelerView = findViewById(R.id.rewardingStoreRecyclerView);
        rewardingStoreRecycelerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rewardingStoreAdapter = new RewardingStoreAdapter(this);

        rewardingStoreRecycelerView.setAdapter(rewardingStoreAdapter);

        //swap adapters from viewModel
        rewardingStoreAdapter.swap(activityViewModel.getRewardingStore());

        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
