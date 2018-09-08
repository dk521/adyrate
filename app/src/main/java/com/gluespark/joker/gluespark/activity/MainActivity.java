package com.gluespark.joker.gluespark.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.gluespark.joker.gluespark.Fragments.BaseFragment;
import com.gluespark.joker.gluespark.Fragments.HomeFragment;
import com.gluespark.joker.gluespark.Fragments.NotificationFragment;
import com.gluespark.joker.gluespark.Fragments.ProfileFragment;
import com.gluespark.joker.gluespark.Fragments.ScannerFragment;
import com.gluespark.joker.gluespark.Fragments.WalletFragment;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.Utils.FragmentHistory;
import com.gluespark.joker.gluespark.Utils.Utils;
import com.gluespark.joker.gluespark.ViewModel.MainActivityViewModel;
import com.gluespark.joker.gluespark.Views.FragNavController;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener {

    private Toast toast = null;
    private MainActivityViewModel activityViewModel;
    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    private int[] mTabIconsSelected = {
            R.drawable.tab_home,
            R.drawable.tab_wallet,
            R.drawable.tab_qr_scanner,
            R.drawable.tab_notification,
            R.drawable.tab_profile};
    @BindArray(R.array.tab_name)
    String[] TABS;
    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;
    private FragNavController mNavController;
    private FragmentHistory fragmentHistory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        ButterKnife.bind(this);
        initTab();
        fragmentHistory = new FragmentHistory();
        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.content_frame)
                .transactionListener(this)
                .rootFragmentListener(this, TABS.length)
                .build();
        switchTab(0);
        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentHistory.push(tab.getPosition());
                switchTab(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mNavController.clearStack();
                switchTab(tab.getPosition());
            }
        });

    }

    private void initTab() {
        if (bottomTabLayout != null) {
            for (int i = 0; i < TABS.length; i++) {
                bottomTabLayout.addTab(bottomTabLayout.newTab());
                TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(getTabView(i));
            }
        }
    }


    private View getTabView(int position) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item_bottom, null);
        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);
        icon.setImageDrawable(Utils.setDrawableSelector(MainActivity.this, mTabIconsSelected[position], mTabIconsSelected[position]));
        return view;
    }

    private void switchTab(int position) {
        mNavController.switchTab(position);
        }
    @Override
    public void onBackPressed() {

        if (!mNavController.isRootFragment()) {
            mNavController.popFragment();
        } else {

            if (fragmentHistory.isEmpty()) {
                super.onBackPressed();
            } else {


                if (fragmentHistory.getStackSize() > 1) {

                    int position = fragmentHistory.popPrevious();

                    switchTab(position);

                    updateTabSelection(position);

                } else {

                    switchTab(0);

                    updateTabSelection(0);

                    fragmentHistory.emptyStack();
                }
            }

        }
    }


    private void updateTabSelection(int currentTab) {

        for (int i = 0; i < TABS.length; i++) {
            TabLayout.Tab selectedTab = bottomTabLayout.getTabAt(i);
            if (currentTab != i) {
                selectedTab.getCustomView().setSelected(false);
            } else {
                selectedTab.getCustomView().setSelected(true);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }


    @Override
    public void onTabTransaction(Fragment fragment, int index) {
    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {

            case FragNavController.TAB1:
                return new HomeFragment();
            case FragNavController.TAB2:
                return new WalletFragment();
            case FragNavController.TAB3:
                return new ScannerFragment();
            case FragNavController.TAB4:
                return new NotificationFragment();
            case FragNavController.TAB5:
                return new ProfileFragment();


        }
        throw new IllegalStateException("Need to send an index that we know");
    }


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
