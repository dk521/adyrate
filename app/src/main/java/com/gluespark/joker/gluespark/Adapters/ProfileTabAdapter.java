package com.gluespark.joker.gluespark.Adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gluespark.joker.gluespark.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileTabAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private final List<Integer> mFragmentIconList = new ArrayList<>();
    private Context context;
   public ProfileTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title, int tabIcon) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        mFragmentIconList.add(tabIcon);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//return mFragmentTitleList.get(position);
        return null;
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_tab_custom_look, null);
        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(mFragmentTitleList.get(position));
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));
        return view;
    }
    public View getSelectedTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.profile_tab_custom_look, null);
        TextView tabTextView = view.findViewById(R.id.tabTextView);
        tabTextView.setText(mFragmentTitleList.get(position));
        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow_400));
        ImageView tabImageView = view.findViewById(R.id.tabImageView);
        tabImageView.setImageResource(mFragmentIconList.get(position));
        tabImageView.setColorFilter(ContextCompat.getColor(context, R.color.yellow_400), PorterDuff.Mode.SRC_ATOP);
        return view;
    }
} 