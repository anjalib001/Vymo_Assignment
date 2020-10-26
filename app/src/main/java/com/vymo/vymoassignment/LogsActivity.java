package com.vymo.vymoassignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LogsActivity extends AppCompatActivity {
    RecyclerView listView;
    ArrayList<singleRow> list=new ArrayList<singleRow>();
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logs);
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#000000"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        listView=findViewById(R.id.list_users);
        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListViewAdapter(LogsActivity.this,list);
        listView.setAdapter(adapter);
        init();
    }
    private void init(){
        String result;
        SharedPreferences splogin = getSharedPreferences("Details", 0);
        String owner=splogin.getString("Owner","");
        String repo=splogin.getString("Repo","");
        String myUrlGET = "https://api.github.com/repos/"+owner+"/"+repo+"/issues?state=open";
        HttpGetRequest getRequest = new HttpGetRequest();
        try {
            result = getRequest.execute(myUrlGET).get();
            JSONArray array=new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonobject = array.getJSONObject(i);

                    singleRow singlerow = new singleRow(jsonobject.getString("title"), jsonobject.getString("number"), jsonobject.getString("state"), jsonobject.getJSONObject("pull_request").getString("patch_url"));
                    list.add(singlerow);
            }
            adapter.notifyDataSetChanged();
               // Toast.makeText(this, jsonobject.getString("title"), Toast.LENGTH_LONG).show();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}