package com.jpa.PersonsCrud.Entities;

import com.jpa.PersonsCrud.Dtos.SavePersonDto;
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

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    private User user;
}
