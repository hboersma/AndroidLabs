package com.harvb.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;

import static android.R.attr.defaultValue;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.harvb.androidlabs.R.string.Login;

public class LoginName extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginName";

    public static final String SETTINGS = "com.harvb.AndroidLabs.settings";
    public static final String EMAIL_SETTING = "com.harvb.AndroidLabs.email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void onResume() {

        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {

        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

        final EditText email = (EditText)findViewById(R.id.editText);

        final Context context = this;

        SharedPreferences sharedPref = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        String strEmail = sharedPref.getString(EMAIL_SETTING, "email@example.com");
        email.setText(strEmail);

        Button login = (Button)findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                String strEmail = email.getText().toString();
                editor.putString(EMAIL_SETTING, strEmail);
                editor.commit();

                Intent intent = new Intent(LoginName.this, StartActivity.class);
                startActivity(intent);
            }
        });


    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");

    }

    protected void onDestroy() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
