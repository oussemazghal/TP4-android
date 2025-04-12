package com.example.myapplicationkk;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListeActivity extends AppCompatActivity {

    ListView listView;
    TaskDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        listView = findViewById(R.id.listView);
        db = new TaskDatabaseHelper(this);

        List<String> tasks = db.getAllTasks();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
    }
}
