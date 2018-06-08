package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExibirConta extends AppCompatActivity {

    EditText titular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_conta);

        Button exibirConta = (Button) findViewById(R.id.exibirConta);
        titular = (EditText) findViewById(R.id.titular);

        exibirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaTelaExibirConta();
            }
        });

    }

    public void chamaTelaExibirConta(){
        Intent mudaTela = new Intent(this, TelaExibirConta.class);
        mudaTela.putExtra("titular", titular.getText().toString());
        startActivity(mudaTela);
    }

}
