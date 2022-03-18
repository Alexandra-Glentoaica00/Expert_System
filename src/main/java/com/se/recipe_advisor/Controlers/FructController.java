package com.se.recipe_advisor.Controlers;

import com.se.recipe_advisor.Models.Fruct;
import com.se.recipe_advisor.Utils.ReadJSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //allows the class to handle the requests made by the client.
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")

public class FructController {

    private ReadJSON readJson;
    private List<Fruct> listaFructe;

    @GetMapping("/fructe")
     public ResponseEntity <List<Fruct>> getFructe(){
        listaFructe=readJson.convertJSONtoFructObjects();
        return new ResponseEntity<>(listaFructe, HttpStatus.OK);

    }

}
