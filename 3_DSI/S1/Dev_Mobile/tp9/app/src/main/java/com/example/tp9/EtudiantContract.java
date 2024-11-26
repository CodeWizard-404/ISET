package com.example.tp9;

import android.provider.BaseColumns;

public class EtudiantContract {
    private EtudiantContract() {}
    public static class EtudiantEntry implements BaseColumns {
        public static final String TABLE_NAME = "etudiants";
        public static final String COLUMN_NUMERO = "numero";
        public static final String COLUMN_NOM = "nom";

    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EtudiantEntry.TABLE_NAME + " (" +
                    EtudiantEntry._ID + " INTEGER PRIMARY KEY," +
                    EtudiantEntry.COLUMN_NUMERO + " INTEGER," +
                    EtudiantEntry.COLUMN_NOM + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EtudiantEntry.TABLE_NAME;
}
