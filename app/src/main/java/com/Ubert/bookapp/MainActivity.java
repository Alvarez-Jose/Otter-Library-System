package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Create(View view) {
        Intent intent = new Intent(MainActivity.this,CreateAc.class);
        startActivity(intent);
    }
    public void Manage(View view) {
        Intent intent = new Intent(MainActivity.this,Manage.class);
        startActivity(intent);
    }
    public void Place(View view) {
        Intent intent = new Intent(MainActivity.this,Place.class);
        startActivity(intent);
    }
}