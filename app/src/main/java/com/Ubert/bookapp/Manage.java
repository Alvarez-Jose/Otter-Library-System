package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Manage extends AppCompatActivity {
    EditText Nom, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        Nom = findViewById(R.id.editTextTextPersonName);
        Pass = findViewById(R.id.editTextTextPassword);
    }

    public void Save(View view) {
        String N, P;
        N = Nom.getText().toString();
        P = Pass.getText().toString();
        if (N.isEmpty() || P.isEmpty()) {
            Toast.makeText(Manage.this, "Please Type User or Pass.", Toast.LENGTH_SHORT).show();
        } else {

            if (N.equals("!admin2") && P.equals("!admin2")) {
                Intent intent = new Intent(Manage.this,Manage2.class);
                startActivity(intent);
                finish();
            }
        }
    }
}