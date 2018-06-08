package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExibirMes extends AppCompatActivity {

    EditText mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_mes);

        final String tela = getIntent().getStringExtra("tela");

        Button exibirMes = (Button) findViewById(R.id.exibirMes);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);

        exibirMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tela.equals("exibirMes"))   chamaTelaExibirMes();
                if(tela.equals("calculaVariacao")) chamaTelaCalculaVariacao();
            }
        });
    }

    public void chamaTelaExibirMes(){
        Intent mudaTela = new Intent(this, TelaExibirMes.class);
        mudaTela.putExtra("mes", mes.getText().toString());
        mudaTela.putExtra("ano", ano.getText().toString());
        startActivity(mudaTela);
    }

    public void chamaTelaCalculaVariacao(){
        Intent mudaTela = new Intent(this, TelaCalculaVariacao.class);
        mudaTela.putExtra("mes", mes.getText().toString());
        mudaTela.putExtra("ano", ano.getText().toString());
        startActivity(mudaTela);
    }
}
