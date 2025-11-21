package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;
import com.carlos.myappcarlos.model.ConexionBd;

public class Register extends AppCompatActivity {


    ConexionBd conexionBd;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        conexionBd = new ConexionBd(Register.this);
        db = conexionBd.getWritableDatabase();

        Toast.makeText(this,"db Creada", Toast.LENGTH_SHORT).show();

    }

    public void irLogin(View view) {

        Intent siguiente = new Intent(Register.this, Login.class);
        startActivity(siguiente);
    }
}