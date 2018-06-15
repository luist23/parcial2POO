/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

/**
 *
 * @author LuisT23
 */
public class Fortaleza {
    int construccion;
    double fuerza;
    double costo;
    double vida;

    @Override
    public String toString() {
        return "  Fortaleza{" + "construccion= " + construccion + "  tiempo , fuerza= " + fuerza*100 + "% , costo= " + costo*100 + "% , vida= " + vida*100 +"% "+ '}';
    }
    
}
