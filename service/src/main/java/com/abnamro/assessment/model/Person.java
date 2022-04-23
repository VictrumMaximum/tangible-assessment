package com.abnamro.assessment.model;

import java.time.LocalDate;

/**
 * Person
 */
public class Person {
    // Timer start at 16:00
    // Timer end at 17:17

    private String name;
    private LocalDate birthDate;

    public Person() {}

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }
        Person otherPerson = (Person) other;

        if (!this.name.equals(otherPerson.name)) {
            return false;
        }
        if (!this.birthDate.equals(otherPerson.birthDate)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.name;
    }

}

