package com.example.learngeo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getSupportActionBar().hide();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isLogin();
            }
        }, 3000);

    }
    public void isLogin(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Login", 0);
        if (sharedPreferences.contains("UID")) {
            String uid = sharedPreferences.getString("UID", null);
            if (uid != null) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        else {
            startActivity(new Intent(getApplicationContext(), IntroScreen.class));
            finish();
        }
    }
}