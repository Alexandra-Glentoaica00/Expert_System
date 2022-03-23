package com.se.recipe_advisor.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientComponents {
    private String ingredient_name;
    private String raw_text;

    @Override
    public String toString(){
        return ".ingredient_name: " + this.ingredient_name + ".raw_text: " + raw_text;
    }
}
