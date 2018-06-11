package com.eng.trabalhoengenharia2.Controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eng.trabalhoengenharia2.Entidades.Conta;
import com.eng.trabalhoengenharia2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TelaGerarRelatorio extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    String titular;
    double consumo;
    double valor;

    public TelaGerarRelatorio() {
        Database db = new Database();
        database = db.database;
        ref = db.ref;
        consumo = 0;
        valor = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gerar_relatorio);

        final String tipoConta = getIntent().getStringExtra("tipo");
        String anoString = getIntent().getStringExtra("ano");
        final int ano = Integer.parseInt(anoString);

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

                    if(tipoConta.equals("Água")){
                        if(ano == conta.getMes()) {
                            consumo += conta.getLeituraAtual();
                            valor += conta.getLeituraAtual() * 2;
                        }
                    } else if(tipoConta.equals("Energia")){
                        if(ano == conta.getMes()) {
                            consumo += conta.getLeituraAtual();
                            valor += conta.getLeituraAtual() * 2;
                        }
                    }
                }

                itemList.add("Consumo: " + consumo + " Faturamento: " + valor);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }
}
