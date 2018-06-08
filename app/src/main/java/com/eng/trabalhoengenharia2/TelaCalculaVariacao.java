package com.eng.trabalhoengenharia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaCalculaVariacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calcula_variacao);
        ListaDeConta listaDeConta = new ListaDeConta();

        String stringMes = getIntent().getStringExtra("mes");
        String stringAno = getIntent().getStringExtra("ano");

        int mes = Integer.parseInt(stringMes);
        int ano = Integer.parseInt(stringAno);


        //vai retornar a lista com o calculo das variacoes
        listaDeConta.calcularVariacao(mes, ano);


    }
}
