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

public class Juegos04 extends AppCompatActivity {

    private MediaPlayer au_audio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_juegos04);
        au_audio1= MediaPlayer.create(Juegos04.this, R.raw.audio1);

    }

    public void irResultado(View view) {

        Intent siguiente = new Intent ( Juegos04.this,Resultado.class);
        startActivity(siguiente);
    }
    public void greenn(View View){
        au_audio1.start();

    }
}