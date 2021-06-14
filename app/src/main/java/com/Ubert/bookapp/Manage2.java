package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class Manage2 extends AppCompatActivity {
    RecyclerView recyclerView;
    Database db = new Database(this);
    List<Users> icList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage2);
        recyclerView = findViewById(R.id.All);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        icList = db.getAll();
        UsersAD holidayAd = new UsersAD(Manage2.this,icList);
        recyclerView.setAdapter(holidayAd);
    }

    public void Add(View view) {
        Intent intent = new Intent(Manage2.this, AddBook.class);
        startActivity(intent);
    }
}