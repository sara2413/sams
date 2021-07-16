package com.example.grad_1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.grad_1.R;
import com.example.grad_1.fragment.CameraFragment;
import com.example.grad_1.fragment.SignUp_Student2_Fragment;
import com.example.grad_1.fragment.SignUp_Student_Fragment;

public class MainActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    /*    Intent intent = getIntent();
        String acad = intent.getStringExtra("acad");


        Bundle bundle = new Bundle();
        bundle.putString("acad", "CameraFragment");

        // Set Fragmentclass Arguments
        CameraFragment fragobj = new CameraFragment();
        fragobj.setArguments(bundle);*/



        contextOfApplication = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this, SplashScreen.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGTH);

      /*  Intent intent = getIntent();
        String message = intent.getStringExtra("email");

*/

       // Bundle bundle = new Bundle();
      //  bundle.putString("email",message);


// Set Fragmentclass Arguments
      /*  SignUp_Student_Fragment fragobj = new SignUp_Student_Fragment();
        fragobj.setArguments(bundle);*/


    }




    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }





}

