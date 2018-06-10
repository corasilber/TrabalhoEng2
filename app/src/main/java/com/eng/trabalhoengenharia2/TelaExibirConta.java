package com.eng.trabalhoengenharia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaExibirConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exibir_conta);

        ListaDeConta listaDeConta = new ListaDeConta();
        String titular = getIntent().getStringExtra("titular");

        //retorna a lista com as contas do titular desejado
        //criar list view com essa lista
       // listaDeConta.buscaPorTitular(titular);
    }
}
