/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.Factory;
import Factorys.FactoryProducer;
import Factorys.Razas;
import java.util.Scanner;
import static menu.subMenuRecursos.recolectar;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuEdificiosExitentes {
    
    //private static void 
    private static void opciones(){
        System.out.println("1. edificios Existentes");
        System.out.println("2. edificios en construccion");
        System.out.println("3. regresar");
    }
    private static void existentes(CentroDeMando th){
        int i=1;
        System.out.println(th.toString());
        for(Edificio e:th.edificaciones){
            if(e.getDetectable()){
                System.out.println(i+". "+e.toString());
                i++;
            }
        }
        if(i==1){
        System.out.println("no hay edificios elaborados");
        }
        Utils.stop();
        //System.out.println("existentes");
        
 
    }
    
    private static void inexistentes(CentroDeMando th){
        int i=1;//System.out.println("a revisar inexistentes :v");
        for(Edificio e:th.edificaciones){
            if(!e.getDetectable()){
                System.out.println(i+". "+e.toString());
                i++;
            }
        }
        if(i==1){
        System.out.println("no hay edificios construyendose");
        }
        Utils.stop();
        //System.out.println("inexistentes");
    }
    
    
    public static void mostrar(CentroDeMando th){
        int opcion=0;
        while(opcion!=3){
            Utils.clear();
            System.out.println("--------mostar edificios------");
            opciones();
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 3);
            
        
        switch(opcion){
            case 1:
                existentes(th);
                break;
            case 2:
                inexistentes(th);
                break;
                
        }
        }




    }

}

