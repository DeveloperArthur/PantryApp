package com.example.pantryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RecoverActivity extends AppCompatActivity {
    public EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover);
        this.etEmail = findViewById(R.id.etEmail);
    }

    public void enviarEmail(View view) {
        String emailDoUsuario = etEmail.getText().toString();
        String emailPantryApp = "suporte-pantryapp@gmail.com";
        String assunto = "Recuperação de Senha";
        String mensagem = "Esqueci minha senha, por favor resete para mim!";
        String titulo = "PantryApp Recuperação de Senha";

        Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emailPantryApp, null));
        email.putExtra(Intent.EXTRA_SUBJECT, assunto);
        email.putExtra(Intent.EXTRA_TEXT, mensagem);
        startActivity(Intent.createChooser(email, titulo));

    }
}