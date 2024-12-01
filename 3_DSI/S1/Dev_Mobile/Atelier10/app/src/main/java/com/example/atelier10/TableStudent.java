package com.example.atelier10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TableStudent {
    private final SQLiteDatabase db;

    public TableStudent(Context context) {
        StudentDbHelper dbHelper = new StudentDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void addStudent(int id, String name) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.StudentEntry.COLUMN_NAME, name);
        db.insert(StudentContract.StudentEntry.TABLE_NAME, null, values);
    }

    public ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String[] projection = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.COLUMN_NAME
        };
        Cursor cursor = db.query(
                StudentContract.StudentEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.COLUMN_NAME));
            students.add(new Student(id, name));
        }
        cursor.close();
        return students;
    }

    public void deleteAllStudents() {
        db.delete(StudentContract.StudentEntry.TABLE_NAME, null, null);
    }

    public void addSampleData() {
        addStudent(1, "Zeinab");
        addStudent(2, "Yassine");
        addStudent(3, "Youssef");
    }
}
