package com.carlos.myappcarlos.controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

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

