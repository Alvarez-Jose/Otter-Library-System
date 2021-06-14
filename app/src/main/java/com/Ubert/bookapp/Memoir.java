package com.Ubert.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Memoir extends AppCompatActivity {
    RecyclerView recyclerView;
    Database db = new Database(this);
    List<Book> icList ;
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoir);
        recyclerView = findViewById(R.id.All);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        icList = db.GetBook1();
        BookAD holidayAd = new BookAD(Memoir.this,icList);
        recyclerView.setAdapter(holidayAd);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        if(icList.isEmpty()){
            btn.setVisibility(View.VISIBLE);
            textView.setText("there is no book available in that genre.");

        }
    }
    public void Back(View view) {
        Intent intent = new Intent(Memoir.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}