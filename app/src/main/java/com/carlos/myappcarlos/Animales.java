package com.carlos.myappcarlos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Animales extends AppCompatActivity {

    private MediaPlayer au_colibri, au_unicornio, au_mariposa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);


        au_mariposa = MediaPlayer.create(Animales.this, R.raw.mariposa);
        au_colibri = MediaPlayer.create(Animales.this, R.raw.colibri);
        au_unicornio = MediaPlayer.create(Animales.this, R.raw.unicornio);
    }


    public void mariposa(View view) {
        au_mariposa.start();
    }

    public void colibri(View view) {
        au_colibri.start();

    }

    public void unicornio(View view) {
        au_unicornio.start();
    }
}

