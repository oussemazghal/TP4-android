package com.example.myapplicationkk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Affiche le layout avec toolbar

        // Liaison de la Toolbar personnalisée
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // Affichage du menu dans la Toolbar (3 points)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Gestion des clics sur les options du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_add) {
            startActivity(new Intent(this, AjoutActivity.class));
            return true;
        } else if (id == R.id.menu_list) {
            startActivity(new Intent(this, ListeActivity.class));
            return true;
        } else if (id == R.id.menu_reset) {
            SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
            prefs.edit().clear().apply();
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
