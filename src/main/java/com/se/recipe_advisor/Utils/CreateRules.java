package com.se.recipe_advisor.Utils;

import com.se.recipe_advisor.Controlers.IngredientController;
import com.se.recipe_advisor.Controlers.RetetaController;
import com.se.recipe_advisor.Models.Ingredient;
import com.se.recipe_advisor.Models.IngredientComponents;
import com.se.recipe_advisor.Models.Reteta;
import com.se.recipe_advisor.Models.Rules;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CreateRules {

    public static List<Rules> rulesList1 = new ArrayList<>(); //lista globala cu toate regulile
    static List<String> selectedIngredientsString = new ArrayList<>(); //lista globala cu alegerile utilizatorului din front-end --- sub forma de String
    static List<Reteta> RetetaList = ReadJSON.convertJSONtoRetetaObjects();

    public static void saveIngredients(List<Ingredient> selectedIngredients1) {
        selectedIngredientsString = selectedIngredients1.stream().map(x -> x.getNume()).collect(Collectors.toList());

        createRulesList();
        //masinaInferenta();
        List<Reteta> recipesToFrontend = masinaInferenta();
    }

    public static void createRulesList() {
        ReadJSON readJson;
        readJson = new ReadJSON();
        List<Reteta> recipesList = readJson.convertJSONtoRetetaObjects(); //lista in care avem toate retele
        List<IngredientComponents> icList = new ArrayList<>(); //lista in care salvam toate componentele IngredientComponent din retete
        List<String> ingredientsList = new ArrayList<>(); //lista in care vrem sa salam toate ingredientele din fiecare IngredientComponent
        List<Rules> rulesList = new ArrayList<>(); //lista locala in care salvam toate regulile

        for (Reteta i : recipesList) {
            icList = i.getIngredients();
            for (IngredientComponents ingredientComponents : icList) {
                ingredientsList.add(ingredientComponents.getIngredient_name());
            }
            Rules rules = new Rules(ingredientsList, i.getName());
            rulesList.add(rules);
            ingredientsList = new ArrayList<>();
        }

        rulesList1 = rulesList; //copiem lista locala in lista globala

    }

    public static List<Reteta> masinaInferenta() {

        int counter;
        int size;
        List<Reteta> reteta = new ArrayList<>();


        for (Rules rules : rulesList1) {
            counter = 0;
            for (String stringRulesIngredients : rules.getIngredients()) {
                for (String stringSelectedIngredients : selectedIngredientsString) {
                    if (stringRulesIngredients.equals(stringSelectedIngredients))
                        counter++;
                }
            }
            size=rules.getIngredients().size();
            if(counter > size/2){
                Optional<Reteta> retetaObj = RetetaList.stream().filter(x -> rules.getName().equals(x.getName())).findAny();
                if(retetaObj.isPresent()){
                    reteta.add(retetaObj.get());
                }
            }
            System.out.println("Counter: " + counter);
        }

        return reteta;
    }

}

