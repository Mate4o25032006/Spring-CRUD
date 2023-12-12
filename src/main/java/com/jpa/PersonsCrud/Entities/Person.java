package com.jpa.PersonsCrud.Entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String city;
}
