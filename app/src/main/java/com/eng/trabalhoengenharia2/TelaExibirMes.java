package com.eng.trabalhoengenharia2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelaExibirMes extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    String stringMes;
    String stringAno;
    String tipo;

    public TelaExibirMes() {
        Database db = new Database();
        database = db.database;
        ref = db.ref;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exibir_mes);

        ListaDeConta listaDeConta = new ListaDeConta();

        stringMes = getIntent().getStringExtra("mes");
        stringAno = getIntent().getStringExtra("ano");
        tipo = getIntent().getStringExtra("TipoConta");

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, itemList);
        list = (ListView)findViewById(R.id.lista);
        list.setAdapter(adapter);

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Conta conta = snapshot.getValue(Conta.class);
                    if(stringMes.equals(conta.getMes()+"") && stringAno.equals(conta.getAno()+"")) {
                        String type = conta.getTipoConta().toString();
                        //itemList.add(type);
                        //itemList.add(tipo+"teste");
                        if (tipo.equals(type)) {
                            itemList.add("Tipo: " + conta.getTipoConta() + " Valor: " + conta.getLeituraAtual());
                        }
                    }
                }

                if(itemList.size() < 1) {
                    itemList.add("Nenhum registro encontrado.");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }
}
