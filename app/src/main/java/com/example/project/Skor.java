package com.example.project;

public class Skor {
    private String name;
    private int size;
    private int cost;

    public Skor() {
        name = "Namn saknas";
        size = 0;
        cost = 0;
    }

    public Skor(String n, int s, int c) {
        name = n;
        size = s;
        cost = c;
    }

    public Skor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        return "Brand: " + name + "\n"+"Size: "+ size + "\n" +"Cost: "+ cost+ "kr";
    }


}