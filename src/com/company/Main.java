package com.company;

import java.util.ArrayList;
import java.util.HashMap;

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

        Inventory<Coins> coinsInventory = new Inventory<Coins>();
        Inventory<Product> productInventory = new Inventory<Product>();

        coinsInventory.add(Coins.FIVE);
        coinsInventory.add(Coins.TEN, 25);
        coinsInventory.add(Coins.FIVE);
        coinsInventory.print();

        productInventory.add(Product.COKE);
        productInventory.add(Product.PEPSI, 50);
        productInventory.add(Product.COKE);
        productInventory.print();

    }
}
