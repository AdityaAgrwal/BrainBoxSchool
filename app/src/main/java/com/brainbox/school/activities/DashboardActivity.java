package com.brainbox.school.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.brainbox.school.R;
import com.brainbox.school.dto.SchoolDTO;
import com.brainbox.school.dto.SessionDTO;
import com.brainbox.school.ui.Dialog;
import com.brainbox.school.util.BrainBox;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;
    // private GaussianBlur gaussianBlur;
    private MenuItem previousMenuItem;
    private TextView txtSchoolName , txtAdminName;
    private SchoolDTO schoolDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        schoolDTO = BrainBox.getSchoolDTO(this);
        setSupportActionBar(toolbar);

        final View headerView = navigationView.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this , ProfileUpdateActivity.class);
                startActivity(intent);

            }
        });

        txtSchoolName = (TextView) headerView.findViewById(R.id.txtSchoolName);
        txtAdminName = (TextView) headerView.findViewById(R.id.txtAdminName);

        txtAdminName.setText(schoolDTO.getAdmin());
        if(null != schoolDTO.getBranch())
            txtSchoolName.setText(schoolDTO.getName() + "  " + schoolDTO.getBranch());
        else
            txtSchoolName.setText(schoolDTO.getName());
       /* gaussianBlur = new GaussianBlur();
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        AndroidImage androidImage = new AndroidImage(icon);
        androidImage = gaussianBlur.process(androidImage);


        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), androidImage.getImage());

        headerView.setBackgroundDrawable(bitmapDrawable);
        ((ImageView)headerView.findViewById(R.id.profile_image)).setImageBitmap(icon);
*/

       /* Picasso.with(this).load("http://dl.skylearning.in/eRepository/Profile/DL_Org/Banner_Org_9.png").transform(new BlurTransformation(this)).into(new Target() {

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Log.d("TAG", "LOADED");
                headerView.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }
        });*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (previousMenuItem != null)
                    previousMenuItem.setChecked(false);

                menuItem.setCheckable(true);
                menuItem.setChecked(true);

                previousMenuItem = menuItem;

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.dashboard:
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        navigationView.getMenu().getItem(0).setChecked(true);
        /*ContentFragment fragment = new ContentFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();*/

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(Gravity.LEFT);
            return;
        }
        super.onBackPressed();
    }
}