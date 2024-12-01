package com.example.tp9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TableEtudiant {
    private final SQLiteDatabase db;

    public TableEtudiant(Context context) {
        EtudiantDbHelper dbHelper = new EtudiantDbHelper(context);
        db = new EtudiantDbHelper(context).getWritableDatabase();
    }

    public void addEtudiant(int numero, String nom) {
        ContentValues values = new ContentValues();
        values.put(EtudiantContract.EtudiantEntry.COLUMN_NOM, nom);
        values.put(EtudiantContract.EtudiantEntry.COLUMN_NUMERO, numero);
        db.insert(EtudiantContract.EtudiantEntry.TABLE_NAME, null, values);
    }

    public ArrayList<Etudiant> loadEtudiants() {
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        String[] projection = {
                EtudiantContract.EtudiantEntry.COLUMN_NOM,
                EtudiantContract.EtudiantEntry.COLUMN_NUMERO
        };
        Cursor cursor = db.query(
                EtudiantContract.EtudiantEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int numero = cursor.getInt(cursor.
                    getColumnIndexOrThrow(EtudiantContract.
                            EtudiantEntry.COLUMN_NUMERO));
            String nom = cursor.getString(cursor.
                    getColumnIndexOrThrow(EtudiantContract.
                            EtudiantEntry.COLUMN_NOM));
            etudiants.add(new Etudiant(nom, numero));
        }
        cursor.close();
        return etudiants;
    }
    public void deleteAllEtudiant() {
        db.delete(EtudiantContract.EtudiantEntry.TABLE_NAME, null, null);
    }
    public void addSampleData() {
        addEtudiant(1, "Zeinab");
        addEtudiant(2, "Yassine");
        addEtudiant(3, "Youssef");
    }
}
