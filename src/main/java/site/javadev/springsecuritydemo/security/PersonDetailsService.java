package site.javadev.springsecuritydemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.javadev.springsecuritydemo.model.Person;
import site.javadev.springsecuritydemo.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Person> person = peopleRepository.findByUserName(username);

        if (person.isEmpty()) {
            throw new UsernameNotFoundException("Repository has not found user with username: " + username);
        }

        return new PersonDetails(person.get());
    }
}
