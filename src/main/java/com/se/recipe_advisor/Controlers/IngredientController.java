package com.se.recipe_advisor.Controlers;

import com.se.recipe_advisor.Models.Ingredient;
import com.se.recipe_advisor.Utils.ReadJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //allows the class to handle the requests made by the client.
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")

public class IngredientController {

    private ReadJSON readJson;
    private List<Ingredient> ingredientList;

    @GetMapping("/ingredients")
     public ResponseEntity <List<Ingredient>> getIngredient(){
        readJson=new ReadJSON();
        ingredientList=readJson.convertJSONtoIngredientObjects();
        return new ResponseEntity<>(ingredientList, HttpStatus.OK);

    }

    @PostMapping("/selectedIngredients")
    public ResponseEntity<List<Ingredient>> createSelectedIngredients(@RequestBody List<Ingredient> _selectedIngredients) {
        try {
            List<Ingredient> selectedIngredients = new ArrayList<>();
            selectedIngredients.addAll(_selectedIngredients);
            selectedIngredients.stream().forEach(x->System.out.println(x.getNume()));
            return new ResponseEntity<>(selectedIngredients, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
