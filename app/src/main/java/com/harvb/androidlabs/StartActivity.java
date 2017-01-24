package com.harvb.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    public final static int MESSAGE_REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button startButton = (Button)findViewById(R.id.button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent getResult = new Intent(getApplicationContext(), ListItemsActivity.class);

                startActivityForResult(getResult, MESSAGE_REQUEST_CODE);
            }
        });

    }


    protected void onActivityResult(int requestCode, int responseCode, Intent data) {

        if (requestCode == 5 )
        {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }

        if (responseCode == Activity.RESULT_OK )
        {
            String messagePassed = data.getStringExtra("Response");

            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(this , messagePassed, duration); //this is the ListActivity
            toast.show(); //display your message box
        }
    }


    protected void onResume() {

        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {

        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
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
