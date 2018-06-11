package com.eng.trabalhoengenharia2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarContas extends AppCompatActivity {

    Button botaoAdiciona;
    EditText titular, mes, ano, leituraAnterior, leituraAtual;
    CheckBox energia, agua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_contas);

        botaoAdiciona = (Button) findViewById(R.id.cadastrar);
        titular = (EditText) findViewById(R.id.titular);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);
        leituraAnterior = (EditText) findViewById(R.id.leituraAnterior);
        leituraAtual = (EditText) findViewById(R.id.leituraAtual);

        final RadioGroup rd_group = (RadioGroup) findViewById(R.id.RadioConta);

        botaoAdiciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipoConta tipoConta = null;
                Titular titularConta = new Titular(titular.getText().toString());

                //dar um find no titular ?

                int tipo = 0;

                switch (rd_group.getCheckedRadioButtonId()) {
                    case R.id.AGUA:
                        tipo = 1;
                        break;
                    case R.id.ELETRICIDADE:
                        tipo = 2;
                        break;
                }

                if(tipo == 1){
                    tipoConta = TipoConta.AGUA;
                }
                if (tipo == 2){
                    tipoConta = TipoConta.ENERGIA;
                }

                 int mesConta = Integer.parseInt(mes.getText().toString());
                 int anoConta = Integer.parseInt(ano.getText().toString());
                 double anterior = Double.parseDouble(leituraAnterior.getText().toString());
                 double atual = Double.parseDouble(leituraAtual.getText().toString());

                 Conta conta = new Conta(titularConta, tipoConta, mesConta, anoConta, anterior, atual);

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("leituras");

                myRef.push().setValue(conta);
                finish();
            }
        });
    }



}
