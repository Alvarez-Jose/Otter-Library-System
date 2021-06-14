package com.Ubert.bookapp;

public class Book {
    int id;
    String Name,Author;

    public Book(int id, String name, String author) {
        this.id = id;
        Name = name;
        Author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
