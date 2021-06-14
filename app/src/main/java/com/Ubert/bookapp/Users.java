package com.Ubert.bookapp;

public class Users {
    int id;
    String Name,Pass;

    public Users(int id, String name, String pass) {
        this.id = id;
        Name = name;
        Pass = pass;
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

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
