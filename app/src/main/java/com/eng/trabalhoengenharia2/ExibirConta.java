package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ExibirConta extends AppCompatActivity {

    EditText titular;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_conta);

        Button exibirConta = (Button) findViewById(R.id.exibirConta);
        titular = (EditText) findViewById(R.id.titular);
        final RadioGroup rd_group = (RadioGroup) findViewById(R.id.RadioExibirConta);


        exibirConta.setOnClickListener(new View.OnClickListener() {
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

                chamaTelaExibirConta();
            }
        });

    }

    public void chamaTelaExibirConta(){
        Intent mudaTela = new Intent(this, TelaExibirConta.class);
        mudaTela.putExtra("titular", titular.getText().toString());
        mudaTela.putExtra("tipoConta",type);
        startActivity(mudaTela);
    }

}
