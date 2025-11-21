package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


   public void irRegister(View view) {

       Intent siguiente = new Intent ( MainActivity.this, Register.class);
        startActivity(siguiente);
    }


}