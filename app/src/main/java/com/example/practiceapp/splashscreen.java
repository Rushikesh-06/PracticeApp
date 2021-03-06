package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class splashscreen extends AppCompatActivity {
    SharedPreferences preferences;
    TextView companyname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        preferences = getSharedPreferences("MyApp", MODE_PRIVATE);
        companyname= findViewById(R.id.companyname);


        Typeface font = Typeface.createFromAsset(getAssets(),"Creepster-Regular.ttf");
        companyname.setTypeface(font);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                boolean isloggedIn = preferences.getBoolean("Is_login", false);
                if (isloggedIn) {
                    startActivity(new Intent(splashscreen.this, HomeMain.class));
                    finish();
                } else {
                    Intent Loginscrn = new Intent(splashscreen.this, loginactivity.class);
                    startActivity(Loginscrn);
                    finish();
                }
            }
        }, 2000);


    }
}