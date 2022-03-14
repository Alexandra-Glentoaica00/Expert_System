package com.se.recipe_advisor.Models;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Compozitie {
    List<Leguma> lista_legume;
    List<Fruct> lista_fructe;
    List<Condiment> lista_condimente;
    List<Lactate> lista_lactate;
}
