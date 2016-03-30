package com.brainbox.school.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.brainbox.school.dto.SessionDTO;
import com.brainbox.school.global.AppConfig;
import com.google.gson.Gson;

/**
 * Created by smpx-imac1 on 30/03/16.
 */
public class BrainBox {
    public static SharedPreferences getSharedPreferences(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences;
    }


    public static SharedPreferences.Editor getSharedEditor(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.edit();
    }

    public static Boolean isLogin(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        boolean isLogin = sharedPreferences.getBoolean(AppConfig.ISLOGIN, false);
        return isLogin;
    }

    public static void setSessionDTO(Context context, SessionDTO sessionDTO){
        SharedPreferences.Editor editor = getSharedEditor(context);
        Gson gson = new Gson();
        editor.putString(AppConfig.SESSION, gson.toJson(sessionDTO));
        editor.commit();
    }


    public static SessionDTO getSessionDTO(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        SessionDTO sessionDTO = gson.fromJson(sharedPreferences.getString(AppConfig.SESSION, null), SessionDTO.class);
        return sessionDTO;
    }

    public static void login(Context context){
        SharedPreferences.Editor editor = getSharedEditor(context);
        editor.putBoolean(AppConfig.ISLOGIN, true);
        editor.commit();
    }


    public static void logout(Context context){
        SharedPreferences.Editor editor = getSharedEditor(context);
        editor.putBoolean(AppConfig.ISLOGIN, false);
        editor.commit();
    }

    /*public static void setStudentDTO(Context context, Schoo studentDTO){
        SharedPreferences.Editor editor = getSharedEditor(context);

        Gson gson = new Gson();
        SessionDTO sessionDTO = getSessionDTO(context);
        sessionDTO.setStudentDTO(studentDTO);

        editor.putString("session", gson.toJson(sessionDTO));
        editor.commit();
    }


    public static StudentDTO getStudentDTO(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        SessionDTO sessionDTO = gson.fromJson(sharedPreferences.getString("session", null), SessionDTO.class);
        return sessionDTO.getStudentDTO();
    }

   */
}
