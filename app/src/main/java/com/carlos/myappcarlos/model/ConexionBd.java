package com.carlos.myappcarlos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class ConexionBd extends SQLiteOpenHelper {

    public ConexionBd(@Nullable Context context){
        super(context, Constantes.NAME_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE DATOS(NOMBRE TEXT, APODO TEXT, EDAD NUMBER, COLEGIO TEXT, GENERO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion){

    }


}
