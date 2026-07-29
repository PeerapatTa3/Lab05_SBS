package com.cp.cafe.coffee.model;

public class Coffee {
    private int id;
    private String name;
    private double price;

    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = 0; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}