package com.se.recipe_advisor.Utils;

import com.fasterxml.jackson.databind.*;
import com.se.recipe_advisor.Models.*;
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
    public List<Fruct> convertJSONtoFructObjects() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/Recipes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject listaIngredienteAcceptate = (JSONObject) jsonObject.get("ingrediente_acceptate");
            List<String> listaFructeString = (List<String>) listaIngredienteAcceptate.get("fructe"); //aici am deja o lista cu string-uri corespunzatoare fructelor
            List<Fruct> listaFructe=new ArrayList<>();
            for(String i:listaFructeString){
                listaFructe.add(new Fruct(i));
            }
            return listaFructe;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void convertJSONtoCondimentObjects() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/Recipes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject listaIngredienteAcceptate = (JSONObject) jsonObject.get("ingrediente_acceptate");
            List<String> listaCondimenteString = (List<String>) listaIngredienteAcceptate.get("condimente"); //o lista de stringuri cu condimente
            ObjectMapper mapperCondimente = new ObjectMapper();
            List<Condiment> listaCondimenteObj = new ArrayList<>(); //Lista in care vreau sa salvez obiectele Condiment

            for (String i : listaCondimenteString) {
                Condiment condiment = mapperCondimente.readValue(i, Condiment.class);
                listaCondimenteObj.add(condiment);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void convertJSONtoLegumaObjects() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/Recipes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject listaIngredienteAcceptate = (JSONObject) jsonObject.get("ingrediente_acceptate");
            List<String> listaLegumeString = (List<String>) listaIngredienteAcceptate.get("legume");
            ObjectMapper mapperLegume = new ObjectMapper();
            List<Leguma> listaLegumeObj = new ArrayList<>(); //Lista in care vreau sa salvez obiectele Legume

            for (String i : listaLegumeString) {
                Leguma leguma = mapperLegume.readValue(i, Leguma.class);
                listaLegumeObj.add(leguma);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static void convertJSONtoLactateObjects() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/Recipes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject listaIngredienteAcceptate = (JSONObject) jsonObject.get("ingrediente_acceptate");
            List<String> listaLactateString = (List<String>) listaIngredienteAcceptate.get("lactate");
            ObjectMapper mapperLactate = new ObjectMapper();
            List <Lactate> listaLactateObj = new ArrayList<>(); //Lista in care vreau sa salvez obiectele lactate

            for(String i : listaLactateString){
                Lactate produsLactat = mapperLactate.readValue(i, Lactate.class);
                listaLactateObj.add(produsLactat);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}

