/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

/**
 *
 * @author LuisT23
 */
public class FactoryProducer {
    public static Factory getFatory(int opcion){
        switch(opcion){
            case 1:
                return new miliciaFactory();
            case 2:
                return new vehiculoFactory();
            case 3:
                return new EdificioFactory();
                
        }return null;
    }
    
}
