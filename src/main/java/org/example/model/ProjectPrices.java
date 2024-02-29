package org.example.model;

public class ProjectPrices {
    private int id;
    private int price;

    public ProjectPrices(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
