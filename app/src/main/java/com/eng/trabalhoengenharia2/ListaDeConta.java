package com.eng.trabalhoengenharia2;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ListaDeConta {

    static FirebaseDatabase database;
    static DatabaseReference myRef;
    static String TAG = "ListaDeContas";

    public ListaDeConta() {
        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("leituras");
    }

    public void buscaPorMes(int mes){
        //recebe o mes e retorna uma lista de contas com o mes desejado (busca pelo banco de dados)
    }

    public void buscaPorMesAno(int mes, int ano){
        // busca no banco as contas com o mes e o ano especificado, retorna lista
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void buscaPorTitular(String nome){
        //busca no banco as contas com o titular = nome, retorna lista
    }

    public void geraRelatorio(TipoConta tipoConta, int ano){

        //pegar do banco as contas por mes e somar o consumo total e faturamento mensal total de um ano

        if(tipoConta == TipoConta.AGUA){
            //pega de agua
        } else if(tipoConta == TipoConta.ENERGIA){
            //busca as contas de energia
        }
    }

    public void calcularVariacao(int mes, int ano){
        //a partir de um mes e ano, calcula a variação e percentual desse mes com o
    }
}
