package com.example.project;

public class Skor {
    private String name;
    private String size;
    private int height;

    public Skor() {
        name = "Namn saknas";
        size = "----";
        height = 1;
    }

    public Skor(String n, String s, int h) {
        this.name = n;
        this.size = s;
        this.height = h;
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

    public String toString() {
        return name;
    }
}