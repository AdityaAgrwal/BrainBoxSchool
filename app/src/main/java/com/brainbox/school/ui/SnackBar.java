package com.brainbox.school.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.brainbox.school.R;
import com.brainbox.school.dto.MessageCustomDialogDTO;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
import com.nispok.snackbar.enums.SnackbarType;
import com.nispok.snackbar.listeners.ActionClickListener;

/**
 * Created by adityaagrawal on 06/01/16.
 */
public class SnackBar {

    public static void showSimple(Context context, String message){
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/LatoLatin-Regular.ttf");

        Snackbar snackbar = Snackbar.with(context)
                .text(message)
                .textColor(Color.parseColor("#ffffffff"))
                .color(Color.parseColor("#fff18080"))
                .textTypeface(tf)
                .type(SnackbarType.MULTI_LINE)
                .actionLabel(context.getResources().getString(R.string.ok))
                .actionColor(Color.parseColor("#ffffffff"))
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                });

        snackbar.setPadding(5, 5, 5, 5);

        SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    public static void show(Context context, MessageCustomDialogDTO messageCustomDialogDTO) {


        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/LatoLatin-Regular.ttf");

        Snackbar snackbar = Snackbar.with(context)
                .text(messageCustomDialogDTO.getMessage())
                .textColor(Color.parseColor("#ffffffff"))
                .color(Color.parseColor("#fff18080"))
                .textTypeface(tf)
                .type(SnackbarType.MULTI_LINE)
                .actionLabel(context.getResources().getString(R.string.ok))
                .actionColor(Color.parseColor("#ffffffff"))
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                });

        snackbar.setPadding(5, 5, 5, 5);

        SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    public static void success(Context context, MessageCustomDialogDTO messageCustomDialogDTO) {


        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/LatoLatin-Regular.ttf");

        Snackbar snackbar =  Snackbar.with(context)
                .text(messageCustomDialogDTO.getMessage())
                .textColor(Color.parseColor("#ffffffff"))
                .color(Color.parseColor("#ff0bc681"))
                .textTypeface(tf)
                .type(SnackbarType.MULTI_LINE)
                .actionLabel(messageCustomDialogDTO.getButton())
                .actionColor(Color.parseColor("#ffffffff"))
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                });

        snackbar.setPadding(5, 5, 5, 5);

        SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    public static void success(Context context, String message) {


        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/LatoLatin-Regular.ttf");

        Snackbar snackbar =  Snackbar.with(context)
                .text(message)
                .textColor(Color.parseColor("#ffffffff"))
                .color(Color.parseColor("#ff0bc681"))
                .textTypeface(tf)
                .type(SnackbarType.MULTI_LINE)
                .actionLabel(context.getString(R.string.ok))
                .actionColor(Color.parseColor("#ffffffff"))
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                });

        snackbar.setPadding(5, 5, 5, 5);

        SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

    public static void noInternet(Context context) {

        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/LatoLatin-Regular.ttf");

        Snackbar snackbar =  Snackbar.with(context)
                .text(context.getResources().getString(R.string.no_internet))
                .textColor(Color.parseColor("#ffffffff"))
                .color(Color.parseColor("#fff18080"))
                .textTypeface(tf)
                .type(SnackbarType.MULTI_LINE)
                .actionLabel(context.getResources().getString(R.string.ok))
                .actionColor(Color.parseColor("#ffffffff"))
                .actionListener(new ActionClickListener() {
                    @Override
                    public void onActionClicked(Snackbar snackbar) {

                    }
                });

        snackbar.setPadding(5, 5, 5, 5);

        SnackbarManager.show(snackbar.duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }
}
