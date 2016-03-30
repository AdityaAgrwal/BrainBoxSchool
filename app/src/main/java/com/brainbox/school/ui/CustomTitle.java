package com.brainbox.school.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;

/**
 * Created by adityaagrawal on 13/02/16.
 */
public class CustomTitle {
    public static SpannableString getTitle(Context context, String title){
        SpannableString s = new SpannableString(title);
        s.setSpan(new com.brainbox.school.ui.TypefaceSpan(context, "Whitney-Semibold-Bas.otf"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    public static SpannableString getPlainTitle(Context context, String title){
        SpannableString s = new SpannableString(title);
        s.setSpan(new com.brainbox.school.ui.TypefaceSpan(context, "Whitney-Book-Bas.otf"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }
}
