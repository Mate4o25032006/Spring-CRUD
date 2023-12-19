package com.jpa.PersonsCrud.Services;

import com.jpa.PersonsCrud.Entities.Person;
import com.jpa.PersonsCrud.Entities.User;
import com.jpa.PersonsCrud.Repositories.Repository;
import com.jpa.PersonsCrud.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    //Inyecçión de dependencias
    @Autowired
    private UserRepository userRepository;

    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "User Saved Successfully";
    }
}
