package com.brainbox.school.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.brainbox.school.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by adityaagrawal on 11/02/16.
 */
public class EmailVerificationPendingActivity extends AppCompatActivity{
    @Bind(R.id.gifSuccess)
    GifImageView gifSuccess;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification_pending);
        ButterKnife.bind(this);
        try {
            GifDrawable gifFromAssets = new GifDrawable(getAssets(), "success.gif");
            gifSuccess.setImageDrawable(gifFromAssets);
        }catch (Exception e){
            gifSuccess.setVisibility(View.GONE);
            e.printStackTrace();
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
    }
}
