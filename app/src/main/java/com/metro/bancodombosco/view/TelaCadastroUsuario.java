package com.metro.bancodombosco.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.metro.bancodombosco.DAO.UsuarioDAO;
import com.metro.bancodombosco.R;
import com.metro.bancodombosco.model.Usuario;

import java.util.Date;

public class TelaCadastroUsuario extends AppCompatActivity
implements View.OnClickListener {

    private EditText txtNome, txtSobrenome, txtEmail,
        txtDataNascimento, txtCadastroSenha, txtConfirmaSenha;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);
        inicializaComponentes();
    }

    private void inicializaComponentes(){
        inicializaTextBox();
        inicializaBotao();
    }

    private void inicializaTextBox(){
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtDataNascimento = findViewById(R.id.txtDataNascimento);
        txtCadastroSenha = findViewById(R.id.txtCadastroSenha);
        txtConfirmaSenha = findViewById(R.id.txtConfirmarSenha);
    }

    private void inicializaBotao(){
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(txtCadastroSenha.getText().toString().equals(txtConfirmaSenha.getText().toString())) {
            Usuario usuario = new Usuario(0,
                    txtNome.getText().toString(),
                    txtSobrenome.getText().toString(),
                    txtEmail.getText().toString(),
                    txtCadastroSenha.getText().toString(), txtDataNascimento.getText().toString());
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            AlertDialog.Builder dialogo= new
                    AlertDialog.Builder(TelaCadastroUsuario.this);

            dialogo.setTitle("Sucesso!");
            //dialogo.setMessage("Usuário "+usuario.getNome()+" Cadastrado!");
            dialogo.setMessage(usuario.toString());
            dialogo.setNeutralButton("Ok",null);
            dialogo.show();
            //Intent it = new Intent(TelaCadastroUsuario.this, TelaPrincipal.class);
            //startActivity(it);

        }else{
            AlertDialog.Builder dialogo= new
                    AlertDialog.Builder(TelaCadastroUsuario.this);
            dialogo.setTitle("Erro!");
            dialogo.setMessage("Senhas Diferente Pressionado");
            dialogo.setNeutralButton("Ok",null);
            dialogo.show();
        }
    }
}