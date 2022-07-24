package com.example.testingwithtdd

import spock.lang.Specification
class DollarTest extends Specification{


    def "times() method should correctly multiply 2 integers"(){
        given:
            def five = Money.dollar(5)
        expect:
            five.times(providedValue) == expectedValue

        where:
            providedValue || expectedValue
            2             || Money.dollar(10)
            3             || Money.dollar(15)
    }

    def "two object should be equal"(){
        expect:
           Money.dollar(5) == Money.dollar(5)
        and:
            Money.franc(5) == Money.franc(5)
        and:
            Money.franc(5) != Money.dollar(5)
    }

    def "times() method of Franc class should correctly multiply 2 integers"(){
        given:
            def five = Money.franc(5)
        expect:
            five.times(providedValue) == expectedValue

        where:
            providedValue || expectedValue
            2             || Money.franc(10)
            3             || Money.franc(15)
    }

    def "currency test"(){
        expect:
            "USD" == Money.dollar(1).currency()
            "CHF" == Money.franc(1).currency()
    }

    def "addition test for money"() {
        given:
            def fiveDollars = Money.dollar(5)
            def result = fiveDollars + fiveDollars
            def sum = (Sum) result
        expect:
            fiveDollars == sum.augend
            fiveDollars == sum.addend

    }

    def "test for reduce sum"(){
        given:
            def bank = new Bank();
            Money result = bank.reduce(Money.dollar(1), "USD")
        expect:
            Money.dollar(1) == result
    }

    def "reduce money for different currency"(){
        given:
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2);
            def result = bank.reduce(Money.franc(2), "USD")
        expect:
            Money.dollar(1) == result
    }

    def "identity rate"(){
        expect:
            new Bank().rate("USD", "USD") == 1
    }

    def "test for multiple currency"(){
        given:
            def fiveDollars = Money.dollar(5)
            def tenFrancs = Money.franc(10)
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
            def result = bank.reduce(fiveDollars + tenFrancs, "USD")
        expect:
            Money.dollar(10) == result
    }

    def "test for Sum plus"(){
        given:
            def fiveBucks = Money.dollar(5)
            def tenFrancs = Money.franc(10)
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
            def sum = new Sum(fiveBucks, tenFrancs) + fiveBucks;
            def result = bank.reduce(sum, "USD")
        expect:
            Money.dollar(15) == result

    }

    def "test for Sum times"(){
        given:
            def fiveBucks = Money.dollar(5)
            def tenFrancs = Money.franc(10)
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
            def sum = new Sum(fiveBucks, tenFrancs).times(2)
            def result = bank.reduce(sum, "USD")
        expect:
            Money.dollar(20) == result
    }

    def "test for plus when currency is same"(){
        given:
            Expression sum = Money.dollar(1) + (Money.dollar(1))
        expect:
            sum instanceof Sum
    }


}
