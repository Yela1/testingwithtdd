package com.example.testingwithtdd;

public interface Expression {
    Money reduce(Bank bank, String to);
    Expression times (int multiplier);

}
