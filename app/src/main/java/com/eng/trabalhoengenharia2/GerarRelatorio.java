package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.eng.trabalhoengenharia2.Controles.TelaGerarRelatorio;

public class GerarRelatorio extends AppCompatActivity {

    CheckBox energia, agua;
    EditText ano,mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_relatorio);

        Button gerarRelatorio = (Button) findViewById(R.id.gerarRelatorio);
        energia = (CheckBox) findViewById(R.id.checkEnergia);
        agua = (CheckBox) findViewById(R.id.checkAgua);
        mes = (EditText) findViewById(R.id.mes);
        ano = (EditText) findViewById(R.id.ano);


        gerarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaTelaRelatorio();
            }
        });
    }

    public void chamaTelaRelatorio(){

        String tipo = "";

        if(energia.isChecked()) tipo = "Energia";
        if(agua.isChecked()) tipo = "Água";

        Intent mudaTela = new Intent(this, TelaGerarRelatorio.class);
        mudaTela.putExtra("tipo", tipo);
        mudaTela.putExtra("mes", mes.getText().toString());
        mudaTela.putExtra("ano", ano.getText().toString());
        startActivity(mudaTela);


    }
}
