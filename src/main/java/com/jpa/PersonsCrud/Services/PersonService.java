package com.jpa.PersonsCrud.Services;

import com.jpa.PersonsCrud.Dtos.SavePersonDto;
import com.jpa.PersonsCrud.Entities.Person;
import com.jpa.PersonsCrud.Entities.User;
import com.jpa.PersonsCrud.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    //Inyecçión de dependencias
    @Autowired
    private Repository personRepository;
    @Autowired
    private UserService userService;

    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public String savePerson(@RequestBody Person person){
        //personRepository.save(person);
        //return "Saved Successfully";

        person.setName(person.getName());
        person.setPhone(person.getPhone());
        person.setCity(person.getCity());

        User userPerson = person.getUser();
        User user = new User();
        user.setUserName(userPerson.getUserName());
        user.setPassword(userPerson.getPassword());

        person.setUser(user);
        user.setPerson(person);

        personRepository.save(person);
        userService.saveUser(user);

        return "Saved Successfully";
    }

    public String updatePerson(@PathVariable Long id, @RequestBody Person person){
        Person updatePerson = personRepository.findById(id).get();
        updatePerson.setName(person.getName());
        updatePerson.setPhone(person.getPhone());
        updatePerson.setCity(person.getCity());

        personRepository.save(updatePerson);
        return "Updated Successfully";
    }

    public String deletePerson(@PathVariable Long id){
        Person deletedPerson = personRepository.findById(id).get();
        personRepository.delete(deletedPerson);
        return "Deleted Successfully";
    }
}
