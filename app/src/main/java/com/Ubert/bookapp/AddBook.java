package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.Ubert.bookapp.Database;
import com.Ubert.bookapp.MainActivity;
import com.Ubert.bookapp.R;

public class AddBook extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int Selected = 0;
    EditText Name, Author;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Name = findViewById(R.id.editTextTextPersonName);
        Author = findViewById(R.id.editTextTextPassword);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Selected = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void Save(View view) {
        String N, P;
        N = Name.getText().toString();
        P = Author.getText().toString();
        if (N.isEmpty() || P.isEmpty()) {
            Toast.makeText(AddBook.this, "Please Type Name or Author !!", Toast.LENGTH_SHORT).show();
        } else {

            String Genre = "Memoir";
            if (Selected == 1) Genre = "Fiction";
            boolean L = db.AddBook(N, Genre, P);
            if (L == true) {
                Toast.makeText(AddBook.this, "Book added successfully !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddBook.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}