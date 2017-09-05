package com.naitiks.sharedpreferences.Kotlin

import android.content.SharedPreferences

/***
 * Created by Naitik on 9/5/2017.
 * SharedPreferenceHelperKt class is useful to perform local storage operation with shared preferences.
 */


class SharedPreferenceHelperKt(userPref: SharedPreferences) {
    private var sharedPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        this.sharedPreferences = userPref
    }

    private fun getEditor(): SharedPreferences.Editor {
        if (this.editor == null) editor = sharedPreferences!!.edit()
        return this.editor!!
    }

    /***
     *
     * @param key - Key to identify value
     * @param value - value of key
     */
    fun setSharedPrefString(key: String, value: String) {
        val editor = getEditor()
        editor.putString(key, value)
        editor.commit()
    }

    /***
     *
     * @param key Key to find Value
     * @return String containing value of the shared preference if found.
     */
    fun getSharedPrefString(key: String): String? {
        return if (this.sharedPreferences!!.contains(key)) {
            sharedPreferences!!.getString(key, null)
        } else {
            null
        }
    }
}
