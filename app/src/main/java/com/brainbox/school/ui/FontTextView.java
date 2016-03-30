package com.brainbox.school.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by adityaagrawal on 18/02/16.
 */
public class FontTextView extends TextView
{

	Context context;
	String ttfName;

	String TAG = getClass().getName();

	public FontTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;

		for (int i = 0; i < attrs.getAttributeCount(); i++) {
			Log.i(TAG, attrs.getAttributeName(i));
            /*
             * Read value of custom attributes
             */

			this.ttfName = attrs.getAttributeValue("http://schemas.android.com/apk/res/com.brainbox", "ttf_name");
			init();
		}

	}

	private void init() {
		Typeface font = Typeface.createFromAsset(context.getAssets(), ttfName);
		setTypeface(font);
	}

	@Override
	public void setTypeface(Typeface tf) {

		super.setTypeface(tf);
	}

}