package com.eng.trabalhoengenharia2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegistrarContas extends AppCompatActivity {

    Button botaoAdiciona;
    EditText titular, mes, ano, leituraAnterior, leituraAtual;
    CheckBox energia, agua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_contas);

        energia = (CheckBox) findViewById(R.id.checkBox);
        agua = (CheckBox) findViewById(R.id.checkBox2);
        botaoAdiciona = (Button) findViewById(R.id.cadastrar);
        titular = (EditText) findViewById(R.id.titular);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);
        leituraAnterior = (EditText) findViewById(R.id.leituraAnterior);
        leituraAtual = (EditText) findViewById(R.id.leituraAtual);

        botaoAdiciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TipoConta tipoConta = null;
                Titular titularConta = new Titular(titular.getText().toString());

                //dar um find no titular ?

                if(energia.isChecked()) tipoConta = TipoConta.ENERGIA;
                if(agua.isChecked()) tipoConta = TipoConta.AGUA;

                if(!mes.getText().toString().isEmpty() || !ano.getText().toString().isEmpty() || !leituraAnterior.getText().toString().isEmpty()
                            || !leituraAtual.getText().toString().isEmpty()){

                     int mesConta = Integer.parseInt(mes.getText().toString());
                     int anoConta = Integer.parseInt(ano.getText().toString());
                     double anterior = Double.parseDouble(leituraAnterior.getText().toString());
                     double atual = Double.parseDouble(leituraAtual.getText().toString());

                     Conta conta = new Conta(titularConta, tipoConta, mesConta, anoConta, anterior, atual);

                     finish();

                } else {
                    Snackbar.make(v, "Adicione todos os campos!", Snackbar.LENGTH_LONG).show();
                }

                //salvar essa conta em algum lugar?

            }
        });
    }



}