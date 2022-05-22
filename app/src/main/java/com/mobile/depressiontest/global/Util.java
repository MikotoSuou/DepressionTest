package com.mobile.depressiontest.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.depressiontest.models.History;

import java.lang.reflect.Type;
import java.util.List;

public class Util {

    private static final String APP_PREF = "APP_PREF";
    private static final String HISTORY_KEY_ACCESS_TOKEN = "history_key_access_token";

    public static <T> void setObjectList(Context context, List<T> list) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = gson.toJson(list);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(HISTORY_KEY_ACCESS_TOKEN, json)
                    .apply();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<History> getHistoryList(Context context){
       try {
           List<History> arrayItems;
           SharedPreferences sharedPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE);
           String serializedObject = sharedPreferences.getString(HISTORY_KEY_ACCESS_TOKEN, null);
           if (serializedObject != null) {
               Gson gson = new Gson();
               Type type = new TypeToken<List<History>>(){}.getType();
               arrayItems = gson.fromJson(serializedObject, type);
               return arrayItems;
           }
           return null;

       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
    }
}
