package com.example.grad_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.grad_1.R;

public class SplashScreen extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

    }



}


