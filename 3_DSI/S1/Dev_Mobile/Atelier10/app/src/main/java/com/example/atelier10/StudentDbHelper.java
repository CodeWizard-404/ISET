package com.example.atelier10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "students.db";

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentContract.SQL_CREATE_ENTRIES);
        db.execSQL(SubjectContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StudentContract.SQL_DELETE_ENTRIES);
        db.execSQL(SubjectContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
