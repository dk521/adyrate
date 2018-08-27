package com.gluespark.joker.gluespark.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gluespark.joker.gluespark.R;

public class ProfieFragment extends Fragment {


    public ProfieFragment() {
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
        View localView = inflater.inflate(R.layout.fragment_profiel, container, false);
        Toolbar toolbar = localView.findViewById(R.id.toolbar_profile);
        final CollapsingToolbarLayout collapsingToolbarLayout = localView.findViewById(R.id.profile_collapse_bar);
        AppBarLayout appBarLayout = localView.findViewById(R.id.profile_appbar);
        setToolBar(toolbar, collapsingToolbarLayout,appBarLayout);
        return localView;
    }

    private void setToolBar(Toolbar pToolbar, final CollapsingToolbarLayout pCollapsingToolbarLayout, AppBarLayout pAppBarLayout) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(pToolbar);
        ActionBar localActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
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
        inflater.inflate(R.menu.profile_menu,menu);
    }
}
