package com.se.recipe_advisor.Utils;

import com.fasterxml.jackson.databind.*;
import com.se.recipe_advisor.Models.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadJSON {

    public static void main(String[] args) {

    }
    public List<Ingredient> convertJSONtoIngredientObjects() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/ingredients.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            List<Ingredient> ingredientList = new ArrayList<>();
           for(Object i:jsonArray){
                ingredientList.add(new Ingredient((String) i));
            }
            return ingredientList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

