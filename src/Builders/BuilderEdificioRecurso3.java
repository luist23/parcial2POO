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
public class BuilderEdificioRecurso3 {
   private static int costo1,costo2,costo3,taza;
   private static int vida;
   private static int tiempo;
    
    public static Edificio getEdificio(Edificio e,Razas raza,Fortaleza fortaleza){
        
        //---------------Valores iniciales del edificio-----------------
        costo1=400;costo2=270;costo3=0;
        vida=330;
        tiempo=3;taza=100;
        //--------------------------------------------------------------
        
        
        //---------------Builder Edificio----------------
        e.setVida(intValue(vida*fortaleza.vida));
        e.setEspera(tiempo+fortaleza.construccion);
        e.setCosto(intValue(costo1*fortaleza.costo), intValue(costo2*fortaleza.costo), intValue(costo3*fortaleza.costo));
        e.setDetectable(false);
        e.setInmortal(false);
        e.setRaza(raza);
        e.setTazaRecurso(taza);
        return e;
        //-----------------------------------------------
    
    }
    
}
