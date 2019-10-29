package com.example.pantryapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pantryapp.dao.ClienteDao;
import com.example.pantryapp.model.Cliente;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class NewAccontActivity extends AppCompatActivity {
    public EditText etNome;
    public EditText etCPF;
    public EditText etCEP;
    public EditText etEndereco;
    public EditText etUsuario;
    public EditText etEmail;
    public EditText etSenha;
    public EditText etConfirmacaoSenha;
    public TextView tvErro;
    public CheckBox checkBox;
    private static ClienteDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_accont);
        this.etNome = findViewById(R.id.etNome);
        this.etCPF = findViewById(R.id.etCPF);
        this.etCEP = findViewById(R.id.etCEP);
        this.etEndereco = findViewById(R.id.etEndereco);
        this.etUsuario = findViewById(R.id.etUsuario);
        this.etEmail = findViewById(R.id.etEmail);
        this.etSenha = findViewById(R.id.etSenha);
        this.etConfirmacaoSenha = findViewById(R.id.etConfirmacaoSenha);
        this.tvErro = findViewById(R.id.tvErro);
        this.checkBox = findViewById(R.id.checkBox);
        dao = new ClienteDao(this);

        //Criando mascara para o campo de CPF
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(etCPF, smf);
        etCPF.addTextChangedListener(mtw);

        //Criando mascara para o campo de CEP
        SimpleMaskFormatter smf2 = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mtw2 = new MaskTextWatcher(etCEP, smf2);
        etCEP.addTextChangedListener(mtw2);

    }

    public void validarCampos(View view) {
        String nome = etNome.getText().toString();
        String CPF = etCPF.getText().toString();
        String CEP = etCEP.getText().toString();
        String endereco = etEndereco.getText().toString();
        String usuario = etUsuario.getText().toString();
        String emailEnviado = etEmail.getText().toString();
        String senha1 = etSenha.getText().toString();
        String senha2 = etConfirmacaoSenha.getText().toString();

        //verificando se campos estao preenchidos
        if (nome.length() == 0 || CPF.length() == 0 || CEP.length() == 0 || endereco.length() == 0 || usuario.length() == 0 || emailEnviado.length() == 0 || senha1.length() == 0) {
            this.tvErro.setText("Alguns campos não estão preenchidos!");
            this.tvErro.setTextColor(Color.RED);
        }
        //verificando se as senhas preenchidas sao iguais
        else if (!senha1.equals(senha2)) {
            this.tvErro.setText("Senhas precisam ser iguais!");
            this.tvErro.setTextColor(Color.RED);
        }
        //verificando se email eh valido
        else if (!emailEnviado.contains("@") || !emailEnviado.contains(".com")) {
            this.tvErro.setText("Email invalido!");
            this.tvErro.setTextColor(Color.RED);
        }
        //verificando se checkbox esta marcado
        else if (!checkBox.isChecked()) {
            this.tvErro.setText("É necessário aceitar os termos de uso");
            this.tvErro.setTextColor(Color.RED);
        }
        //verifica se usuario existe
        else if (verificaSeUsuarioExiste(usuario)) {
            this.tvErro.setText("Este usuario ja esta em uso");
            this.tvErro.setTextColor(Color.RED);
        }
        //passou por todas as validacoes, cria a conta
        else {
            this.tvErro.setText("");
            Cliente cliente = new Cliente(nome, CPF, CEP, endereco, usuario, emailEnviado, senha1);
            long id = dao.inserir(cliente);
            Toast toast = Toast.makeText(this, "Cliente cadastrado com sucesso com id " + id, Toast.LENGTH_LONG);
            toast.show();
            Intent it = new Intent(this, LoginActivity.class);
            startActivity(it);
        }
    }

    public static boolean verificaSeUsuarioExiste(String usuario) {
        String resultado = dao.consulta("usuario", usuario);
        if (resultado == null)
            return false;
        else
            return true;
    }
}
