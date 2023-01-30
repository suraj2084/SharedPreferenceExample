package com.example.android.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getApplication().getSharedPreferences("MyPref",MODE_PRIVATE);
                Boolean check=sharedPreferences.getBoolean("flag",false);
                Intent iNext;
                if(check){
                    iNext=new Intent(getApplication(),SecondActivity.class);

                }else{
                     iNext=new Intent(getApplication(),LoginActivity.class);
                }
                startActivity(iNext);

            }
        },2000);

    }
}