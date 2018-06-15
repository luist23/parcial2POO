/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuRecursos {
    //private static ArrayList<Edificio> edificio;
    public static void opciones(){
        System.out.println("1. recolectar: "+edificioType.RECURSO1);
        System.out.println("2. recolectar: "+edificioType.RECURSO2);
        System.out.println("3. recolectar: "+edificioType.RECURSO3);
        System.out.println("4. regresar");
    }
    
    public static void mostrar(CentroDeMando th){
        Utils.clear();
        int opcion=0;
        System.out.println("-----Que recursos desea recolectar-----");
        opciones();
        
        
        while(opcion!=4){
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 4);
        switch(opcion){
            case 1:
                recolectar(th, edificioType.RECURSO1);
                break;
                case 2:
                recolectar(th, edificioType.RECURSO2);
                break;
                case 3:
                recolectar(th, edificioType.RECURSO3);
                break;
        }
                
        }
    }
    
    public static void recolectar(CentroDeMando th,edificioType type){
        int recursos=0;
        for (Edificio e:th.edificaciones ){
            if(e.getType()==type){
                System.out.println("");
                if(e.getDetectable()){
                e.recogerRecurso(th);//System.out.println("recursos recogidos");
                recursos++;}
                
            }
        }
        if (recursos == 0) {
            System.out.println("no hay ningun edificio con este recurso");
        }
    }
    
}
