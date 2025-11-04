package com.carlos.myappcarlos;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Frutas extends AppCompatActivity {

    private MediaPlayer au_manzana, au_sandia, au_mango, au_limon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frutas);

        au_mango = MediaPlayer.create(Frutas.this, R.raw.mango);
        au_manzana = MediaPlayer.create( Frutas.this, R.raw.manzana);
        au_sandia = MediaPlayer.create( Frutas.this, R.raw.sandia);
        au_limon = MediaPlayer.create( Frutas.this, R.raw.limon);

    }
    public void mango(View View){
        au_mango.start();
    }

    public void manzana(View View){
        au_manzana.start();
    }

    public void sandia(View View){
        au_sandia.start();
    }

    public void limon(View View){
        au_limon.start();
    }

}