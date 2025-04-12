package com.example.myapplicationkk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonSave;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        editTextName = findViewById(R.id.editTextName);
        buttonSave = findViewById(R.id.buttonSave);
        prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);

        String savedName = prefs.getString("username", null);
        if (savedName != null) {
            Toast.makeText(this, "Bienvenue " + savedName, Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        buttonSave.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            prefs.edit().putString("username", name).apply();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}
