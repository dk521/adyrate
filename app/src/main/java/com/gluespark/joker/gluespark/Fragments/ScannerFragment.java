package com.gluespark.joker.gluespark.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gluespark.joker.gluespark.R;

public class ScannerFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View localView=inflater.inflate(R.layout.fragment_wallet,container,false);
        return localView;
    }
}
