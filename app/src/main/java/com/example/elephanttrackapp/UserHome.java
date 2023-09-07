package com.example.elephanttrackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        SharedPreferences sharedPreferences=getSharedPreferences("share_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.Logout);
        CardView location=findViewById(R.id.Summary);
        CardView eleDe=findViewById(R.id.ElephantDetails);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(UserHome.this,Login.class));
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHome.this,LocationDetails.class));
            }
        });

        eleDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserHome.this,ElephantDetails.class));
            }
        });



    }
}