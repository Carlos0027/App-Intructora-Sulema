package com.carlos.myappcarlos.controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class MostrarDatos extends AppCompatActivity {

    private TextView tvNombre, tvApodo, tvEdad, tvColegio, tvGenero, tvPuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvNombre  = findViewById(R.id.tvNombre);
        tvApodo   = findViewById(R.id.tvApodo);
        tvEdad    = findViewById(R.id.tvEdad);
        tvColegio = findViewById(R.id.tvColegio);
        tvGenero  = findViewById(R.id.tvGenero);
        tvPuntaje = findViewById(R.id.tvPuntaje);

        // Recibir datos del register
        String nombre = getIntent().getStringExtra("nombre");
        String apodo = getIntent().getStringExtra("apodo");
        int edad = getIntent().getIntExtra("edad", 0);
        String colegio = getIntent().getStringExtra("colegio");
        String genero = getIntent().getStringExtra("genero");

        // Si vienes desde el juego (opcional)
        int score = getIntent().getIntExtra("FINAL_SCORE", 0);

        // Mostrar datos
        tvNombre.setText("Nombre: " + nombre);
        tvApodo.setText("Apodo: " + apodo);
        tvEdad.setText("Edad: " + edad);
        tvColegio.setText("Colegio: " + colegio);
        tvGenero.setText("Género: " + genero);
        tvPuntaje.setText("Puntaje final: " + score);
    }
}
