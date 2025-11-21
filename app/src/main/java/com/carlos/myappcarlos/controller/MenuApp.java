package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class MenuApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_app);

    }

    public void irNumeros(View view) {

        Intent siguiente = new Intent ( MenuApp.this, Numeros.class);
        startActivity(siguiente);

    }
    public void irAnimales(View view) {

        Intent siguiente = new Intent ( MenuApp.this, Animales.class);
        startActivity(siguiente);

    }
    public void irColores(View view) {

        Intent siguiente = new Intent ( MenuApp.this, Colores.class);
        startActivity(siguiente);

    }
    public void irFrutas(View view) {

        Intent siguiente = new Intent ( MenuApp.this, Frutas.class);
        startActivity(siguiente);

    }
}