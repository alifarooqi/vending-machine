package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/*
    (enum) Product: .... [2 attrs]
    (enum) Coins: ....   [1 attr]

    HashMap:
        Word: Meaning
        "Hello": "Greeting..."

        Key: Value
        - T1: T2
        --- String: Integer
                "One": 1
        --- Product: Integer
                Product.PEPSI: 50






 */


public class Main {

    public static void main(String[] args) {
	// write your code here\
        /*
            Problem:
            1. Accepts coins $(1,5,10,25)
            2. Products: Coke(6), Pepsi(8), Pocari(12)
            3. Inventory: Transaction or Exception
            4. Valid Change: Change or Exception
         */

        // Hash Map (Dict/Obj)

        // Data type

//        Coins c = Coins.FIVE;
//        System.out.println(c.getValue());

//        Product p = Product.PEPSI;
//        System.out.println(p.getName());
//        System.out.println(p.getPrice());

//        Inventory coinsInventory = new Inventory();
//        Inventory<Product> productInventory = new Inventory<Product>();
//
//        coinsInventory.add(Coins.FIVE);
//        coinsInventory.add(Coins.TEN, 25);
//        coinsInventory.add(Coins.FIVE);
//        coinsInventory.remove(Coins.TEN);
//        coinsInventory.add(Coins.TWENTY_FIVE);
//        System.out.println(coinsInventory.getQuantity(Coins.FIVE));
//        System.out.println(coinsInventory.hasItem(Coins.ONE));
//        coinsInventory.print();
//
//        productInventory.add(Product.COKE);
//        productInventory.add(Product.PEPSI, 50);
//        productInventory.add(Product.COKE);
//        productInventory.remove(Product.POCARI);
//        productInventory.print();

//        VendingMachine v = new VendingMachine();
//        v.displayProducts();
//        v.setSelectedProduct(Product.POCARI);
//        v.insertCoin(Coins.FIVE);
//        v.insertCoin(Coins.ONE);
//        v.insertCoin(Coins.FIVE);


//        Inventory coinsInventory = new Inventory();
//        Inventory tmpStorage = new Inventory();
//
//        coinsInventory.add(Coins.TEN, 25);
//        coinsInventory.add(Coins.TWENTY_FIVE, 100);
//        coinsInventory.print();
//
//        tmpStorage.add(Coins.TEN, 2);
//        tmpStorage.add(Coins.TWENTY_FIVE, 1);
//        tmpStorage.add(Coins.FIVE, 1);
//        tmpStorage.print();
//
//        coinsInventory.add(tmpStorage);
//        coinsInventory.print();

        VendingMachine v = new VendingMachine();
        v.productInventory.print();
        v.coinInventory.print();
        v.displayProducts();
        v.setSelectedProduct(Product.POCARI);
        v.insertCoin(Coins.TEN); // Total paid: $5
        v.insertCoin(Coins.ONE); // Total paid: $6
        v.insertCoin(Coins.ONE); // Total paid: $12
        v.productInventory.print();
        v.coinInventory.print();



    }
}
