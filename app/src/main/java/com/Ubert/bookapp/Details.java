package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    EditText Nom,Pass;
    Database db = new Database(this);
    String ic;
    int idB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Nom = findViewById(R.id.editTextTextPersonName);
        Pass = findViewById(R.id.editTextTextPassword);
        idB  = getIntent().getExtras().getInt("id");
        ic = db.SearchBK(idB);
    }
    public void Save(View view) {
        String N, P;
        N = Nom.getText().toString();
        P = Pass.getText().toString();
        if (N.isEmpty() || P.isEmpty()) {
            Toast.makeText(Details.this, "Please Type User or Pass.", Toast.LENGTH_SHORT).show();
        }
        else {
                if(db.Correct(N,P)==-1)
                    Toast.makeText(Details.this, "Incorrect Username or pass!", Toast.LENGTH_SHORT).show();
                else {
                    int id  = db.Correct(N,P);
                    Integer L = db.Delete(String.valueOf(idB));
                    boolean b = db.AddBooks(id,idB);
                    int Num = db.Number();

                    Toast.makeText(Details.this, "1. Customer username: " +N+"\n"+
                            "2. Book Title: “"+ic+"”\n" +
                            "3. Reservation number: "+(Num)+"\n", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Details.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }

        }
    }
}