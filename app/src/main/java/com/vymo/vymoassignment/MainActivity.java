package com.vymo.vymoassignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText owner;
    EditText repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#000000"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        init();
    }

    private void init() {
        owner=(EditText) findViewById(R.id.owner_et);
         repo=(EditText) findViewById(R.id.repo_et);
        Button submit=(Button) findViewById(R.id.submit_btn);
        final SharedPreferences splogin = getSharedPreferences("Details", 0);
        final SharedPreferences.Editor editor=splogin.edit();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidateCheck()) {
                    editor.putString("Owner", owner.getText().toString());
                    editor.putString("Repo", repo.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, LogsActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
    private boolean isValidateCheck() {
        if (owner.getText().toString() == null || owner.getText().toString().trim().length() == 0) {
            owner.setError(getResources().getString(R.string.empty_field_message));
            return false;
        }
        if (repo.getText().toString() == null || repo.getText().toString().trim().length() <= 0) {
            repo.setError(getResources().getString(R.string.empty_field_message));
            return false;
        }
        return true;
    }

}