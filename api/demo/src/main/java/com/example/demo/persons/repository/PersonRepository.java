package com.example.demo.persons.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.persons.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

    private ArrayList<Person> personDB;

    public PersonRepository() {
        personDB = new ArrayList<>();
    }

    public void addPerson(Person p) {
        personDB.add(p);
    }

    public List<Person> getAllPersons() {
        return personDB;
    }

    public boolean personNameExists(String name) {
        for (Person dbPerson: personDB) {
            if (dbPerson.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
