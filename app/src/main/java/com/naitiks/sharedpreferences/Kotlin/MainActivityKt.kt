package com.naitiks.sharedpreferences.Kotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.naitiks.sharedpreferences.R

class MainActivityKt : AppCompatActivity() {
    private val SHARED_PREF_NAME = "MY_PREF"
    private val SHARED_PREF_MODE = Context.MODE_PRIVATE
    private val KEY_NAME = "NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helper = SharedPreferenceHelperKt(this@MainActivityKt.getSharedPreferences(SHARED_PREF_NAME, SHARED_PREF_MODE))

        val editText = findViewById(R.id.edit_txt) as EditText
        val putVal = findViewById(R.id.put_val) as Button
        val getVal = findViewById(R.id.get_val) as Button

        putVal.setOnClickListener {
            helper.setSharedPrefString(KEY_NAME, editText.text.toString())
            Toast.makeText(this@MainActivityKt, "Value Stored.", Toast.LENGTH_SHORT).show()
        }

        getVal.setOnClickListener { Toast.makeText(this@MainActivityKt, "Stored Value: " + helper.getSharedPrefString(KEY_NAME)!!, Toast.LENGTH_SHORT).show() }

    }

}
