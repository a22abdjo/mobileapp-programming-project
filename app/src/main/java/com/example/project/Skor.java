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

    public static class Mountain {
        private String name;
        private String location;
        private int height;

        public Mountain() {
            name="Namn saknas";
            location="plats saknas";
            height=1;
        }

        public Mountain(String n, String l, int h) {
            this.name = n;
            this.location = l;
            this.height = h;
        }

        public Mountain(String name) {
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
}