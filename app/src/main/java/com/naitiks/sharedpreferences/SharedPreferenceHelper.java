package com.naitiks.sharedpreferences;

import android.content.SharedPreferences;

/***
 * Created by Naitik on 9/5/2017.
 * SharedPreferenceHelperKt class is useful to perform local storage operation with shared preferences.
 */


public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor = null;
    public SharedPreferenceHelper(SharedPreferences userPref){
        this.sharedPreferences = userPref;
    }

    private SharedPreferences.Editor getEditor(){
        if(this.editor == null) editor = sharedPreferences.edit();
        return this.editor;
    }

    /***
     *
     * @param key - Key to identify value
     * @param value - value of key
     */
    public void setSharedPrefString(String key, String value){
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.commit();
    }

    /***
     *
     * @param key Key to find Value
     * @return String containing value of the shared preference if found.
     */
    public String getSharedPrefString(String key){
        if(this.sharedPreferences.contains(key)){
            return this.sharedPreferences.getString(key, null);
        }else{
            return null;
        }
    }
}
