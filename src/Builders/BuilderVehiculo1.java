/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import static Builders.BuilderEscuadron.ataqueEdificio;
import static Builders.BuilderEscuadron.ataqueMilicia;
import static Builders.BuilderEscuadron.ataqueVehiculo;
import static Builders.BuilderEscuadron.costo1;
import static Builders.BuilderEscuadron.costo2;
import static Builders.BuilderEscuadron.costo3;
import static Builders.BuilderEscuadron.tiempoespera;
import static Builders.BuilderEscuadron.vida;
import static Builders.BuilderVehiculo2.vida;
import VehiculoAbstarct.Vehiculo;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class BuilderVehiculo1 {
    public static int vida;
    public static int ataqueMilicia;
    public static int ataqueVehiculo;
    public static int ataqueEdificio;
    public static int costo1;
    public static int costo2;
    public static int costo3;
    public static int tiempoespera;
    private static BuilderVehiculo1 builder;
    private BuilderVehiculo1(){}
    
    public static BuilderVehiculo1 getInstance(){
        if (builder==null){
            builder=new BuilderVehiculo1();
        }
        return builder; 
    }
    
    public static Vehiculo getVehiculo(Vehiculo vehiculo,Fortaleza fortaleza){
        
        
        
        
        //---------------Valores iniciales del edificio-----------------
        costo1=300;costo2=250;costo3=120;
        ataqueEdificio=150;ataqueMilicia=70;ataqueVehiculo=60;
        vida=100;
        tiempoespera=2;
        //--------------------------------------------------------------
        
        
        
        
        vehiculo.setAtaque(intValue(ataqueMilicia*fortaleza.fuerza), intValue(ataqueVehiculo*fortaleza.fuerza)
                , intValue(ataqueEdificio*fortaleza.fuerza));
        vehiculo.setCosto(intValue(costo1*fortaleza.costo), intValue(costo2*fortaleza.costo)
                , intValue(costo3*fortaleza.costo));
        if(tiempoespera+fortaleza.construccion>=1){
        vehiculo.setEspera(tiempoespera+fortaleza.construccion);}
        else vehiculo.setEspera(tiempoespera);
        vehiculo.setVida(intValue(vida*fortaleza.vida));
        return vehiculo;
    }
}