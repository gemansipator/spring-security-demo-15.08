package site.javadev.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.javadev.springsecuritydemo.model.Person;
import site.javadev.springsecuritydemo.repositories.PeopleRepository;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public void savePerson(Person person) {
        peopleRepository.save(person);
    }
}