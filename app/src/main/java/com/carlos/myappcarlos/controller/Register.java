package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;
import com.carlos.myappcarlos.model.ConexionBd;
import com.carlos.myappcarlos.model.Datos;
import com.carlos.myappcarlos.model.Mananger;

public class Register extends AppCompatActivity {

    Mananger mananger;

    EditText edtNombre, edtApodo, edtAge;
    Spinner spinnerColegio;

    RadioButton radioMale, radioFemale;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNombre = findViewById(R.id.edtNombre);
        edtApodo = findViewById(R.id.edtApodo);
        edtAge = findViewById(R.id.edtAge);

        spinnerColegio = findViewById(R.id.spinnerColegio);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);

        btnSubmit = findViewById(R.id.btnSubmit);

        mananger = new Mananger(Register.this);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = edtNombre.getText().toString();
                String apodo = edtApodo.getText().toString();
                int edad = Integer.parseInt(edtAge.getText().toString());
                String colegio = spinnerColegio.getSelectedItem().toString();
                String genero = radioMale.isChecked() ? "Hombre" : "Mujer";

                // Crear objeto Datos
                Datos datos = new Datos(nombre, apodo, edad, colegio, genero);

                // Insertar datos
                long resul = mananger.insertData(datos);

                if (resul > 0) {
                    Toast.makeText(Register.this, "Datos insertados", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Register.this, "Error al insertar datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Toast.makeText(this, "BD creada", Toast.LENGTH_SHORT).show();
    }
    public void irLogin(View view) {
        Intent siguiente = new Intent(Register.this, Login.class);
        startActivity(siguiente);
    }
}
