package com.example.valentina.smartestudiantes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Ingresar (View view){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
