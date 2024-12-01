package com.example.atelier10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TableSubject {
    private final SQLiteDatabase db;

    public TableSubject(Context context) {
        SubjectDbHelper dbHelper = new SubjectDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Method to add a subject for a student
    public void addSubject(String name, int studentId) {
        ContentValues values = new ContentValues();
        values.put(SubjectContract.SubjectEntry.COLUMN_NAME, name);
        values.put(SubjectContract.SubjectEntry.COLUMN_STUDENT_ID, studentId);
        db.insert(SubjectContract.SubjectEntry.TABLE_NAME, null, values);
    }

    public ArrayList<Subject> loadSubjects(int studentId) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String[] projection = {
                SubjectContract.SubjectEntry.COLUMN_NAME
        };
        String selection = SubjectContract.SubjectEntry.COLUMN_STUDENT_ID + " = ?";
        String[] selectionArgs = { String.valueOf(studentId) };

        Cursor cursor = db.query(
                SubjectContract.SubjectEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(SubjectContract.SubjectEntry.COLUMN_NAME));
            subjects.add(new Subject(name));
        }
        cursor.close();
        return subjects;
    }

    public void deleteAllSubjects() {
        db.delete(SubjectContract.SubjectEntry.TABLE_NAME, null, null);
    }

    public void addSampleData() {
        addSubject("Math", 1);
        addSubject("Science", 1);
        addSubject("English", 2);
        addSubject("History", 3);
    }
}
