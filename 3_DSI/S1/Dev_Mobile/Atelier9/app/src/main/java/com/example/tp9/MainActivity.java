package com.example.tp9;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TableEtudiant tableEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        tableEtudiant = new TableEtudiant(this);

        tableEtudiant.deleteAllEtudiant();
        tableEtudiant.addSampleData();

        Arraylist<Etudiant> etudiants = tableEtudiant.loadEtudiants();
        ArrayAdapter<Etudiant> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, etudiants);
        listView.setAdapter(adapter);
    }
}