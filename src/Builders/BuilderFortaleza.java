/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Factorys.Razas;

/**
 *
 * @author LuisT23
 */
public class BuilderFortaleza {
    private BuilderFortaleza(){}
    public static Fortaleza getFortaleza(Razas raza){
        Fortaleza fortaleza=new Fortaleza();
        switch(raza){
            case RAZA1://tarda 1 fase menos
                fortaleza.construccion=-1;//menos una fase
                fortaleza.fuerza=1;
                fortaleza.costo=1;
                fortaleza.vida= 0.8; //menos vida
                break;
            case RAZA2:
                fortaleza.construccion=0;
                fortaleza.fuerza=1.2;//mas fuerza
                fortaleza.costo=1;
                fortaleza.vida= 0.8; //menos vida
                break;
            case RAZA3:
                fortaleza.construccion=1;//mas una fase
                fortaleza.fuerza=1.2;//mas fuerza
                fortaleza.costo=1.4;//mas costo
                fortaleza.vida= 1.2;//mas vida
                break;
                        
                    
        }
        return fortaleza;
    }
}
