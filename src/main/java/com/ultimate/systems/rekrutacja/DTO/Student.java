package com.ultimate.systems.rekrutacja.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2)
    private String name;
    private String surname;

    @Min(18)
    private int age;

    @Email
    private String email;
    private String course;

    @ManyToMany
    List<Teacher> teachers;
}
