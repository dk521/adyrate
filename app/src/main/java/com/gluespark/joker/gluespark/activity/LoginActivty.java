package com.gluespark.joker.gluespark.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gluespark.joker.gluespark.Fragments.OTPFragment;
import com.gluespark.joker.gluespark.R;

public class LoginActivty extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private  FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);
        mFragmentManager=getSupportFragmentManager();

        Button loginButton=findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFragmentTransaction=mFragmentManager.beginTransaction();
               mFragmentTransaction.add(R.id.fragment_login_container,new OTPFragment());
               mFragmentTransaction.commit();
            }
        });
    }
}
