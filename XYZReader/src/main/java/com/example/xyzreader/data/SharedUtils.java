package com.example.xyzreader.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedUtils {

    public static String IS_FIRST_TIME_RUN = "IsFirstTimeRun";

    public static boolean isFirstTime(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(IS_FIRST_TIME_RUN,true);
    }

    public static void setFirstTimeRun(Context context,boolean setAsFirstRun){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mEditor = prefs.edit();
        mEditor.putBoolean(IS_FIRST_TIME_RUN,setAsFirstRun);
        mEditor.apply();
    }

    public static boolean isFirstTime(Context context, String className){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(IS_FIRST_TIME_RUN+className,true);
    }

    public static void setFirstTimeRun(Context context,String className,boolean setAsFirstRun){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mEditor = prefs.edit();
        mEditor.putBoolean(IS_FIRST_TIME_RUN+className,setAsFirstRun);
        mEditor.apply();
    }
}
