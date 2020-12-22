package com.company;

// Accepts coins $(1,5,10,25)
public enum Coins implements InverntoryItemInterface {
    ONE(1), FIVE(5), TEN(10), TWENTY_FIVE(25);

    private int value;
    private Coins(int val){
        value = val;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString(){
        return "$" + this.value;
    }

}
