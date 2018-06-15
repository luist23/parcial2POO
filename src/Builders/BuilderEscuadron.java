/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;


import Milicia.miliciaAbstract.Milicia;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class BuilderEscuadron {
    public static int vida;
    public static int ataqueMilicia;
    public static int ataqueVehiculo;
    public static int ataqueEdificio;
    public static int costo1;
    public static int costo2;
    public static int costo3;
    public static int tiempoespera;
    private static BuilderEscuadron builder;
    private BuilderEscuadron(){}
    
    public static BuilderEscuadron getInstance(){
        if (builder==null){
            builder=new BuilderEscuadron();
        }
        return builder; 
    }
    
    public static Milicia getEscuadron(Milicia escuadron,Fortaleza fortaleza){
        
        
        //---------------Valores iniciales del edificio-----------------
        costo1=200;costo2=100;costo3=0;
        ataqueEdificio=100;ataqueMilicia=50;ataqueVehiculo=60;
        vida=75;
        tiempoespera=2;
        //--------------------------------------------------------------
        
        
        
        
        escuadron.setAtaque(intValue(ataqueMilicia*fortaleza.fuerza), intValue(ataqueVehiculo*fortaleza.fuerza)
                , intValue(ataqueEdificio*fortaleza.fuerza));
        escuadron.setCosto(intValue(costo1*fortaleza.costo), intValue(costo2*fortaleza.costo)
                , intValue(costo3*fortaleza.costo));
        if(tiempoespera+fortaleza.construccion>=1){
            escuadron.setEspera(tiempoespera+fortaleza.construccion);
        }else escuadron.setEspera(tiempoespera);
        escuadron.setVida(intValue(vida*fortaleza.vida));
        return escuadron;
    }
}
