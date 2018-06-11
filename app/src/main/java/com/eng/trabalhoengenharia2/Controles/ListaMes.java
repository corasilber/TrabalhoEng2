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

public class ListaMes extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    FirebaseDatabase database;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mes);


        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, itemList);
        list = (ListView)findViewById(R.id.lista);
        list.setAdapter(adapter);

        Database db = new Database();
        database = db.database;
        ref = db.ref;

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Conta conta = dataSnapshot.getValue(Conta.class);
                    itemList.add("Tipo: " + conta.getTipoConta() + " Valor: " + conta.getLeituraAtual());
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
