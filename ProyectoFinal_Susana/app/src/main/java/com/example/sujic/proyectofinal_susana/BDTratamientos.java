package com.example.sujic.proyectofinal_susana;

import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sujic on 09/02/2017.
 */
public class BDTratamientos extends SQLiteOpenHelper {
    public BDTratamientos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    // Tabla Tratamiento
    String tratamiento = "CREATE TABLE Tratamiento(nombre text primary key, precio integer, descripción text)";
    String insertTratamiento ="INSERT INTO Tratamiento values('Mesoterapia', 5, 'Mejora la piel de naranja, reduce la grasa localizada y el envejecimiento facial. Actúa sobre cualquier zona facial o corporal.')";
    String insertTratamiento1 ="INSERT INTO Tratamiento values('Fotorejuvenecimiento', 50, 'Técnica no invasiva que elimina las arrugas, las líneas de expresión, y las manchas en el rostro producidas por el sol. Se produce un alisado y una mejora en la textura de la piel.')";



    //String insertTratamiento ="INSERT INTO Tratamiento";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tratamiento);
        db.execSQL(insertTratamiento);
        db.execSQL(insertTratamiento1);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }


}
