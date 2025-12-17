package com.carlos.myappcarlos.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.carlos.myappcarlos.R;

public class Login extends AppCompatActivity {

    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular componentes del XML
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
    }

    // Botón Iniciar Sesión
    public void irBienvenido(View view) {

        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        // Validar campos vacíos
        if (email.isEmpty() || password.isEmpty()) {

            new AlertDialog.Builder(this)
                    .setTitle("Campos incompletos")
                    .setMessage("Por favor complete todos los campos")
                    .setPositiveButton("Aceptar", null)
                    .show();

        } else {
            // Si todo está correcto, pasa a la siguiente pantalla
            Intent intent = new Intent(Login.this, Bienvenido.class);
            startActivity(intent);
        }
    }

    // Texto Registrarse
    public void irRegister02(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
