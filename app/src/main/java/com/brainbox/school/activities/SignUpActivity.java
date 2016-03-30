package com.brainbox.school.activities;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;


import com.brainbox.school.R;
import com.brainbox.school.dto.MessageCustomDialogDTO;
import com.brainbox.school.dto.RegisterDTO;
import com.brainbox.school.security.Validate;
import com.brainbox.school.ui.CustomTitle;
import com.brainbox.school.ui.SnackBar;
import com.brainbox.school.ui.autocompletetextview.CustomAutoCompleteTextView;
import com.brainbox.school.ui.button.ButtonPlus;
import com.brainbox.school.ui.edittext.CustomEditText;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adityaagrawal on 10/02/16.
 */
public class SignUpActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    @Bind(R.id.etEmail)
    CustomAutoCompleteTextView autoCompleteTextViewEmail;

    @Bind(R.id.etMobile)
    CustomEditText etMobile;

    @Bind(R.id.etSchoolName)
    CustomEditText etSchoolName;

    @Bind(R.id.etSchoolBranch)
    CustomEditText etSchoolBranch;

    @Bind(R.id.etYourName)
    CustomEditText etYourName;

    @Bind(R.id.btnSignUp)
    ButtonPlus btnSignUp;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @OnClick(R.id.btnSignUp)
    void login() {
        attemptSignUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        populate();
    }

    private void populate() {
        ButterKnife.bind(this);
       // populateAutoComplete();
        setSupportActionBar(toolbar);

        // txtTitle.setText();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnSignUp.setBackgroundResource(R.drawable.abc_alpha_btn_background_ripple);
        }

        getSupportActionBar().setTitle(CustomTitle.getTitle(this, getResources().getString(R.string.sign_up)));

        toolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    public void attemptSignUp() {

        autoCompleteTextViewEmail.setError(null);
        etMobile.setError(null);
        etSchoolName.setError(null);

        String email = autoCompleteTextViewEmail.getText().toString();
        String mobile = etMobile.getText().toString();
        String schoolName = etSchoolName.getText().toString();
        String yourName = etYourName.getText().toString();
        String schoolBranch = etSchoolBranch.getText().toString();

        if (!Validate.isSchoolNameValid(schoolName)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_school));
            SnackBar.show(this, messageCustomDialogDTO);
        }else if(!Validate.isNameValid(yourName)){
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_name));
            SnackBar.show(this, messageCustomDialogDTO);
        }else if (!Validate.isValidEmailAddress(email)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_email));
            SnackBar.show(this, messageCustomDialogDTO);
        } else if (!Validate.isMobileValid(mobile)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_phone));
            SnackBar.show(this, messageCustomDialogDTO);
        } else {
            RegisterDTO registerDTO = new RegisterDTO();
            registerDTO.setEmail(email);
            registerDTO.setMobile(mobile);
            registerDTO.setName(schoolName);
            registerDTO.setBranch(schoolBranch);
            registerDTO.setAdmin(yourName);

            Gson gson = new Gson();
            Intent intent = new Intent(this, GetAddressActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("registerDTO", gson.toJson(registerDTO));
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,
                ContactsContract.Contacts.Data.MIMETYPE + " = ?", new String[]{ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE},
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<String>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {ContactsContract.CommonDataKinds.Email.ADDRESS, ContactsContract.CommonDataKinds.Email.IS_PRIMARY,};
        int ADDRESS = 0;
    }


    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, emailAddressCollection);
        autoCompleteTextViewEmail.setAdapter(adapter);
    }
}
