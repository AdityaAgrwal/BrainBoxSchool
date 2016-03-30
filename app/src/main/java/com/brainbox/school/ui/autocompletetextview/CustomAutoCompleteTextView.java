package com.brainbox.school.ui.autocompletetextview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * Created by Admin-PC on 2/23/2016.
 */
public class CustomAutoCompleteTextView extends AutoCompleteTextView
{


	private Context context;
	private AttributeSet attrs;
	private int defStyle;

	public CustomAutoCompleteTextView(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		this.attrs = attrs;
		init();
	}

	public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		this.attrs = attrs;
		this.defStyle = defStyle;
		init();
	}

	private void init() {
		Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Whitney-Book-Bas.otf");
		this.setTypeface(font);
	}

	@Override
	public void setTypeface(Typeface tf, int style) {
		tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Whitney-Book-Bas.otf");
		super.setTypeface(tf, style);
	}

	@Override
	public void setTypeface(Typeface tf) {
		tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Whitney-Book-Bas.otf");
		super.setTypeface(tf);
	}
}