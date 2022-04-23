package com.abnamro.assessment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.abnamro.assessment.model.Person;

import org.junit.Before;
import org.junit.Test;

import repository.PersonRepository;

/**
 * PersonServiceTest
 */
public class PersonServiceTest {

    PersonRepository pr;
    PersonService ps;

    @Before
    public void init() {
        pr = new PersonRepository();
        ps = new PersonService(pr);
    }

    @Test
    public void createAllowedPerson() throws Exception {
        Person p = new Person("allowed", LocalDate.of(2000, 1, 10));
        ps.createPerson(p);

        List<Person> allPersons = pr.getAllPersons();

        assertEquals(1, allPersons.size());

        assertEquals(p, allPersons.get(0));
    }

    @Test
    public void createPersonTooShortName() throws Exception {
        Person p = new Person("a", LocalDate.of(2000, 1, 10));

        assertThrows(IllegalArgumentException.class, () -> {
            ps.createPerson(p);
        });
    }
    
    @Test
    public void createDuplicatePerson() throws Exception {
        Person p = new Person("duplicate name", LocalDate.of(2000, 1, 10));

        ps.createPerson(p);

        assertThrows(IllegalArgumentException.class, () -> {
            ps.createPerson(p);
        });
    }

    @Test
    public void listFilteredPersons() throws Exception {
        int[] bannedYears = new int[]{1982, 1999, 2002};

        Person allowedPerson = new Person("allowed person", LocalDate.of(2000, 1, 10));

        pr.addPerson(allowedPerson);

        for (int bannedYear: bannedYears) {
            pr.addPerson(new Person("banned person " + bannedYear, LocalDate.of(bannedYear, 1, 10)));
        }

        List<Person> filteredPersons = ps.listFilteredPersons();

        assertEquals(1, filteredPersons.size());

        assertEquals(allowedPerson, filteredPersons.get(0));
    } 
}