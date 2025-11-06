package com.carlos.myappcarlos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Juegos02 extends AppCompatActivity {

    private MediaPlayer au_audio1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos02);

        au_audio1= MediaPlayer.create(Juegos02.this, R.raw.audio1);

    }

    public void irJuegos03(View view) {

        Intent siguiente = new Intent ( Juegos02.this,Juegos03.class);
        startActivity(siguiente);
    }
    public void colibri(View View){
        au_audio1.start();

    }
}
