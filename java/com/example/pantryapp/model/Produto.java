package com.example.pantryapp.model;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String descProduto;
    private String valorProduto;
    private int fotoProduto;

    public Produto(int idProduto, String nomeProduto, String descProduto, String valorProduto, int fotoProduto){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.valorProduto = valorProduto;
        this.fotoProduto = fotoProduto;

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(int fotoProduto) {
        this.fotoProduto = fotoProduto;
    }
}
