package com.abnamro.assessment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.abnamro.assessment.model.Person;

import repository.PersonRepository;

/**
 * PersonService
 */
public class PersonService {

    private static final int[] BANNED_YEARS = new int[]{1982, 1999, 2002};
    private static final int MIN_NAME_LENGTH = 2;

    private PersonRepository personRepository;

    public PersonService(PersonRepository pr) {
        personRepository = pr;
    }

    public void createPerson(Person p) throws IllegalArgumentException {
        if (p.getName().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("Person name must be at least 2 characters.");
        }

        if (personRepository.personNameExists(p.getName())) {
            throw new IllegalArgumentException("A person with this name already exists.");
        }

        personRepository.addPerson(p);
    }

    public List<Person> listFilteredPersons() {
        List<Person> dbPersons = personRepository.getAllPersons();

        return dbPersons.stream().filter(
            p -> !this.isBannedBirthday(p.getBirthDate())
        ).collect(Collectors.toList());
    }

    private boolean isBannedBirthday(LocalDate birthDate) {
        for (Integer bannedYear: BANNED_YEARS) {
            if (bannedYear == birthDate.getYear()) {
                return true;
            }
        }
        return false;
    }
    
}