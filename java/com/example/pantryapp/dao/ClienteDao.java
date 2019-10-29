package com.example.pantryapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pantryapp.model.Cliente;

public class ClienteDao {

    private Dao dao;
    private SQLiteDatabase banco;

    public ClienteDao(Context context) {
        dao = new Dao(context);
        banco = dao.getWritableDatabase();
    }

    public long inserir(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("CPF", cliente.getCPF());
        values.put("CEP", cliente.getCEP());
        values.put("endereco", cliente.getEndereco());
        values.put("usuario", cliente.getUsuario());
        values.put("email", cliente.getEmail());
        values.put("senha", cliente.getSenha());
        return banco.insert("cliente", null, values);
    }

    public String consulta(String campo, String busca) {
        String query = "SELECT " + campo + " FROM cliente WHERE " + campo + " = " + "'" + busca + "'";
        try {
            Cursor resultadoDaBusca = banco.rawQuery(query, null);

            resultadoDaBusca.moveToFirst();

            String resultadoString = resultadoDaBusca.getString(resultadoDaBusca.getColumnIndex(campo));

            StringBuilder conversor = new StringBuilder();
            conversor.append(resultadoString);
            return conversor.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
