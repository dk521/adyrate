package com.gluespark.joker.gluespark.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gluespark.joker.gluespark.R;
import com.gluespark.joker.gluespark.activity.MainActivity;

public class OTPFragment extends Fragment {
    private Button mVerify;
    private Context mContext;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localIntent=new Intent((AppCompatActivity)getActivity(),MainActivity.class);
                startActivity(localIntent);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext=container.getContext();
        if(container!=null){
            container.removeAllViews();
        }
        View localView=inflater.inflate(R.layout.login_otp_verification,container,false);
         mVerify=localView.findViewById(R.id.button_verify);

        return localView;
    }
}
