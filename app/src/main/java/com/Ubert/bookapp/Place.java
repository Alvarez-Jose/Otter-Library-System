package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Place extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
    }
    public void Fiction(View view) {
        Intent intent = new Intent(Place.this,Fiction.class);
        startActivity(intent);
    }
    public void Memoir(View view) {
        Intent intent = new Intent(Place.this,Memoir.class);
        startActivity(intent);
    }
}