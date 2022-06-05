package com.metro.bancodombosco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.metro.bancodombosco.DAO.Conexao;
import com.metro.bancodombosco.DAO.UsuarioDAO;
import com.metro.bancodombosco.model.Usuario;
import com.metro.bancodombosco.view.TelaCadastroUsuario;
import com.metro.bancodombosco.view.TelaPrincipal;

import java.util.Date;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener{

    private TextView lblCrieSuaConta;
    private Button btnEntrar;
    private EditText txtLogin, txtSenha;
    private Usuario usuario;
    private UsuarioDAO dao;
    //usuario teste@teste senha 123

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponentes();
        new Conexao(getApplicationContext(),
                "banco.db",
                null,
                1);

    }

    private void inicializaComponentes(){
        inicializaLabel();
        inicializaTextBox();
        inicializaBotoes();
    }

    private void inicializaLabel(){
        lblCrieSuaConta = findViewById(R.id.lblCrieSuaConta);
        lblCrieSuaConta.setOnClickListener(this);
    }

    private void inicializaTextBox(){
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
    }

    private void inicializaBotoes(){
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();
        if(view.equals(lblCrieSuaConta)){
            /*
            Toast.makeText(this,"Criar Usuario", Toast.LENGTH_LONG).show();
             */
            intent = new Intent(MainActivity.this,
                TelaCadastroUsuario.class);
            startActivity(intent);
        }else if(view.equals(btnEntrar) && !login.equals(null) && !senha.equals(null)){
            dao = new UsuarioDAO();
            usuario = dao.logar(login, senha);
            if(usuario!=null){
            //Apagar
                androidx.appcompat.app.AlertDialog.Builder dialogo= new
                        androidx.appcompat.app.AlertDialog.Builder(MainActivity.this);

                dialogo.setTitle("Alerta");
                dialogo.setMessage(usuario.toString());
                dialogo.setNeutralButton("Ok",null);
                dialogo.show();
            //Ate aqui
            intent = new Intent(MainActivity.this,
                    TelaPrincipal.class);
            intent.putExtra("usuarioLogado",usuario);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Email ou Senha Incorreta!",
                        Toast.LENGTH_LONG).show();
                txtLogin.setText("");
                txtSenha.setText("");
            }
        }
    }
}