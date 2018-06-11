package com.eng.trabalhoengenharia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TelaExibirConta extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    String titular;
    String tipo;

    public TelaExibirConta() {
        Database db = new Database();
        database = db.database;
        ref = db.ref;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_exibir_conta);

        titular = getIntent().getStringExtra("titular");
        tipo = getIntent().getStringExtra("tipoConta");

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
                    if(titular.equals(conta.getTitular())) {
                        String type = conta.getTipoConta().toString();
                        if (tipo.equals(type)){
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
