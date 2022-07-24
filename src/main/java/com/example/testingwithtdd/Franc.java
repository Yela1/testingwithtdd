package com.example.testingwithtdd;

public class Franc extends Money{

    Franc(int amount, String currency) {
        super(amount,currency);
    }

    @Override
    String currency() {
        return currency;
    }

    static Money franc(int amount){
        return new Money(amount,"CHF");
    }
}
