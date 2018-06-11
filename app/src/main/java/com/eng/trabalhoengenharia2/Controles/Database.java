package com.eng.trabalhoengenharia2.Controles;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    static FirebaseDatabase database;
    static DatabaseReference ref;

    public Database() {
        if(database == null) {
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("leituras");
        }
    }
}
