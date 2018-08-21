package com.gluespark.joker.gluespark.Activities;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gluespark.joker.gluespark.Adapters.CategoryAdapter;
import com.gluespark.joker.gluespark.Adapters.InnerAdapter;
import com.gluespark.joker.gluespark.Database.TopDealModel;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements ActivityCompat.OnRequestPermissionsResultCallback{

    private Toast toast = null;

    private RecyclerView mCategoryRecyclerView;
    private RecyclerView mTopDealsRecyclerView;
    private ConstraintLayout mLayout;
    private CategoryAdapter mCategoryAdapter;
    private InnerAdapter mInnerAdapter;

    private MainActivityViewModel activityViewModel;

    private static final int REQUEST_INTERNET = 0;
    private static final int REQUEST_WRITE = 1;
    private static final int REQUEST_READ = 2;
    private static String[] PERMISSIONS_ACCESS = {Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout=findViewById(R.id.root);
        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // getPermission();
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        activityViewModel.getAllTopDeals().observe(MainActivity.this, new Observer<List<TopDealModel>>() {
            @Override
            public void onChanged(@Nullable List<TopDealModel> pTopDealModelArrayList) {
                mInnerAdapter.swap(pTopDealModelArrayList);
            }
        });
        addCategory();
        addTopDeals();
    }

    private void addTopDeals() {
        mTopDealsRecyclerView = findViewById(R.id.topDealsRecyclerView);
        mTopDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mInnerAdapter = new InnerAdapter(this);
        mTopDealsRecyclerView.setAdapter(mInnerAdapter);
    }

    private void addCategory() {
        mCategoryRecyclerView = findViewById(R.id.category_recycler_view);
        mCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCategoryAdapter = new CategoryAdapter(this);
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

    public void getPermission() {

        if (ActivityCompat.checkSelfPermission
                (this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {


                Snackbar.make(mLayout, "Please grant internet to get data...",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.INTERNET},
                                        REQUEST_INTERNET);
                            }
                        })
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                        REQUEST_INTERNET);
            }

        } else {

            showToast("Internet Permission are already Granted....");
        }
    }
}
