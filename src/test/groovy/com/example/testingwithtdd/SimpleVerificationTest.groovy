package com.example.testingwithtdd

import spock.lang.Specification

class SimpleVerificationTest extends Specification {

    def "is testing dependency working"(){
        expect:
            new SimpleVerification().isWorking() == "OK"
    }
}
