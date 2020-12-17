package com.company;

public class CoinsClass {
    private int value;
    public CoinsClass(int val){
        value = val;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString(){
        return "$" + this.value;
    }

    public boolean equals(CoinsClass c){
        return true;
    }

}
