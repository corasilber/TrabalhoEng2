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

public class TelaCalculaVariacao extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;
    String titular;
    String tipo;

    public TelaCalculaVariacao() {
        Database db = new Database();
        database = db.database;
        ref = db.ref;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calcula_variacao);

        String stringMes = getIntent().getStringExtra("mes");
        String stringAno = getIntent().getStringExtra("ano");
        final String tipoConta = getIntent().getStringExtra("TipoConta");

        final int mes = Integer.parseInt(stringMes);
        final int ano = Integer.parseInt(stringAno);

        //vai retornar a lista com o calculo das variacoes

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, itemList);
        list = (ListView)findViewById(R.id.lista);
        list.setAdapter(adapter);

        final ArrayList<Conta> anoCorrente = new ArrayList<>();
        final ArrayList<Conta> anoAnterior = new ArrayList<>();

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Conta conta = snapshot.getValue(Conta.class);
                    String type = conta.getTipoConta().getTipo();
                    if (tipoConta.equals(type)){
                        if(conta.getAno() == ano && conta.getMes() == mes) {
                            anoCorrente.add(conta);

//                            itemList.add("Tipo: " + conta.getTipoConta() + " Variação Consumo: " + conta.getLeituraMes() + " Variação Faturamento: " + con);
                        } else if(conta.getAno() == ano - 1 && conta.getMes() == mes) {
                            anoAnterior.add(conta);
                        }
                    }
                }

                for(Conta conta : anoCorrente) {
                    for(Conta contaAA : anoAnterior) {
                        if(conta.getMes() == contaAA.getMes() && conta.getAno() == contaAA.getAno() + 1) {
                            conta.setContaAnoAnterior(contaAA);
                        }
                    }
                }

                for(Conta conta : anoCorrente) {
                    if(conta.getMes() == mes && conta.getAno() == ano) {
                        double leituraMesAtual = conta.getLeituraMes();
                        double faturamentoMesAtual = conta.getLeituraMes() * 2;
                        double leituraAnoAnterior = conta.getContaAnoAnterior() != null ? conta.getContaAnoAnterior().getLeituraMes() : 1;
                        double faturamentoAnoAnterior = conta.getContaAnoAnterior() != null ? conta.getContaAnoAnterior().getLeituraMes() * 2 : 1;
                        double multiplier = conta.getContaAnoAnterior() != null ? 100 : 1;
                        String variacaoConsumo = Math.round(((leituraMesAtual - leituraAnoAnterior) / leituraAnoAnterior) * multiplier) + "%";
                        String variacaoFaturamento = (Math.round(((faturamentoMesAtual - faturamentoAnoAnterior) / faturamentoAnoAnterior) * multiplier) + 20) + "%";
                        itemList.add("Tipo: " + conta.getTipoConta() + " | Variação Consumo: " + variacaoConsumo  + " | Variação Faturamento: " + variacaoFaturamento);
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
