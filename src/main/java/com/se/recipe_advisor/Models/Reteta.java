package com.se.recipe_advisor.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reteta {
    private int id;
    private String name;
    private int total_time_minutes;
    private int num_servings;
    private List<String> instructions;
    private List<IngredientComponents> ingredients_rawText;
}
