package com.eng.trabalhoengenharia2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button registrarConta= (Button) findViewById(R.id.registrarConta);
        Button gerarRelatorio = (Button) findViewById(R.id.gerarRelatorio);
        Button exibirMes = (Button) findViewById(R.id.exibirMes);
        Button exibirConta = (Button) findViewById(R.id.exibirConta);
        Button calculaVariacao = (Button) findViewById(R.id.calculaVariacao);

        registrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRegistrarConta();
            }
        });

        exibirMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirExibirMes();
            }
        });

        exibirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirExibirConta();
            }
        });


        gerarRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGerarRelatorio();
            }
        });


        calculaVariacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCalculaVariacao();
            }
        });
    }

    public void abrirCalculaVariacao(){
        Intent mudaTela = new Intent(this, ExibirMes.class);
        mudaTela.putExtra("tela", "calculaVariacao");
        startActivity(mudaTela);
    }

    public void abrirExibirConta(){
        Intent mudaTela = new Intent(this, ExibirConta.class);
        startActivity(mudaTela);
    }

    public void abrirExibirMes(){
        Intent mudaTela = new Intent(this, ExibirMes.class);
        mudaTela.putExtra("tela", "exibirMes");
        startActivity(mudaTela);
    }

    public void abrirRegistrarConta(){
        Intent mudaTela = new Intent(this, RegistrarContas.class);
        startActivity(mudaTela);
    }

    public void abrirGerarRelatorio(){
        Intent mudaTela = new Intent(this, GerarRelatorio.class );
        startActivity(mudaTela);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
