package com.example.business_times.config;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public SharedPreferencesHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences("User", MODE_PRIVATE);
        this.editor = sharedPreferences.edit(); }

    public String getPreferences(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void savePreferences(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void deletePreference(){
        editor.clear();
        editor.apply();
    }
}
