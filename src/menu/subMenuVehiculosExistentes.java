/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuVehiculosExistentes {////-.---------cambiar
    
    private static void opciones(){
        System.out.println("1. vehiculos operando");
        System.out.println("2. vehiculos en construccion");
        System.out.println("3. regresar");
    }
    private static void unidadesDesplegadas(CentroDeMando th){
        //Utils.clear();
        int recursos=0;//System.out.println("edificio creador");
        for (Edificio e:th.edificaciones ){
            if(e.getType()==edificioType.VEHICULO1 || e.getType()==edificioType.VEHICULO2){
                //System.out.println("");
                if(e.getDetectable()){
                    System.out.println((recursos+1)+". Contiene: "+e.getElementos());
                recursos++;}
                
            }
        }
        /*int i=1;
        int recursos=1;
        for (Edificio e:th.edificaciones ){
            if(e.getType()==vehiculo){
                //System.out.println("");
                if(e.getDetectable()){
                    System.out.println((recursos+1)+". Contiene: "+e.getElementos());
                recursos++;}
                
            }
        }
        for (Edificio e:th.edificaciones){
            
            
            
            
            if(!e.getDetectable()){
                if(e.getType()==edificioType.VEHICULO1){
                String a="";
                a=i+". "+e.getType()+"cuenta con "+e.getElementos();
            
            
            
            a=a+", vida: "+e.getVida();
            System.out.println(i+". "+a);   
            i++;}
            if(e.getType()==edificioType.VEHICULO2){
                String a="";
                a=i+". "+e.getType()+"cuenta con "+e.getElementos();
            
            
            
            a=a+", vida: "+e.getVida();
            System.out.println(i+". "+a);   
            i++;
                }}}
        int k=0;
        for (Vehiculo es:th.vehiculo){
            k++;
        }*/
        if(recursos==0)System.out.println("no hay edificio con vehiculos");
        //if(k==0)System.out.println("no hay vehiculos desplegados");
        //else   System.out.println("hay "+k+"vehiculos desplegados");
        Utils.stop();
    }
    
    private static void unidadesEdificios(CentroDeMando th){int i=1;
        for (Edificio e:th.edificaciones){
            
            
            if(e.getDetectable()){
                String a="";
                a=a+"  construyendose ";
            
            
            
            a=a+" vida: "+e.getVida();
            System.out.println(i+". "+a);    
            i++;}
        }
        if(i==1)System.out.println("no hay vehiculos en construccion ");
        Utils.stop();
    }
    
    public static void mostrar(CentroDeMando th){
        int opcion=1;
        unidadesDesplegadas(th);
        //Utils.stop();
        
        
        
        /*
        while(opcion!=3){
            Utils.clear();
            System.out.println("-----------mostrar tropas-----------");
            opciones();
            opcion=Utils.pedirEntero("ingrese su opcion ", 1, 3);
            switch(opcion){
                case 1:
                    unidadesDesplegadas(th);
                    break;
                case 2:
                    //unidadesEdificios(th);
                    break;
                    
            }
        }*/
    }
    
}
