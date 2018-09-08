package com.gluespark.joker.gluespark.Fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gluespark.joker.gluespark.Adapters.ProfileTabAdapter;
import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.activity.SettingsActivity;

public class ProfileFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ProfileTabAdapter adapter;
    Context mContext;
    private int[] tabIcons = {
            R.drawable.ic_star_black_24dp,
            R.drawable.ic_theaters_black_24dp,
            R.drawable.ic_bookmark_black_24dp
    };

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = container.getContext();
        View localView = inflater.inflate(R.layout.fragment_profile, container, false);
        Toolbar toolbar = localView.findViewById(R.id.toolbar_profile);
        final CollapsingToolbarLayout collapsingToolbarLayout = localView.findViewById(R.id.profile_collapse_bar);
        AppBarLayout appBarLayout = localView.findViewById(R.id.profile_appbar);
        setToolBar(toolbar, collapsingToolbarLayout, appBarLayout);

        viewPager = localView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = localView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        highLightCurrentTab(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return localView;
    }

    private void setToolBar(Toolbar pToolbar, final CollapsingToolbarLayout pCollapsingToolbarLayout, AppBarLayout pAppBarLayout) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(pToolbar);
        final ActionBar localActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (localActionBar != null) {
            localActionBar.setDisplayHomeAsUpEnabled(true);
        }


        pAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    pCollapsingToolbarLayout.setTitle("Kanye West");
                    pCollapsingToolbarLayout.setExpandedTitleMarginBottom(5);
                    pCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
                    isShow = true;
                } else if (isShow) {
                    pCollapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.profile_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Intent localIntent = new Intent(mContext, SettingsActivity.class);
                startActivity(localIntent);
                return true;

        }
        return false;
    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ProfileTabAdapter(((AppCompatActivity) getActivity()).getSupportFragmentManager(), mContext);
        adapter.addFragment(new ReviewFragment(), "Reviews", tabIcons[0]);
        adapter.addFragment(new coupon_fragment(), "Coupons", tabIcons[1]);
        adapter.addFragment(new ReviewFragment(), "Saved", tabIcons[2]);
        viewPager.setAdapter(adapter);
    }


}
