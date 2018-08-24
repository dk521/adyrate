package com.gluespark.joker.gluespark.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.gluespark.joker.gluespark.Fragments.HomeFragment;
import com.gluespark.joker.gluespark.Fragments.ProfielFragment;
import com.gluespark.joker.gluespark.Fragments.WalletFragment;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity  implements ActivityCompat.OnRequestPermissionsResultCallback{

    private Toast toast = null;
    private MainActivityViewModel activityViewModel;
    private FragmentManager localManager;
    private BottomNavigationView mBottomNavigationView;

//    private static final int REQUEST_INTERNET = 0;
//    private static final int REQUEST_WRITE = 1;
//    private static final int REQUEST_READ = 2;
//    private static String[] PERMISSIONS_ACCESS = {Manifest.permission.INTERNET,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout localLayout = findViewById(R.id.root);
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        localManager=getSupportFragmentManager();
        mBottomNavigationView=findViewById(R.id.navigationView);
        viewFragment(new HomeFragment(),"Fragment_home");
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        viewFragment(new HomeFragment(),"Fragment_home");
                        return true;
                    case R.id.navigation_wallet:
                        viewFragment(new WalletFragment(), "Fragment_wallet");
                        return true;
                    case R.id.navigation_profile:
                        viewFragment(new ProfielFragment(), "Fragment_profile");
                        return true;
                        default:  viewFragment(new HomeFragment(),"Fragment_home");

                }
                return false;
            }
        });

//        addTopDeals();
//        activityViewModel.getAllTopDeals().observe(MainActivity.this, new Observer<List<TopDealModel>>() {
//            @Override
//            public void onChanged(@Nullable List<TopDealModel> pTopDealModelArrayList) {
//
//                mList=pTopDealModelArrayList;
//                mOuterAdapter.swap(pTopDealModelArrayList);
//            }
//        });
//
//        addCategory();

    }
    private void viewFragment(Fragment Fragment, String pFragment) {

        FragmentTransaction localFragmentTransaction=localManager.beginTransaction();
        localFragmentTransaction.replace(R.id.root,Fragment,pFragment);
        localFragmentTransaction.commit();
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

//    public void getPermission() {
//
//        if (ActivityCompat.checkSelfPermission
//                (this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.INTERNET)) {
//
//
////                Snackbar.make(mLayout, "Please grant internet to get data...",
////                        Snackbar.LENGTH_INDEFINITE)
////                        .setAction("OK", new View.OnClickListener() {
////                            @Override
////                            public void onClick(View view) {
////                                ActivityCompat.requestPermissions(MainActivity.this,
////                                        new String[]{Manifest.permission.INTERNET},
////                                        REQUEST_INTERNET);
////                            }
////                        })
////                        .show();
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
//                        REQUEST_INTERNET);
//            }
//
//        } else {
//
//            showToast("Internet Permission are already Granted....");
//        }
//    }
}
