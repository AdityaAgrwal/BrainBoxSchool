package com.brainbox.school.network;

import android.content.Context;
import android.content.Intent;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.brainbox.school.R;
import com.brainbox.school.activities.DashboardActivity;
import com.brainbox.school.constants.NetworkConstnats;
import com.brainbox.school.dto.ErrorDTO;
import com.brainbox.school.dto.HeaderDTO;
import com.brainbox.school.dto.LoginDTO;
import com.brainbox.school.dto.SchoolDTO;
import com.brainbox.school.dto.SessionDTO;
import com.brainbox.school.global.AppConfig;
import com.brainbox.school.global.AppController;
import com.brainbox.school.ui.GetProgressBar;
import com.brainbox.school.ui.SnackBar;
import com.brainbox.school.util.BrainBox;
import com.google.gson.Gson;

import org.json.JSONObject;


/**
 * Created by adityaagrawal on 10/02/16.
 */
public class Login implements NetworkConstnats {
    private MaterialDialog.Builder builder;
    private MaterialDialog dialog;

    public void run(final Context context, LoginDTO loginDTO) throws  Exception{
        builder = GetProgressBar.get(context);
        String url = LOGIN_URL;
        builder.content("Loading...");
        dialog = builder.show();
        final Gson gson = new Gson();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(gson.toJson(loginDTO)), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                dialog.dismiss();
                try {
                    response = response.getJSONObject("response");
                    response = response.getJSONObject("data");
                    String secret = response.getString("secret");
                    SchoolDTO schoolDTO = gson.fromJson(response.getJSONObject("school").toString(), SchoolDTO.class);
                    HeaderDTO headerDTO = new HeaderDTO();
                    headerDTO.setId(schoolDTO.getId());
                    headerDTO.setSecret(secret);
                    headerDTO.setScope(AppConfig.SCOPE);

                    SessionDTO sessionDTO = new SessionDTO();
                    sessionDTO.setHeaderDTO(headerDTO);
                    sessionDTO.setSchoolDTO(schoolDTO);

                    BrainBox.setSessionDTO(context, sessionDTO);
                    BrainBox.login(context);

                    Intent intent = new Intent(context, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);
                }catch (Exception e){
                    SnackBar.showSimple(context, e.toString());
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();

                if(error instanceof TimeoutError || error instanceof NoConnectionError || error instanceof NetworkError){
                    SnackBar.showSimple(context, context.getResources().getString(R.string.no_internet));
                    return;
                }

                try {
                    String errorString = new String(error.networkResponse.data);
                    JSONObject jsonObject = new JSONObject(errorString);
                    ErrorDTO errorDTO = gson.fromJson(jsonObject.getString("error"), ErrorDTO.class);
                    SnackBar.showSimple(context, errorDTO.getMessage());
                }catch (Exception e){
                    e.printStackTrace();
                    SnackBar.showSimple(context, e.getMessage());
                }

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjReq, AppController.JSON_OBJECT_REQUEST);

    }
}
