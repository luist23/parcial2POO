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
import static Builders.BuilderVehiculo1.vida;
import VehiculoAbstarct.Vehiculo;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class BuilderVehiculo2 {
    public static int vida;
    public static int ataqueMilicia;
    public static int ataqueVehiculo;
    public static int ataqueEdificio;
    public static int costo1;
    public static int costo2;
    public static int costo3;
    public static int tiempoespera;
    private static BuilderVehiculo2 builder;
    private BuilderVehiculo2(){}
    
    public static BuilderVehiculo2 getInstance(){
        if (builder==null){
            builder=new BuilderVehiculo2();
        }
        return builder; 
    }
    
    public static Vehiculo getVehiculo(Vehiculo vehiculo,Fortaleza fortaleza){
        
        
        
        //---------------Valores iniciales del edificio-----------------
        costo1=200;costo2=200;costo3=250;
        ataqueEdificio=200;ataqueMilicia=100;ataqueVehiculo=90;
        vida=150;
        tiempoespera=3;
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