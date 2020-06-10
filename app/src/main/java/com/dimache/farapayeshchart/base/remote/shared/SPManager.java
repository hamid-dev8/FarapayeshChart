package com.dimache.farapayeshchart.base.remote.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.dimache.farapayeshchart.App;
import com.dimache.farapayeshchart.BuildConfig;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by hamidreza on 3/12/2017.
 */

public class SPManager {

    private static SPManager ourInstance;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String uniqueID = null;

    public static SPManager getInstance() {
        if (ourInstance == null)
            ourInstance = new SPManager();
        return ourInstance;
    }



    @Inject
    public SPManager() {
        sharedPreferences = App.getAppContext().getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setToken(String token){
        editor.putString("token",token);
        editor.apply();
    }

    public void setUserName(String uname)
    {
        editor.putString("user_name",uname);
        editor.apply();
    }

    public void setUserActive(boolean b)
    {
        editor.putBoolean("user_active", b);
        editor.apply();
    }

    public void setUserID(String id)
    {
        editor.putString("user_id", id);
        editor.apply();
    }

    public void setVip(boolean vip){
        editor.putBoolean("vip",vip);
        editor.apply();
    }

    public boolean getVip()
    {
        return sharedPreferences.getBoolean("vip",false);
    }

    public String getUserID()
    {
        return sharedPreferences.getString("user_id", "3");
    }


    public String getToken()
    {
        return "Bearer  " + sharedPreferences.getString("token", "");
        //return "Bearer  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIsImlzcyI6Imh0dHA6Ly9oYXJhamluby5pc2F0ZWxjby5jb20vYXBpL3YxL3VzZXIvcmVnaXN0ZXIvdmVyaWZ5IiwiaWF0IjoxNTI0MDQ3OTY0LCJleHAiOjUxMjQwNDc5NjQsIm5iZiI6MTUyNDA0Nzk2NCwianRpIjoiRmhrVVFMZlVyc09oZFNacSJ9.I5Q8Stvfv_466v7I_qK81Uj_XncnyxFcZhLNyO66730";
    }

    public String getSocketToken()
    {
        return sharedPreferences.getString("token", "");
    }

    public String getUserName()
    {
        return sharedPreferences.getString("user_name", "");
    }

    public boolean getUserActive() {
        return sharedPreferences.getBoolean("user_active", false);
    }

    public synchronized String getUuid() {
            uniqueID = sharedPreferences.getString("UUID", null);
            if (uniqueID == null) {
                uniqueID = UUID.randomUUID().toString();
                editor.putString("UUID", uniqueID);
                editor.commit();
            }
            return uniqueID;
    }


    public boolean isFirstMain()
    {
        return sharedPreferences.getBoolean("first_main", true);
    }

    public boolean isFirstAuction()
    {
        return sharedPreferences.getBoolean("first_auction", true);
    }

    public void setFirstMain(boolean b)
    {
        editor.putBoolean("first_main", b);
        editor.apply();
    }

    public void setFirstAuction(boolean b)
    {
        editor.putBoolean("first_auction", b);
        editor.apply();
    }

    public void setEightSeconds(String seconds)
    {
        editor.putString("eightSeconds",seconds);
        editor.apply();
    }
    public String getEightSeconds()
    {
        return sharedPreferences.getString("eightSeconds","00:00:00");
    }

    public void introShowed(boolean b)
    {
        editor.putBoolean("intro",b);
        editor.apply();
    }
    public boolean isIntroShowed()
    {
        return sharedPreferences.getBoolean("intro",false);
    }





}
