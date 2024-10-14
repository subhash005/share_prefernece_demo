package com.example.shared_perfernece;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag",false);
                Intent iMext;
                if(check){
                    //for True (User is Logged In)
                    iMext=new Intent(MainActivity.this, home.class);
                }else {
                    //for Flase (User is first opening  or if logout)
                    iMext=new Intent(MainActivity.this, login.class);
                }
                startActivity(iMext);

            }
        }, 4000);
    }
}