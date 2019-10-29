package com.example.pantryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pantryapp.dao.ClienteDao;

public class LoginActivity extends AppCompatActivity {
    public EditText idUsuario;
    public EditText idSenha;
    private ClienteDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.idUsuario = findViewById(R.id.idUsuario);
        this.idSenha = findViewById(R.id.idSenha);
        dao = new ClienteDao(this);
    }

    public void AbrirNewAccont(View view) {
        Intent it = new Intent(this, NewAccontActivity.class);
        startActivity(it);
    }

    public void AbrirRecover(View view) {
        Intent it = new Intent(this, RecoverActivity.class);
        startActivity(it);
    }

    public void validarLogin(View view) {
        String UsuarioRecebido = idUsuario.getText().toString();
        String senhaRecebida = idSenha.getText().toString();
        String UsuarioNoBanco = dao.consulta("usuario", UsuarioRecebido);
        String senhaNoBanco = dao.consulta("senha", senhaRecebida);

        if (UsuarioRecebido.equals(UsuarioNoBanco) && senhaRecebida.equals(senhaNoBanco)) {
            Intent it = new Intent(this, MainActivity.class);
            it.putExtra("usuarioRecebido", UsuarioRecebido);
            startActivity(it);
        } else {
            Toast toast = Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
