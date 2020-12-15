package com.company;

// Products: Coke(6), Pepsi(8), Pocari(12)
public enum Product {
    PEPSI("Pepsi", 8), COKE("Coke", 6), POCARI("Pocari", 12);

    private int price;
    private String name;

    private Product(String n, int p){
        price = p;
        name = n;
    }

    public int getPrice(){
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
