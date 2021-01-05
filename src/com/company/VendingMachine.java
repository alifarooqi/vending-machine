package com.company;

public class VendingMachine {
    public Inventory coinInventory;
    public Inventory productInventory;
    private Inventory tempCoinStorage;

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
        coinInventory = new Inventory();
        productInventory = new Inventory();
        tempCoinStorage = new Inventory();
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
        for (InverntoryItemInterface p : this.productInventory.inventory.keySet()){
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

    public void insertCoin(Coins coin){
        this.tempCoinStorage.add(coin);
        // Check if the value of temp storage >= the total required amount
        int requiredAmount = this.selectedQuantity * this.selectedProduct.getPrice();
        // Temp storage --> Coins and their quantity
        // Iterate over all the coins and then sum up the value of coin * quantity
        int remainingValue = requiredAmount - this.tempCoinStorage.getTotalValue();
        if(remainingValue > 0 ){
            System.out.println("Remaining value: " + remainingValue);
        }
        else if (remainingValue == 0) {
            System.out.println("Here's your product " + this.selectedProduct.getName());
            // Reset
            // 1. To deduct product from the product inventory
            this.productInventory.remove(this.selectedProduct, this.selectedQuantity);
            // 2. Move Coins from tmp storage to coin inventory
            // this --> coinInventory --> add()
            this.coinInventory.add(this.tempCoinStorage);
            // 3. Empty the tmpStorage
            this.tempCoinStorage.clear();
            // this --> VendingMachine
            // this.tempCoinStorage --> Inventory
            // this.tempCoinStorage.clear() --> void
            System.out.println("Thank you for shopping with us!");
        }
        else {
            // Now we need to check if the change is there
            remainingValue *= -1; // $32

            // Check how many $25 do we need to return
            int twentyFive = this.calculateChangeValue(Coins.TWENTY_FIVE, remainingValue);
            remainingValue -= twentyFive * Coins.TWENTY_FIVE.getValue();

            int ten = this.calculateChangeValue(Coins.TEN, remainingValue);
            remainingValue -= ten * Coins.TEN.getValue();

            int five = this.calculateChangeValue(Coins.FIVE, remainingValue);
            remainingValue -= five * Coins.FIVE.getValue();

            int one = this.calculateChangeValue(Coins.ONE, remainingValue);
            remainingValue -= one * Coins.ONE.getValue();

            if(remainingValue > 0)
                throw new InsufficientChangeException("Not enough coins in the inventory!");
            else{
                System.out.println("Change is available");
                System.out.println("$25: " + twentyFive);
                System.out.println("$10: " + ten);
                System.out.println("$5: " + five);
                System.out.println("$1: " + one);
            }


            // TODO Do other stuff



        }
    }

    private int calculateChangeValue(Coins c, int remainingValue){
        return Math.min(remainingValue % c.getValue(), this.coinInventory.getQuantity(c));
    }
}
