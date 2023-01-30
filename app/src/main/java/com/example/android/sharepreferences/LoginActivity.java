package com.example.android.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    AppCompatButton login;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPassword);
        login=findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit1=email.getText().toString();
                String edit2=password.getText().toString();
                SharedPreferences sharedPreferences=getApplication().getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("flag",true);
                editor.putString("Email",edit1);
                editor.putString("Password",edit2);
                editor.apply();
                Intent iHome=new Intent(getApplication(),SecondActivity.class);
                startActivity(iHome);

            }
        });
    }
}