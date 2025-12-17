package com.carlos.myappcarlos.controller;

import android.content.Intent;
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

    // Datos del registro
    private String nombre, apellido, email;

    // 🎵 Sonidos
    private MediaPlayer sonidoCorrecto;
    private MediaPlayer sonidoIncorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos04);

        // Recibir puntaje previo (si existiera)
        score = getIntent().getIntExtra("CURRENT_SCORE", 0);

        // Recibir datos del registro
        nombre = getIntent().getStringExtra("nombre");
        apellido = getIntent().getStringExtra("apellido");
        email = getIntent().getStringExtra("email");

        // Crear sonidos
        sonidoCorrecto = MediaPlayer.create(this, R.raw.blue);
        sonidoIncorrecto = MediaPlayer.create(this, R.raw.audio1);

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
        opciones.add(R.drawable.azull); // Correcta
        opciones.add(R.drawable.rojo);
        opciones.add(R.drawable.verde);
        opciones.add(R.drawable.amarillo);

        preguntaActual = new Pregunta(
                "Blue",
                R.drawable.azull,
                opciones
        );

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

        new Handler(Looper.getMainLooper()).postDelayed(this::mostrarResultadoFinal, 1500);
    }

    private void mostrarResultadoFinal() {
        textFeedback.setText("Juego Terminado. Puntuación final: " + score);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            Intent intent = new Intent(Juegos04.this, MostrarDatos.class);

            // ENVIAR DATOS DEL REGISTER
            intent.putExtra("nombre", nombre);
            intent.putExtra("apellido", apellido);
            intent.putExtra("email", email);

            // ENVIAR PUNTAJE FINAL
            intent.putExtra("FINAL_SCORE", score);

            startActivity(intent);

            // 🔥 ANIMACIÓN (ya conectada)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            finish();

        }, 1000);
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
