package com.company;

public class VendingMachine {
    public Inventory<Coins> coinInventory;
    public Inventory<Product> productInventory;
    private Inventory<Coins> tempCoinStorage;

    private Product selectedProduct;
    private int selectedQuantity;

    /*
        1. Coin Inventory
        2. Product Inventory
        3. You can display products
        4. You can select a product
        5. You can pay for the product
            5.1 Throw error if not enough change
            5.2 Give the change back
            5.3 Temp coin inventory
     */

    public VendingMachine(){
        coinInventory = new Inventory<Coins>();
        productInventory = new Inventory<Product>();
        tempCoinStorage = new Inventory<Coins>();
        selectedQuantity = 0; // Represents that quantity is not selected

        // Populating Coin Inventory
        coinInventory.add(Coins.ONE, 100);
        coinInventory.add(Coins.FIVE, 50);
        coinInventory.add(Coins.TEN, 20);
        coinInventory.add(Coins.TWENTY_FIVE, 10);

        // Populating Product Inventory
        productInventory.add(Product.POCARI, 5);
        productInventory.add(Product.COKE, 10);
        productInventory.add(Product.PEPSI, 2);
    }

    public void displayProducts(){
        for (Product p : this.productInventory.inventory.keySet()){
            if(productInventory.hasItem(p))
                System.out.println("Product is available " + p);
        }
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
        if(this.selectedQuantity == 0) // If user has not set the quantity yet
            this.selectedQuantity = 1; // then set it as 1
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }
}
