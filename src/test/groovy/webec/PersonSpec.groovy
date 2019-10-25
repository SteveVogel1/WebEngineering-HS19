package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }

    void "construction and access"() {
        given:
            Person dierk = new Person(firstName: "Dierk", lastName: "König")
        expect:"one can access the parameters two ways"
            dierk.firstName == "Dierk"
            dierk.getFirstName() == "Dierk"
            dierk.lastName == "König"
    }
}
