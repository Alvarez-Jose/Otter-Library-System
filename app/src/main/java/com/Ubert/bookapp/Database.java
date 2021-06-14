package com.Ubert.bookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String Name ="Data.db";
    public Database(@Nullable Context context) {
        super(context, Name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Users (id INTEGER  PRIMARY KEY AUTOINCREMENT , Name TEXT, Pass TEXT )");
        db.execSQL("create table Books (id INTEGER  PRIMARY KEY AUTOINCREMENT , Name TEXT, Genre TEXT , Author TEXT )");
        db.execSQL("create table Book (id INTEGER  PRIMARY KEY AUTOINCREMENT , idU INTEGER, idB INTEGER , FOREIGN KEY(idU) REFERENCES Users(id) " +
                ",FOREIGN KEY(idB) REFERENCES Books(id) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Books");
        db.execSQL("DROP TABLE IF EXISTS Book");

        onCreate(db);
    }


    public boolean InsertData(String Name,String Pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Pass",Pass);

        long r = db.insert("Users",null,contentValues);
        if(r < 0) return false;
        else return true;

    }
    public boolean AddBook(String Name,String Genre,String Author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Genre",Genre);
        contentValues.put("Author",Author);

        long r = db.insert("Books",null,contentValues);
        if(r < 0) return false;
        else return true;
    }
    public boolean AddBooks(int idU,int idB){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idU",idU);
        contentValues.put("idB",idB);

        long r = db.insert("Book",null,contentValues);
        if(r < 0) return false;
        else return true;
    }


    public boolean Exist(String NomS){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            String Nom = cursor.getString(1);
            if(Nom.equals(NomS)) return true;
            cursor.moveToNext();
        }
        return  false;
    }
    public List<Users> getAll(){
        List<Users> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Users",null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            int id = cursor.getInt(0);
            String Nom = cursor.getString(1);
            String Prenom = cursor.getString(2);

            Users ic = new Users(id,Nom,Prenom);
            arrayList.add(ic);
            cursor.moveToNext();
        }
        return  arrayList;
    }
    public List<Book> GetBook1(){
        List<Book> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books WHERE Genre = 'Memoir'",null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            int id = cursor.getInt(0);
            String Nom = cursor.getString(1);
            String Prenom = cursor.getString(3);

            Book ic = new Book(id,Nom,Prenom);
            arrayList.add(ic);
            cursor.moveToNext();
        }
        return  arrayList;
    }
    public List<Book> GetBook2(){
        List<Book> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books WHERE Genre = 'Fiction'",null);
        cursor.moveToFirst();
        while(cursor.isAfterLast()==false){
            int id = cursor.getInt(0);
            String Nom = cursor.getString(1);
            String Prenom = cursor.getString(3);

            Book ic = new Book(id,Nom,Prenom);
            arrayList.add(ic);
            cursor.moveToNext();
        }
        return  arrayList;
    }


    public int Correct(String n, String p) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id = cursor.getInt(0);
            String Nom = cursor.getString(1);
            String Pass = cursor.getString(2);

            if(Nom.equals(n) && Pass.equals(p)) return id;
            cursor.moveToNext();
        }
        return  -1;
    }
    public Integer Delete(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Books","id = ?",new String[]{ID});
    }
    public String SearchBK(int id) {
        String BK="";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Books",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            int id1 = cursor.getInt(0);
            BK = cursor.getString(1);
            if(id==id1) return BK;
            cursor.moveToNext();
        }
        return  BK;
    }
    public int Number() {
        int i=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Book",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            i++;
            //note to self add this line or else app crashes........cdxgvbdsg
            cursor.moveToNext();
        }
        return  i;
    }
}
