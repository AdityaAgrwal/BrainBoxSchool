package com.brainbox.school.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.brainbox.school.R;
import com.brainbox.school.dto.AddressDTO;
import com.brainbox.school.dto.MessageCustomDialogDTO;
import com.brainbox.school.dto.RegisterDTO;
import com.brainbox.school.network.Register;
import com.brainbox.school.security.Validate;
import com.brainbox.school.ui.CustomTitle;
import com.brainbox.school.ui.Dialog;
import com.brainbox.school.ui.SnackBar;
import com.brainbox.school.ui.button.ButtonPlus;
import com.brainbox.school.ui.edittext.CustomEditText;
import com.brainbox.school.util.NetworkCheck;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adityaagrawal on 10/02/16.
 */
public class GetAddressActivity extends AppCompatActivity {
    private RegisterDTO registerDTO;
    @Bind(R.id.etCity)
    CustomEditText etCity;

    @Bind(R.id.etStreet)
    CustomEditText etStreet;

    @Bind(R.id.etState)
    CustomEditText etState;

    @Bind(R.id.etPincode)
    CustomEditText etPincode;

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
        setContentView(R.layout.activity_get_address);

        registerDTO = new Gson().fromJson(getIntent().getExtras().getString("registerDTO"), RegisterDTO.class);
        populate();
    }


    private void populate() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // txtTitle.setText();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnSignUp.setBackgroundResource(R.drawable.abc_alpha_btn_background_ripple);
        }

        getSupportActionBar().setTitle(CustomTitle.getTitle(this, getResources().getString(R.string.address)));

        toolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void attemptSignUp() {

        etCity.setError(null);
        etState.setError(null);
        etStreet.setError(null);
        etPincode.setError(null);

        String city = etCity.getText().toString();
        String state = etState.getText().toString();
        String street = etStreet.getText().toString();
        String pincode = etPincode.getText().toString();

        if (!Validate.isStreetValid(street)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_street));
            SnackBar.show(this, messageCustomDialogDTO);

        } else if (!Validate.isCityValid(city)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_city));
            SnackBar.show(this, messageCustomDialogDTO);

        } else if (!Validate.isStateValid(state)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_state));
            SnackBar.show(this, messageCustomDialogDTO);
        } else if (!Validate.isPincodeValid(pincode)) {
            MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
            messageCustomDialogDTO.setMessage(getString(R.string.error_invalid_pincode));
            SnackBar.show(this, messageCustomDialogDTO);
        }

         else {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(street);
            addressDTO.setCity(city);
            addressDTO.setState(state);
            addressDTO.setPincode(pincode);
            registerDTO.setAddress(addressDTO);

            if(!NetworkCheck.isNetworkAvailable(this)){
                MessageCustomDialogDTO messageCustomDialogDTO = new MessageCustomDialogDTO();
                messageCustomDialogDTO.setMessage(getString(R.string.no_internet));
                SnackBar.show(this, messageCustomDialogDTO);
                return;
            }

            try{
                Register register = new Register();
                register.run(this, registerDTO);
            }catch (Exception e){
                Dialog.showSimpleDialog(this, e.toString());
            }
        }
    }
}
