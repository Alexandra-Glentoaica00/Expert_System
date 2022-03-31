package com.se.recipe_advisor.Utils;

import com.se.recipe_advisor.Models.Ingredient;
import com.se.recipe_advisor.Models.IngredientComponents;
import com.se.recipe_advisor.Models.Reteta;
import com.se.recipe_advisor.Models.Rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateRules {

    public static void main(String[] args) {
        createRulesList();
    }
   // private ReadJSON readJson;

    public static List<Rules> createRulesList(){
        ReadJSON readJson;
        readJson = new ReadJSON();
        List<Reteta> recipesList = readJson.convertJSONtoRetetaObjects(); //lista in care avem toate retele
        List<IngredientComponents> icList = new ArrayList<>();
        List<String> ingredientsList = new ArrayList<>(); //lista in care vrem sa salam toate ingredientele din toate retele
        List<Rules> rulesList= new ArrayList<>();

        for(Reteta i:recipesList) {
            icList = i.getIngredients();
            for (IngredientComponents ingredientComponents : icList) {
                ingredientsList.add(ingredientComponents.getIngredient_name());
            }
            Rules rules = new Rules(ingredientsList,i.getName());
            rulesList.add(rules);
            ingredientsList = new ArrayList<>();
        }

        return rulesList;
    }

}
