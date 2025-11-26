package com.carlos.myappcarlos.controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.carlos.myappcarlos.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juegos04 extends AppCompatActivity implements View.OnClickListener {

    private TextView tvWordToGuess, tvScore, textFeedback;
    private List<ImageButton> imageButtons;
    private Pregunta preguntaActual;

    private int score = 0;
    private boolean clickBloqueado = false;

    // 🎵 SONIDOS
    private MediaPlayer sonidoCorrecto;
    private MediaPlayer sonidoIncorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos04);

        score = getIntent().getIntExtra("CURRENT_SCORE", 0);

        // Cargar sonidos reales
        sonidoCorrecto = MediaPlayer.create(this, R.raw.blue);     // Sonido correcto
        sonidoIncorrecto = MediaPlayer.create(this, R.raw.audio1); // Sonido incorrecto

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

        // ---- NIVEL AZUL ----
        List<Integer> opciones = new ArrayList<>();
        opciones.add(R.drawable.azull);   // Correcta
        opciones.add(R.drawable.rojo);
        opciones.add(R.drawable.verde);
        opciones.add(R.drawable.amarillo);

        preguntaActual = new Pregunta(
                "Blue",              // palabra a mostrar
                R.drawable.azull,    // imagen correcta
                opciones
        );

        // Mostrar palabra
        tvWordToGuess.setText(preguntaActual.palabra);

        // Mezclar imágenes
        List<Integer> opcionesMezcladas = new ArrayList<>(preguntaActual.opciones);
        Collections.shuffle(opcionesMezcladas);

        // Cargar imágenes en botones
        for (int i = 0; i < imageButtons.size(); i++) {
            ImageButton boton = imageButtons.get(i);
            int imagenId = opcionesMezcladas.get(i);
            boton.setImageResource(imagenId);
            boton.setTag(imagenId); // IMPORTANTE
        }
    }

    @Override
    public void onClick(View view) {

        if (clickBloqueado) return;
        clickBloqueado = true;

        ImageButton botonPresionado = (ImageButton) view;
        int idImagenSeleccionada = (int) botonPresionado.getTag();

        if (idImagenSeleccionada == preguntaActual.imagenCorrecta) {

            score++;
            tvScore.setText("Puntaje: " + score);

            textFeedback.setText("✔ Correcto");
            textFeedback.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));

            sonidoCorrecto.start();

        } else {

            textFeedback.setText("✘ Incorrecto");
            textFeedback.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

            sonidoIncorrecto.start();
        }

        // Muestra mensaje final luego de 1.5 segundos
        new Handler(Looper.getMainLooper()).postDelayed(this::mostrarResultadoFinal, 1500);
    }

    private void mostrarResultadoFinal() {
        textFeedback.setText("Juego Terminado. Puntuación final: " + score);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sonidoCorrecto != null) sonidoCorrecto.release();
        if (sonidoIncorrecto != null) sonidoIncorrecto.release();
    }

    // -------------------- CLASE PREGUNTA --------------------
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
