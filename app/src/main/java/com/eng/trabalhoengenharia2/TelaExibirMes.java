package com.eng.trabalhoengenharia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaExibirMes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exibir_mes);

        ListaDeConta listaDeConta = new ListaDeConta();

        String stringMes = getIntent().getStringExtra("mes");
        String stringAno = getIntent().getStringExtra("ano");

        int mes = Integer.parseInt(stringMes);
        int ano = Integer.parseInt(stringAno);

        //vai retornar a lista que vai ter que exibir na tela
        //lista em ordem alfabetica
        listaDeConta.buscaPorMesAno(mes, ano);

    }
}
