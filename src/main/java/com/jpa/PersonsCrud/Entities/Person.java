package com.jpa.PersonsCrud.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String city;

    public Person() {
    }

    public Person(Long id, String name, String phone, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }
}
