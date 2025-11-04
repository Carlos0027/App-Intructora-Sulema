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

public class Juegos extends AppCompatActivity {

    private MediaPlayer au_audio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        au_audio1 = MediaPlayer.create(Juegos.this, R.raw.audio1);

    }

    public void sandia(View View){
        au_audio1.start();

    }
    public void irMenuApp(View view) {

        Intent siguiente = new Intent ( Juegos.this,Elecciones.class);
        startActivity(siguiente);
    }
}