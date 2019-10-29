package com.example.pantryapp.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private String CPF;
    private String CEP;
    private String endereco;
    private String usuario;
    private String email;
    private String senha;

    public Cliente(String nome, String CPF, String CEP, String endereco, String usuario, String email, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.CEP = CEP;
        this.endereco = endereco;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
