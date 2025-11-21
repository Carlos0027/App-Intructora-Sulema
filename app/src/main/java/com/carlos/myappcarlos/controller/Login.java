package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }

    public void irBienvenido(View view) {

        Intent siguiente = new Intent(Login.this, Bienvenido.class);
        startActivity(siguiente);
    }
    public void irRegister02(View view) {

        Intent siguiente = new Intent(Login.this, Register.class);
        startActivity(siguiente);
    }

}