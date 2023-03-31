package com.example.onmobdatabase;

public class Data {

    private String name, pass;

    public Data(){

    }
    public Data(String name, String pass) {

        this.name = name;
        this.pass = pass;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setPass(String pass){

        this.pass = pass;
    }

    public String getName(){

        return this.name;
    }

    public String getPass(){

        return this.pass;
    }
}
