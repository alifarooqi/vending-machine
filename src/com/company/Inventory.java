package com.company;
import java.util.HashMap;

public class Inventory {
    /*
        ***JS***
        inventory is a JSON Object
     */

    /*
     ***JS***
     * let inventory = {}
     */
    HashMap<InverntoryItemInterface, Integer> inventory = new HashMap<InverntoryItemInterface, Integer>();
    private int totalValue = 0;

    public int getTotalValue() {
        return this.totalValue;
    }

    // Item: quantity

    public int getQuantity(InverntoryItemInterface item){
        Integer quantity = inventory.get(item); // ***JS*** quantity = inventory[item]
        return quantity == null ? 0 : quantity; // Ternary operator
        /*
            if(quantity == null){
                return 0;
            }
            else{
                return quantity;
            }
         */
    }

    public void add(InverntoryItemInterface item, int quantityDelivered){
        Integer currentQuantity = inventory.get(item); // Null or int

        if(quantityDelivered < 1){
            throw new IllegalArgumentException("Quantity delivered has to be greater than 0.");
        }
        else if(currentQuantity == null){
            /*
            ***JS***
            * inventory[item] = quantityDelivered
             */
            inventory.put(item, quantityDelivered); // Adding key value pair
            this.totalValue += item.getValue() * quantityDelivered;
        } else {
            inventory.put(item, currentQuantity + quantityDelivered); // Updating the key value pair
            this.totalValue += item.getValue() * quantityDelivered;
        }
    }
    // tmpStorage = { Coin.25: 10, Coin.10: 5 }
    // coinInventory = { Coin.25: 100, Coin.10: 50 }

    // coinInventory.add(tmpStorage)
    // inventory2 = { Coin.25: 110, Coin.10: 55 }
    public void add(Inventory i){
//        this --> coinInventory
//        i --> tmpStorage
        for (InverntoryItemInterface c : i.inventory.keySet()){
            this.add(c, i.getQuantity(c));
        }
    }

    public void add(InverntoryItemInterface item){
        this.add(item, 1);
    }

    public void remove(InverntoryItemInterface item){
        this.remove(item, 1);
    }

    public void remove(InverntoryItemInterface item, int quantityRemoved){
        Integer currentQuantity = inventory.get(item); // Null or int
        if(currentQuantity == null){
            throw new KeyNotFoundException("Item not in the inventory: " + item);
        } else if(quantityRemoved <= 0){
            throw new IllegalArgumentException("Quantity removed has to be greater than 0.");
        }
        else if(currentQuantity < quantityRemoved){
            throw new IllegalArgumentException("Quantity removed has to be greater than or equal to " + currentQuantity);
        }
        else{
            inventory.put(item, currentQuantity - quantityRemoved);
            this.totalValue -= (item.getValue() * quantityRemoved);
        }
    }

    public boolean hasItem(InverntoryItemInterface item){
        int current = this.getQuantity(item);
        return current > 0;
    }
        /*
   ->   if(condition)
            return true;
        else
            return false;


   ->   return condition
     */

    public void clear(){
        inventory.clear(); // Emptying the inventory
    }

    public void print(){
        System.out.println("*****************************");
        for(InverntoryItemInterface item : this.inventory.keySet()){
            System.out.println(item + " -> " + this.inventory.get(item));
        }
    }

}
