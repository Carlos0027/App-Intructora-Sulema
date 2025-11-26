package com.carlos.myappcarlos.controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class Juegos03 extends AppCompatActivity {

    TextView tvWordToGuess, tvScore, textFeedback;
    ImageButton img1, img2, img3, img4;

    int correctIndex = 0;
    int score = 0;

    MediaPlayer sonidoCorrecto;
    MediaPlayer sonidoIncorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos03);

        // Referencias UI
        tvWordToGuess = findViewById(R.id.tvWordToGuess);
        tvScore = findViewById(R.id.tvScore);
        textFeedback = findViewById(R.id.textFeedback);

        img1 = findViewById(R.id.imgOption1);
        img2 = findViewById(R.id.imgOption2);
        img3 = findViewById(R.id.imgOption3);
        img4 = findViewById(R.id.imgOption4);

        // Sonidos
        sonidoCorrecto = MediaPlayer.create(this, R.raw.two);       // Cambia si tienes otro audio
        sonidoIncorrecto = MediaPlayer.create(this, R.raw.audio1);  // Cambia si tienes otro audio

        configurarJuego();
    }

    private void configurarJuego() {

        // Palabra correcta
        tvWordToGuess.setText("Two");

        // Imagen correcta = opción 2
        correctIndex = 2;

        // Listeners
        img1.setOnClickListener(v -> verificarRespuesta(1));
        img2.setOnClickListener(v -> verificarRespuesta(2));
        img3.setOnClickListener(v -> verificarRespuesta(3));
        img4.setOnClickListener(v -> verificarRespuesta(4));
    }

    private void verificarRespuesta(int opcionSeleccionada) {

        if (opcionSeleccionada == correctIndex) {

            textFeedback.setText("✔ ¡Correcto!");
            score++;
            tvScore.setText("Puntaje: " + score);

            sonidoCorrecto.start();

        } else {

            textFeedback.setText("✘ Incorrecto");
            sonidoIncorrecto.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sonidoCorrecto != null) sonidoCorrecto.release();
        if (sonidoIncorrecto != null) sonidoIncorrecto.release();
    }
}
