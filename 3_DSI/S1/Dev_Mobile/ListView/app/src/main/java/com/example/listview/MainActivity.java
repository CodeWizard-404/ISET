package com.example.listview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data source
        final Student[] data = {
                new Student(10, "Zeinab"),
                new Student(13, "Yassine"),
                new Student(20, "Youssef"),
        };

        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(data));

        // Adapter with overridden getView
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.item, R.id.itemStudent, studentList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
                Student student = getItem(position);

                TextView textView = convertView.findViewById(R.id.itemStudent);
                textView.setText(student.toString());

                ImageView imageView = convertView.findViewById(R.id.itemStudentImage);
                String imageName = "student_" + student.getNumber();
                int imageId = getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
                imageView.setImageResource(imageId);

                return convertView;
            }


        };

        // ListView
        ListView listView = findViewById(R.id.listStudents);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), value.getNumber() + " " + value.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
