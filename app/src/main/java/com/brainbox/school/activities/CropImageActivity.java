package com.brainbox.school.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.brainbox.school.R;
import com.theartofdev.edmodo.cropper.CropImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by smpx-imac1 on 31/03/16.
 */
public class CropImageActivity extends AppCompatActivity {

    @Bind(R.id.cropImageView)
    CropImageView cropImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_image);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        cropImageView.setImageBitmap(bitmap);

        Log.d("LOG" , cropImageView.getWidth() + "   " + cropImageView.getHeight());

        Bitmap cropped = cropImageView.getCroppedImage(200, 200);
     //   cropImageView.getCroppedImageAsync(CropImageView.CropShape.RECTANGLE, 400, 400);

    }
}
