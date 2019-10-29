package com.example.pantryapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pantryapp.R;

import java.util.List;

public class ProdutoAdapter extends ArrayAdapter {
    private Context context;
    private List<Produto> lstProduto= null ;

    public ProdutoAdapter (Context context, List<Produto>lstProduto){
        super(context,0,lstProduto);
        this.context = context;
        this.lstProduto = lstProduto;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = lstProduto.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.produto_item,null);
        }
        TextView nomeProduto = (TextView) convertView.findViewById(R.id.nomeProduto);
        TextView valorProduto = (TextView) convertView.findViewById(R.id.valorProduto);
        ImageView fotoProduto = (ImageView) convertView.findViewById(R.id.fotoProduto);


        nomeProduto.setText(produto.getNomeProduto());
        valorProduto.setText(produto.getValorProduto());
        fotoProduto.setImageResource(produto.getFotoProduto());

        return convertView;
    }
}
