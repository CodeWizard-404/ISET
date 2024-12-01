package com.example.atelier10;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ListView subjectsListView;
    private TableStudent tableStudent;
    private TableSubject tableSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        subjectsListView = findViewById(R.id.subjectsListView);
        tableStudent = new TableStudent(this);
        tableSubject = new TableSubject(this);

        tableStudent.deleteAllStudents();
        tableStudent.addSampleData();

        ArrayList<Student> students = tableStudent.loadStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student selectedStudent = students.get(position);
                showSubjectsForStudent(selectedStudent);
            }
        });
    }

    private void showSubjectsForStudent(Student student) {
        ArrayList<Subject> subjects = tableSubject.loadSubjects(student.getId());

        if (subjects.isEmpty()) {
            ArrayList<String> noSubjects = new ArrayList<>();
            noSubjects.add("No subjects found for this student.");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noSubjects);
            subjectsListView.setAdapter(adapter);
        } else {
            ArrayList<String> subjectNames = new ArrayList<>();
            for (Subject subject : subjects) {
                subjectNames.add(subject.getName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjectNames);
            subjectsListView.setAdapter(adapter);
        }
    }
}
