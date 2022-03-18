package com.se.recipe_advisor.Models;

import lombok.AllArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@Entity
public class Fruct {  //JPA entity class, which will be responsible for modde
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String nume;
}
