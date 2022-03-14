package com.se.recipe_advisor.Models;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Reteta {
    private String nume;
    private int id;
    private int timp_preparare;
    private int numar_portii;
    private String dificultate;
    private boolean vegetarian;
    private String mod_preparare;
    private Compozitie c1;
}
