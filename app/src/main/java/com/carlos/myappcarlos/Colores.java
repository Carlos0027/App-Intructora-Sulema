package com.carlos.myappcarlos;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colores extends AppCompatActivity {

private MediaPlayer au_red, au_green, au_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        au_red = MediaPlayer.create( Colores.this, R.raw.red);
        au_blue = MediaPlayer.create(Colores.this, R.raw.blue);
        au_green = MediaPlayer.create( Colores.this, R.raw.green);
    }

    public void red(View View){
        au_red.start();
    }

    public void blue(View View){
        au_blue.start();
    }

    public void green(View View){
        au_green.start();
    }

}