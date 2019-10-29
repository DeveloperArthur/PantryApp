package com.example.pantryapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Dao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cliente(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome varchar(50), " +
                "CPF varchar(50), " +
                "CEP varchar(50), " +
                "endereco varchar(50), " +
                "usuario varchar(50), " +
                "email varchar(50), " +
                "senha varchar(50)" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
