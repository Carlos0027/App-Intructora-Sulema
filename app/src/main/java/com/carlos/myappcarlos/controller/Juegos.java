package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.carlos.myappcarlos.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juegos extends AppCompatActivity implements View.OnClickListener {

    // --- Vistas y Variables del Juego ---
    private TextView tvWordToGuess, tvScore, textFeedback;
    private List<ImageButton> imageButtons;
    private Pregunta preguntaActual;
    private int score = 0;
    private boolean clickBloqueado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        score = 0; // Puntaje inicial

        vincularVistas();
        configurarListeners();
        cargarPregunta();
    }

    private void vincularVistas() {
        tvWordToGuess = findViewById(R.id.tvWordToGuess);
        tvScore = findViewById(R.id.tvScore);
        textFeedback = findViewById(R.id.textFeedback);

        imageButtons = new ArrayList<>();
        imageButtons.add(findViewById(R.id.imgOption1));
        imageButtons.add(findViewById(R.id.imgOption2));
        imageButtons.add(findViewById(R.id.imgOption3));
        imageButtons.add(findViewById(R.id.imgOption4));
    }

    private void configurarListeners() {
        for (ImageButton ib : imageButtons) {
            ib.setOnClickListener(this);
        }
    }

    private void cargarPregunta() {
        clickBloqueado = false;
        textFeedback.setText("");
        tvScore.setText("Puntaje: " + score);


        // --- Define la pregunta de este nivel ---
        List<Integer> opciones = new ArrayList<>();
        opciones.add(R.drawable.sandia); // Respuesta correcta
        opciones.add(R.drawable.mango);
        opciones.add(R.drawable.manzana);
        opciones.add(R.drawable.limmon); // Corregido typo de "limmon" a "limon"

        preguntaActual = new Pregunta("Watermelon", R.drawable.sandia, opciones);
        // ------------------------------------

        tvWordToGuess.setText(preguntaActual.palabra);

        List<Integer> opcionesMezcladas = new ArrayList<>(preguntaActual.opciones);
        Collections.shuffle(opcionesMezcladas);

        for (int i = 0; i < imageButtons.size(); i++) {
            ImageButton boton = imageButtons.get(i);
            int imagenId = opcionesMezcladas.get(i);
            boton.setImageResource(imagenId);
            boton.setTag(imagenId);
        }
    }

    @Override
    public void onClick(View view) {
        if (clickBloqueado) return;
        clickBloqueado = true;

        ImageButton botonPresionado = (ImageButton) view;
        int idImagenPresionada = (int) botonPresionado.getTag();

        if (idImagenPresionada == preguntaActual.imagenCorrecta) {
            score++;
            tvScore.setText("Puntaje: " + score);
            textFeedback.setText("¡Correcto!");
            textFeedback.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        } else {
            textFeedback.setText("Incorrecto");
            textFeedback.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        }

        new Handler(Looper.getMainLooper()).postDelayed(this::iniciarSiguienteActividad, 1500);
    }

    private void iniciarSiguienteActividad() {
        Intent intent = new Intent(this, Juegos02.class);
        intent.putExtra("CURRENT_SCORE", score);
        startActivity(intent);
        finish();
    }

    // Clase interna para definir la estructura de una pregunta
    private static class Pregunta {
        final String palabra;
        final int imagenCorrecta;
        final List<Integer> opciones;

        public Pregunta(String palabra, int imagenCorrecta, List<Integer> opciones) {
            this.palabra = palabra;
            this.imagenCorrecta = imagenCorrecta;
            this.opciones = opciones;
        }
    }
}
