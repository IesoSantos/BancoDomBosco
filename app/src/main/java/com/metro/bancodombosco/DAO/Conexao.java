package com.metro.bancodombosco.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static SQLiteDatabase instancia;

    public Conexao(@Nullable Context context,
                   @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
        instancia = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //dropaTabelas(sqLiteDatabase);
        criaTabelas(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        dropaTabelas(sqLiteDatabase);
        onCreate(sqLiteDatabase);

    }

    public void criaTabelas(SQLiteDatabase sqLiteDatabase){
        String queryTabelaUsuario = "create table if not exists usuarios(";
        queryTabelaUsuario += "id integer primary key autoincrement, ";
        queryTabelaUsuario += "nome varchar(100) not null, ";
        queryTabelaUsuario += "sobrenome varchar(100) not null, ";
        queryTabelaUsuario += "email varchar(100) UNIQUE, ";
        queryTabelaUsuario += "senha varchar(100) not null, ";
        queryTabelaUsuario += "data_nascimento varchar(8) not null";
        queryTabelaUsuario += ");";
        sqLiteDatabase.execSQL(queryTabelaUsuario);
    }

    public void dropaTabelas(SQLiteDatabase sqLiteDatabase){
        String sql = "DROP TABLE IF EXISTS usuarios";
        sqLiteDatabase.execSQL(sql);
    }

    public static SQLiteDatabase getInstancia(){
        return instancia;
    }
}
