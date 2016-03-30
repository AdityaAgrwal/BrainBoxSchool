package com.brainbox.school.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.brainbox.school.R;
import com.brainbox.school.adapter.AppInfoSlidingImageAdapter;
import com.brainbox.school.ui.button.ButtonPlus;
import com.flyco.pageindicator.indicator.FlycoPageIndicaor;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adityaagrawal on 09/02/16.
 */
public class AppInfoActivity extends AppCompatActivity{
    @Bind(R.id.btnLogin)
    ButtonPlus btnLogin;
    @Bind(R.id.btnSignUp)
    ButtonPlus btnSignUp;
    @Bind(R.id.indicator)
    FlycoPageIndicaor indicaor;
    @Bind(R.id.pager)
    ViewPager pager;

    @OnClick(R.id.btnLogin) void login(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btnSignUp) void signUp(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_app_info);

        populate();
    }

    private void populate(){
        ButterKnife.bind(this);


        AppInfoSlidingImageAdapter appInfoSlidingImageAdapter = new AppInfoSlidingImageAdapter(this);
        pager.setAdapter(appInfoSlidingImageAdapter);
        indicaor.setViewPager(pager);

    }
}
