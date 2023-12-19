package com.jpa.PersonsCrud.Repositories;

import com.jpa.PersonsCrud.Entities.Person;
import com.jpa.PersonsCrud.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
