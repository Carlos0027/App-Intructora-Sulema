package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class Elecciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_elecciones);

    }
    public void irMenuApp(View view) {

        Intent siguiente = new Intent ( Elecciones.this, MenuApp.class);
        startActivity(siguiente);
    }

    public void irJuegos(View view) {

        Intent siguiente = new Intent ( Elecciones.this, Juegos.class);
        startActivity(siguiente);
    }
}