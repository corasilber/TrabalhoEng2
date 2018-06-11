package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ExibirMes extends AppCompatActivity {

    EditText mes, ano;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_mes);

        final String tela = getIntent().getStringExtra("tela");

        Button exibirMes = (Button) findViewById(R.id.exibirMes);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);
        final RadioGroup rd_group = (RadioGroup) findViewById(R.id.groupMes);

        exibirMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tipo = 0;

                switch (rd_group.getCheckedRadioButtonId()) {
                    case R.id.aguaMes:
                        tipo = 1;
                        break;
                    case R.id.energiaMes:
                        tipo = 2;
                        break;
                }

                if (tipo == 1){
                    type = "AGUA";
                }
                if (tipo == 2) {
                    type = "ENERGIA";
                }

                chamaTelaExibirMes();

                //if(tela.equals("exibirMes"))   chamaTelaExibirMes();
               //if(tela.equals("calculaVariacao")) chamaTelaCalculaVariacao();
            }
        });
    }

    public void chamaTelaExibirMes(){
        Intent mudaTela = new Intent(this, TelaExibirMes.class);
        mudaTela.putExtra("mes", mes.getText().toString());
        mudaTela.putExtra("ano", ano.getText().toString());
        mudaTela.putExtra("TipoConta",type);
        //System.out.print(type);
        startActivity(mudaTela);
    }

    public void chamaTelaCalculaVariacao(){
        Intent mudaTela = new Intent(this, TelaCalculaVariacao.class);
        mudaTela.putExtra("mes", mes.getText().toString());
        mudaTela.putExtra("ano", ano.getText().toString());
        startActivity(mudaTela);
    }
}
