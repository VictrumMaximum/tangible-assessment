package com.example.demo.persons.controller;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.persons.model.Person;
import com.example.demo.persons.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void createPerson(@RequestBody String name, @RequestBody LocalDate birthDate) {
        personService.createPerson(
            new Person(name, birthDate)
        );
    }

    @GetMapping
    public List<Person> listFilteredPersons() {
        return personService.listFilteredPersons();
    }
}
