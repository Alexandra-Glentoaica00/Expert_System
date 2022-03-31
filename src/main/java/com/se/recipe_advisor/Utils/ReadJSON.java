package com.se.recipe_advisor.Utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.se.recipe_advisor.Models.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadJSON {

    public static void main(String[] args) {

    }

    public List<Ingredient> convertJSONtoIngredientObjects() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/ingredients.json")) {
            Object obj = jsonParser.parse(reader); //read JSON file
            JSONArray jsonArray = (JSONArray) obj;
            List<Ingredient> ingredientList = new ArrayList<>();
            for (Object i : jsonArray) {
                ingredientList.add(new Ingredient((String) i));
            }
            return ingredientList;  //lista asta este trimisa si spre front-end, dar este si lista initial-premises;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reteta> convertJSONtoRetetaObjects() {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonFactory jf = new JsonFactory();
                List<Reteta> recipesList;
                JsonParser jp = jf.createJsonParser(new File("src/main/resources/mixedResponses.json"));
                TypeReference<List<Reteta>> tRef = new TypeReference<List<Reteta>>() {};
                recipesList = mapper.readValue(jp,tRef);
//                for(Reteta reteta : recipesList){
//                    System.out.println(reteta.toString());
//                }
                return recipesList;
            }
            catch (JsonProcessingException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}
            return null;
        }

}

