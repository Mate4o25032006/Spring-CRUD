package com.jpa.PersonsCrud.Controllers;
import com.jpa.PersonsCrud.Entities.Person;
import com.jpa.PersonsCrud.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    //Inyección de dependencias
    @Autowired
    PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping()
    public String index(){
        return "CONECTADO EXITOSAMENTE";
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }

    @PostMapping("/persons")
    public String savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @PutMapping("persons/{id}")
    public String updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("persons/{id}")
    public String deletePerson(@PathVariable Long id){
        return personService.deletePerson(id);
    }
}
