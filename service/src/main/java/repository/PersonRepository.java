package repository;

import java.util.ArrayList;
import java.util.List;

import com.abnamro.assessment.model.Person;

public class PersonRepository {

    private ArrayList<Person> personDB = new ArrayList<>();

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
