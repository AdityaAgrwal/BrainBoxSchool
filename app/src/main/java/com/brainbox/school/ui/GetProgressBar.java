package com.brainbox.school.ui;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by smpx-imac1 on 28/03/16.
 */
public class GetProgressBar {
    public static MaterialDialog.Builder get(Context context) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .content("Please Wait").cancelable(false).progress(true, 0);
        return builder;
    }
}
