package com.brainbox.school.ui;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by smpx-imac1 on 28/03/16.
 */
public class Dialog {
    public static void showSimpleDialog(Context context, String message) {
        new MaterialDialog.Builder(context)
                .content(message)
                .positiveText("OK")
                .show();
    }
}
