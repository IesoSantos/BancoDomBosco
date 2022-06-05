package com.metro.bancodombosco.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.metro.bancodombosco.model.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO {

    private Usuario usuario;

    public void salvar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("sobrenome", usuario.getSobrenome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("data_nascimento", usuario.getDataNascimento());

        SQLiteDatabase conexao = Conexao.getInstancia();
        conexao.insert("usuarios", null, values);
        //conexao.close();

    }

    public void alterar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("sobrenome", usuario.getSobrenome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("data_nascimento", usuario.getDataNascimento());
        SQLiteDatabase conexao = Conexao.getInstancia();
        conexao.update("usuarios", values, "id=?",
                new String[]{
                        String.valueOf(
                                usuario.getId()
                        )
        });
    }

    public List<Usuario> listar(){
        SQLiteDatabase conexao = Conexao.getInstancia();
        Cursor cursor = conexao.query("usuarios", new String[]{"id", "nome", "sobrenome",
                "email", "senha" ,"data_nascimento"},null,null,null,
                null, null,null);
        List<Usuario> lista = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                lista.add(
                        new Usuario(cursor.getLong(1), cursor.getString(2), cursor.getString(3),
                                cursor.getString(4), cursor.getString(5), cursor.getString(6)

                        )
                );
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public Usuario logar(String login, String senha) {

        SQLiteDatabase conexao = Conexao.getInstancia();
        String where = "email = ? and senha = ?";
        Cursor cursor = conexao.query("usuarios", new String[]{"id", "nome", "sobrenome",
                        "email", "senha", "data_nascimento"}, where, new String[]{login, senha},
                null, null, null, null);


        if (cursor.getCount() <= 0 || cursor == null) {
            return null;
        }

        if (cursor.moveToFirst()) {
            do {

                usuario = new Usuario(cursor.getLong(1),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)

                );
            } while (cursor.moveToNext());

        }
        return usuario;
    }

    public void excluir(Usuario usuario){
        SQLiteDatabase conexao = Conexao.getInstancia();
        conexao.delete("usuarios", "id = ?",
                new String[]{
                        String.valueOf(
                                usuario.getId()
                        )});

    }
}
