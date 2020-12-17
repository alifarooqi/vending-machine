package com.company;
import java.util.HashMap;

public class Inventory<T>{
    /*
        ***JS***
        inventory is a JSON Object
     */

    /*
     ***JS***
     * let inventory = {}
     */
    HashMap<T, Integer> inventory = new HashMap<T, Integer>();

    // Item: quantity

    public int getQuantity(T item){
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

    public void add(T item, int quantityDelivered){
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
        } else {
            inventory.put(item, currentQuantity + quantityDelivered); // Updating the key value pair
        }
    }

    public void add(T item){
        Integer currentQuantity = inventory.get(item); // Null or int
        if(currentQuantity == null){
            inventory.put(item, 1); // Adding key value pair
        } else{
            inventory.put(item, currentQuantity + 1); // Updating the key value pair
        }
    }

    public void remove(T item){
        Integer currentQuantity = inventory.get(item); // Null or int
        if(currentQuantity == null){
            throw new KeyNotFoundException("Item not in the inventory: " + item);
        } else{
            inventory.put(item, currentQuantity - 1); // Updating the key value pair
        }
    }

    public void remove(T item, int quantityRemoved){
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
        }
    }

    public boolean hasItem(T item){
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
        for(T item : this.inventory.keySet()){
            System.out.println(item + " -> " + this.inventory.get(item));
        }
    }

}
