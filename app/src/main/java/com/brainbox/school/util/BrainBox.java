package com.brainbox.school.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.brainbox.school.dto.HeaderDTO;
import com.brainbox.school.dto.SchoolDTO;
import com.brainbox.school.dto.SessionDTO;
import com.brainbox.school.global.AppConfig;
import com.google.gson.Gson;

import java.util.Random;

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

    public static SchoolDTO getSchoolDTO(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        SessionDTO sessionDTO = gson.fromJson(sharedPreferences.getString("session", null), SessionDTO.class);
        return sessionDTO.getSchoolDTO();
    }

    public static HeaderDTO getHeaderDTO(Context context){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        Gson gson = new Gson();
        SessionDTO sessionDTO = gson.fromJson(sharedPreferences.getString("session", null), SessionDTO.class);
        return sessionDTO.getHeaderDTO();
    }

    public static String getBoundary(){
        Random random = new Random();
        String tag = Long.toString(Math.abs(random.nextLong()), 36);
        return tag.substring(0, 8);
    }
    /*public static void setStudentDTO(Context context, Schoo studentDTO){
        SharedPreferences.Editor editor = getSharedEditor(context);

        Gson gson = new Gson();
        SessionDTO sessionDTO = getSessionDTO(context);
        sessionDTO.setStudentDTO(studentDTO);

        editor.putString("session", gson.toJson(sessionDTO));
        editor.commit();
    }




   */
}
