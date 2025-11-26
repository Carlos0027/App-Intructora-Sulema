package com.carlos.myappcarlos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Mananger {
    //declaramos variables para llamar la conexion

    private ConexionBd conexionBd;

    private SQLiteDatabase db;

    public Mananger(Context context){

        //llamo a la conexion

        conexionBd = new ConexionBd(context);
    }

    public void openBdWr(){
        db=conexionBd.getWritableDatabase();
    }

    public void openBdRd(){
        db=conexionBd.getReadableDatabase();
    }
    public void closeBd(){
        db.close();
    }

    public long insertData(Datos datos) {
        openBdWr();
        ContentValues values = new ContentValues();
        values.put("NOMBRE", datos.getNombre());
        values.put("APODO", datos.getApodo());
        values.put("EDAD", datos.getEdad());
        values.put("COLEGIO", datos.getColegio());
        values.put("GENERO",datos.getGenero());
        long id = db.insert("Datos", null, values);
        closeBd();
        return id;

    }


}
