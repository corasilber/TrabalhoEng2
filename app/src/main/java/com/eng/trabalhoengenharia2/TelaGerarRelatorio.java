package com.eng.trabalhoengenharia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TelaGerarRelatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gerar_relatorio);

        String tipoConta = getIntent().getStringExtra("tipo");
        String anoString = getIntent().getStringExtra("ano");
        int ano = Integer.parseInt(anoString);

        ListaDeConta listaDeConta = new ListaDeConta();

        if(tipoConta.equals("Água")){
            listaDeConta.geraRelatorio(TipoConta.AGUA, ano);

            //vai retornar uma lista e tem que printar tudo da lista em um certo ano
            //criar ListView

        } else if(tipoConta.equals("Energia")){
            listaDeConta.geraRelatorio(TipoConta.ENERGIA, ano);
            //vai retornar uma lista e tem que printar tudo da lista em um certo ano

        }




    }
}
