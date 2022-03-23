package com.se.recipe_advisor.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reteta {
    private String name;
    private int total_time_minutes;
    private int num_servings;
    private List<String> instructions;
    private int id;
    private List<IngredientComponents> ingredients;

    @Override
    public String toString(){
        return "name: " + this.name + ". total_time_minutes: " + this.total_time_minutes + ". num_servings: " + this.num_servings + ".id:  " + this.id + ". instructions" + instructions.toString() + ". ingredients: " + ingredients.toString();
    }

}
