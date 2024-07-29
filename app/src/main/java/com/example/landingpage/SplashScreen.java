package com.example.landingpage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
    LottieAnimationView lotties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler( ).postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent i= new Intent(SplashScreen.this, SignActivity.class);
            startActivity(i);
            }
        }, 5000);
    }
}