package com.se.recipe_advisor.Controlers;

import com.se.recipe_advisor.Models.Ingredient;
import com.se.recipe_advisor.Models.Reteta;
import com.se.recipe_advisor.Utils.CreateRules;
import com.se.recipe_advisor.Utils.ReadJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")

public class RetetaController {  //clasa ce urmeaza a fi modificata pentru a trimite spre front-end doar retele care corespund ingredientelor selectate;

    private ReadJSON readJson;
    private List<Reteta> recipeList;

    @GetMapping("/recipes")
    public ResponseEntity<List<Reteta>> getIngredient(){
        readJson=new ReadJSON();
        recipeList= CreateRules.masinaInferenta();
        return new ResponseEntity<>(recipeList, HttpStatus.OK);

    }

}
