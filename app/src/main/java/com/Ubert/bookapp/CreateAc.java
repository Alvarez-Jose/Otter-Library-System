package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Ubert.bookapp.Database;
import com.Ubert.bookapp.MainActivity;
import com.Ubert.bookapp.R;

import static java.lang.Integer.parseInt;

public class CreateAc extends AppCompatActivity {
    EditText Nom,Pass;
    Database db = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Nom = findViewById(R.id.editTextTextPersonName);
        Pass = findViewById(R.id.editTextTextPassword);
    }
    public void Save(View view) {
        String N, P;
        N = Nom.getText().toString();
        P = Pass.getText().toString();
        if (N.isEmpty() || P.isEmpty()) {
            Toast.makeText(CreateAc.this, "Please Type User or Pass !!", Toast.LENGTH_SHORT).show();
        } else {
            if (db.Exist(N)) {
                Toast.makeText(CreateAc.this, "Duplicated username", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CreateAc.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                boolean L = db.InsertData(N, P);
                if (L == true) {
                    Toast.makeText(CreateAc.this, "new account has been created successfully !!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAc.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(CreateAc.this, "Duplicated username", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAc.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}