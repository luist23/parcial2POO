/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Edificio.EdificioAbstract.Edificio;
import Factorys.Razas;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class BuilderEdificioVehiculo1 {
   private static int costo1,costo2,costo3;
   private static int vida;
   private static int tiempo;
    
    public static Edificio getEdificio(Edificio e,Razas raza,Fortaleza fortaleza){
        
        //---------------Valores iniciales del edificio-----------------
        costo1=0;costo2=250;costo3=100;
        vida=320;
        tiempo=3;
        //--------------------------------------------------------------
        
        
        //---------------Builder Edificio----------------
        e.setVida(intValue(vida*fortaleza.vida));
        e.setEspera(tiempo+fortaleza.construccion);
        e.setCosto(intValue(costo1*fortaleza.costo), intValue(costo2*fortaleza.costo), intValue(costo3*fortaleza.costo));
        e.setDetectable(false);
        e.setInmortal(false);
        e.setRaza(raza);
        //e.setTazaRecurso(100);
        return e;
        //-----------------------------------------------
    
    }
    
}
