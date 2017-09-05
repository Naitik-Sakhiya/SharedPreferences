package com.naitiks.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SHARED_PREF_NAME = "MY_PREF";
    private final int SHARED_PREF_MODE = MODE_PRIVATE;
    private final String KEY_NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferenceHelper helper =
                new SharedPreferenceHelper(MainActivity.this.getSharedPreferences(SHARED_PREF_NAME, SHARED_PREF_MODE));

        final EditText editText = (EditText) findViewById(R.id.edit_txt);
        Button putVal = (Button) findViewById(R.id.put_val);
        Button getVal = (Button) findViewById(R.id.get_val);

        putVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.setSharedPrefString(KEY_NAME ,editText.getText().toString());
                Toast.makeText(MainActivity.this, "Value Stored.", Toast.LENGTH_SHORT).show();
            }
        });

        getVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Stored Value: "+helper.getSharedPrefString(KEY_NAME), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
