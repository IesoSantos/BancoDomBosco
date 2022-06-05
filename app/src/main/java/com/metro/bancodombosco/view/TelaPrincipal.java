package com.metro.bancodombosco.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.metro.bancodombosco.R;
import com.metro.bancodombosco.model.Usuario;

public class TelaPrincipal extends AppCompatActivity {

    private Usuario usuario;
    private TextView txtViewNomeCompleto;
    private RecyclerView lstMovimentacaoFinanceira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        usuario = getIntent().getParcelableExtra("usuarioLogado");
        txtViewNomeCompleto = findViewById(R.id.txtViewNomeCompleto);
        txtViewNomeCompleto.setText(usuario.toString());
        /*
        txtViewNomeCompleto.setText(
                getString(
                        R.string.nome_completo,
                        usuario.getNome(),
                        usuario.getSobrenome()
                )
        );
         */
        lstMovimentacaoFinanceira = findViewById(R.id.lstMovimentacaoFinanceira);
        //lstMovimentacaoFinanceira.setLayoutManager(LinearLayoutManager);
    }
}