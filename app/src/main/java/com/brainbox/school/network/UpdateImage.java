package com.brainbox.school.network;

import android.content.Context;
import android.content.Intent;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
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
import com.brainbox.school.ui.Dialog;
import com.brainbox.school.ui.GetProgressBar;
import com.brainbox.school.ui.SnackBar;
import com.brainbox.school.util.BaseVolleyRequest;
import com.brainbox.school.util.BrainBox;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smpx-imac1 on 01/04/16.
 */
public class UpdateImage implements NetworkConstnats {
    private MaterialDialog.Builder builder;
    private MaterialDialog dialog;
    String mimeType;
    DataOutputStream dos = null;
    String lineEnd = "\r\n";
    String boundary = "apiclient-" + System.currentTimeMillis();
    String twoHyphens = "--";
    int bytesRead, bytesAvailable, bufferSize;
    byte[] buffer;
    int maxBufferSize = 1024 * 1024;

    public void run(final Context context,final byte[] bitmapData) throws  Exception{

        HeaderDTO headerDTO = BrainBox.getHeaderDTO(context);
        builder = GetProgressBar.get(context);
        String url = UPDATE_IMAGE_URL;
        url = url.replaceFirst("CONTAINER", "logo");
        url = url.replaceFirst("SCHOOLID" , headerDTO.getId());
        Log.d("URL", url);
        builder.content("Loading...");
        dialog = builder.show();


        JSONObject jsonObject = new JSONObject();
     //   String encoded = Base64.encodeToString(bitmapData, Base64.DEFAULT);
       // jsonObject.put("file" , encoded);

        final Gson gson = new Gson();

        boundary =  BrainBox.getBoundary();
        mimeType = "multipart/form-data;boundary=" + boundary;

        BaseVolleyRequest baseVolleyRequest = new BaseVolleyRequest(1, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                dialog.dismiss();
                Log.d("lod", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
                Log.d("lod", error.toString());
                error.printStackTrace();
            }
        }) {
            @Override
            public String getBodyContentType() {
                return mimeType;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(bos);
                try {
                    dos.writeBytes("--" + boundary + "\n");
                //    dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + "ic_action_file_attachment_light.png" + "\"" + lineEnd);
                    dos.writeBytes(lineEnd);
                    ByteArrayInputStream fileInputStream = new ByteArrayInputStream(bitmapData);
                    int bytesAvailable = fileInputStream.available();

                    int bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    buffer = new byte[bufferSize];

                    // read file and write it into form...
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                    while (bytesRead > 0) {
                        dos.write(buffer, 0, bufferSize);
                        bytesAvailable = fileInputStream.available();
                        bufferSize = Math.min(bytesAvailable, maxBufferSize);
                        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                    }

                    // send multipart form data necesssary after file data...
                    dos.writeBytes(lineEnd);
                    dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                    return bos.toByteArray();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bitmapData;
            }
        };

        AppController.getInstance().addToRequestQueue(baseVolleyRequest);


       /* JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                dialog.dismiss();
                try {
                    Dialog.showSimpleDialog(context , response.toString());
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
                    Log.e("log", error.toString());
                    error.printStackTrace();
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
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  header = new HashMap<>();
                header.put("Content-Type", "application/octet-stream ");
                return header;
            }
        };

        AppController.getInstance().addToRequestQueue(jsonObjReq, AppController.JSON_OBJECT_REQUEST);
*/
    }
}
