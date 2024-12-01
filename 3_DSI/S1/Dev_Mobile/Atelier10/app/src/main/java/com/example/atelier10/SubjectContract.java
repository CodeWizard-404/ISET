package com.example.atelier10;

import android.provider.BaseColumns;

public class SubjectContract {
    private SubjectContract() {}

    public static class SubjectEntry implements BaseColumns {
        public static final String TABLE_NAME = "subjects";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_STUDENT_ID = "student_id";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SubjectEntry.TABLE_NAME + " (" +
                    SubjectEntry._ID + " INTEGER PRIMARY KEY," +
                    SubjectEntry.COLUMN_NAME + " TEXT," +
                    SubjectEntry.COLUMN_STUDENT_ID + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SubjectEntry.TABLE_NAME;
}
