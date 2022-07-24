package com.example.testingwithtdd;

public class Sum implements Expression{
    private Expression augend;
    private Expression addend;

    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Expression getAugend() {
        return augend;
    }

    public Expression getAddend() {
        return addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank,to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier),addend.times(multiplier));
    }
}
