package com.vymo.vymoassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    Handler mhandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mhandler.postDelayed(rn, 3000);
    }
    Runnable rn = new Runnable() {
        @Override
        public void run() {
         Intent intent=new Intent(SplashActivity.this, MainActivity.class);
         startActivity(intent);
        }
    };
}