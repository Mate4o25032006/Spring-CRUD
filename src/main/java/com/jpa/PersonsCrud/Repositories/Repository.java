package com.jpa.PersonsCrud.Repositories;

import com.jpa.PersonsCrud.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Person, Long> {

}
