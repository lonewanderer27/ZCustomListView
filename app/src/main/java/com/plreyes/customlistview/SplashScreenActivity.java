package com.plreyes.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // Splash Screen
        Intent splashScreenIntent = new Intent(".MainActivity");

        Thread splashScreenThreadTimeout = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    startActivity(splashScreenIntent);
                    finish();
                }
            }
        };

        splashScreenThreadTimeout.start();
    }
}