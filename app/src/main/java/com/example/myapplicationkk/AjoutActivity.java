package com.example.myapplicationkk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AjoutActivity extends AppCompatActivity {

    EditText editTextTask;
    Button buttonAdd;
    TaskDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        db = new TaskDatabaseHelper(this);

        buttonAdd.setOnClickListener(v -> {
            String task = editTextTask.getText().toString().trim();
            if (!task.isEmpty()) {
                db.insertTask(task);
                Toast.makeText(this, "Tâche ajoutée", Toast.LENGTH_SHORT).show();
                editTextTask.setText("");
            } else {
                Toast.makeText(this, "Veuillez entrer une tâche", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
