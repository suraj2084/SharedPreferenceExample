package com.example.android.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    AppCompatButton logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        logout=findViewById(R.id.Logout);
        SharedPreferences pref=getApplication().getSharedPreferences("MyPref",MODE_PRIVATE);

        String email=pref.getString("Email","Defalut").toString();
        String password=pref.getString("Password","Defalut").toString();
        Toast.makeText(getApplicationContext(), "Email: "+email+"\n"+"Password: "+password, Toast.LENGTH_LONG).show();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref=getApplication().getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putBoolean("flag",false);
                editor.putString("Email","");
                editor.putString("Password","");
                editor.commit();
                Intent iHome=new Intent(getApplication(),LoginActivity.class);
                startActivity(iHome);
            }
        });
    }
}