package com.gluespark.joker.gluespark.Activities;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.gluespark.joker.gluespark.Adapters.BottomBarAdapter;
import com.gluespark.joker.gluespark.Adapters.NoSwipePager;
import com.gluespark.joker.gluespark.Fragments.HomeFragment;
import com.gluespark.joker.gluespark.Fragments.ProfileFragment;
import com.gluespark.joker.gluespark.Fragments.WalletFragment;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private Toast toast = null;
    private final int[] colors = {R.color.bottomtab_0, R.color.bottomtab_1, R.color.bottomtab_2};
    private MainActivityViewModel activityViewModel;
    private FragmentManager localManager;
    private NoSwipePager viewPager;
    private BottomBarAdapter pagerAdapter;
    private AHBottomNavigation mBottomNavigationView;
    private boolean notificationVisible = false;
    private static final int REQUEST_INTERNET = 0;
    private static final int REQUEST_WRITE = 1;
    private static final int REQUEST_READ = 2;
    private static String[] PERMISSIONS_ACCESS = {Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // FrameLayout localLayout = findViewById(R.id.root);
        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        localManager = getSupportFragmentManager();
        setupViewPager();

        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setBehaviorTranslationEnabled(true);


       mBottomNavigationView.setCurrentItem(0);

        setupBottomNavStyle();

        createFakeNotification();

        addBottomNavItems();
        mBottomNavigationView.setCurrentItem(0);
       mBottomNavigationView.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
//                fragment.updateColor(ContextCompat.getColor(MainActivity.this, colors[position]));

                if (!wasSelected)
                    viewPager.setCurrentItem(position);

                // remove notification badge
                int lastItemPos =mBottomNavigationView.getItemsCount() - 1;
                if (notificationVisible && position == lastItemPos)
                   mBottomNavigationView.setNotification(new AHNotification(), lastItemPos);

                return true;
            }
        });

    }
    private void addBottomNavItems() {
        AHBottomNavigationItem itemHome =
                new AHBottomNavigationItem("Home",
                        R.drawable.ic_home);
        AHBottomNavigationItem itemWallet =
                new AHBottomNavigationItem("Wallet",
                        R.drawable.ic_account_balance_wallet_black_24dp);
//        AHBottomNavigationItem itemNotification =
//                new AHBottomNavigationItem("Notification",
//                        R.drawable.ic_notifications_whiye_24dp);
        AHBottomNavigationItem itemProfile =
                new AHBottomNavigationItem("Profile",
                        R.drawable.ic_person_black_24dp);
        mBottomNavigationView.addItem(itemHome);
        mBottomNavigationView.addItem(itemWallet);

        mBottomNavigationView.addItem(itemProfile);
    }
    private void setupViewPager() {
        viewPager = (NoSwipePager) findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        pagerAdapter.addFragments(new HomeFragment());
        pagerAdapter.addFragments(new WalletFragment());
        pagerAdapter.addFragments(new ProfileFragment());

        viewPager.setAdapter(pagerAdapter);
    }
    private void createFakeNotification() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AHNotification notification = new AHNotification.Builder()
                        .setText("1")
                        .setBackgroundColor(Color.YELLOW)
                        .setTextColor(Color.BLACK)
                        .build();
                // Adding notification to last item.

                mBottomNavigationView.setNotification(notification, mBottomNavigationView.getItemsCount() - 1);

                notificationVisible = true;
            }
        }, 1000);
    }
    private void setupBottomNavStyle() {
        /*
        Set Bottom Navigation colors. Accent color for active item,
        Inactive color when its view is disabled.
        Will not be visible if setColored(true) and default current item is set.
         */
      // mBottomNavigationView.setDefaultBackgroundColor(fetchColor(R.color.blue_500));
       mBottomNavigationView.setAccentColor(fetchColor(R.color.bottomtab_0));
       mBottomNavigationView.setInactiveColor(fetchColor(R.color.bottomtab_item_resting));

        // Colors for selected (active) and non-selected items.
       mBottomNavigationView.setColoredModeColors(Color.WHITE,
                fetchColor(R.color.bottomtab_item_resting));

        //  Enables Reveal effect
       mBottomNavigationView.setColored(true);

        //  Displays item Title always (for selected and non-selected items)
       mBottomNavigationView.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
    }
    private int fetchColor(@ColorRes int color) {
        return ContextCompat.getColor(this, color);
    }

//    private void viewFragment(Fragment Fragment, String pFragment) {
//
////        FragmentTransaction localFragmentTransaction = localManager.beginTransaction();
////        localFragmentTransaction.replace(R.id.root, Fragment, pFragment);
////        localFragmentTransaction.commit();
////    }
//
//
//    //show toast
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



                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.INTERNET},
                                        REQUEST_INTERNET);

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                        REQUEST_INTERNET);
            }

        } else {

            showToast("Internet Permission are already Granted....");
        }
    }
}
