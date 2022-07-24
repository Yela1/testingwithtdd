package com.example.testingwithtdd;

public class Dollar extends Money{

    public Dollar(int amount, String currency){
        super(amount,currency);
    }


    @Override
    String currency() {
        return currency;
    }
    static Money dollar(int amount){
        return new Money(amount,"USD");
    }

}
