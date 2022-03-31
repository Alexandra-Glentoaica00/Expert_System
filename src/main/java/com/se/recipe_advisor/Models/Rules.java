package com.se.recipe_advisor.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rules {
    public List<String> ingredients;  //Lista de predicate
    public String name; //concluzia
}



