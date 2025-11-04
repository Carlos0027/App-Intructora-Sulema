package com.carlos.myappcarlos;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Numeros extends AppCompatActivity {


    private MediaPlayer au_one, au_two, au_trhee, au_four, au_five, au_six, au_seven, au_eight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_numeros);

        au_one = MediaPlayer.create(Numeros.this, R.raw.one);
        au_two = MediaPlayer.create(Numeros.this, R.raw.two);
        au_trhee = MediaPlayer.create(Numeros.this, R.raw.trhee);
        au_four = MediaPlayer.create(Numeros.this, R.raw.four);
        au_five = MediaPlayer.create(Numeros.this, R.raw.five);
        au_six = MediaPlayer.create(Numeros.this, R.raw.six);
        au_seven = MediaPlayer.create( Numeros.this, R.raw.seven);
        au_eight = MediaPlayer.create( Numeros.this, R.raw.eight);
    }

    public void one(View View) {
        au_one.start();
    }
    public void two(View View){
        au_two.start();
    }
    public void three(View View){
        au_trhee.start();
    }
    public void four(View View){
        au_four.start();
    }
    public void five(View View){
        au_five.start();
    }
    public void six(View View){
        au_six.start();
    }
    public void seven(View View){
        au_seven.start();
    }
    public void eight(View View){
        au_eight.start();
    }
}