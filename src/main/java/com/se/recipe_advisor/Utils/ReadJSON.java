package com.se.recipe_advisor.Utils;

import com.se.recipe_advisor.Models.Fruct;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJSON {
    public static void f1() {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/resources/Recipes.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject=(JSONObject) obj;
            JSONObject ingredienteList= (JSONObject) jsonObject.get("ingrediente_acceptate");
            List<String> FructeObj = (List<String>) ingredienteList.get("fructe");
            List<Fruct> listaFructe=new ArrayList<>();
            for(String i:FructeObj){
                listaFructe.add(new Fruct(i));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
}

