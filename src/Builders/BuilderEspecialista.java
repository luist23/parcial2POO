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
import static Builders.BuilderVehiculo2.vida;
import Milicia.miliciaAbstract.Milicia;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class BuilderEspecialista {
    public static int vida;
    public static int ataqueMilicia;
    public static int ataqueVehiculo;
    public static int ataqueEdificio;
    public static int costo1;
    public static int costo2;
    public static int costo3;
    public static int tiempoespera;
    private static BuilderEspecialista builder;
    private BuilderEspecialista(){}
    
    public static BuilderEspecialista getInstance(){
        if (builder==null){
            builder=new BuilderEspecialista();
        }
        return builder; 
    }
    
    public static Milicia getEspecialista(Milicia especialista,Fortaleza fortaleza){
        
        
        
        
        //---------------Valores iniciales del edificio-----------------
        costo1=300;costo2=250;costo3=100;
        ataqueEdificio=150;ataqueMilicia=70;ataqueVehiculo=80;
        vida=120;
        tiempoespera=3;
        //--------------------------------------------------------------
        
        
        
        
        especialista.setAtaque(intValue(ataqueMilicia*fortaleza.fuerza), intValue(ataqueVehiculo*fortaleza.fuerza)
                , intValue(ataqueEdificio*fortaleza.fuerza));
        especialista.setCosto(intValue(costo1*fortaleza.costo), intValue(costo2*fortaleza.costo)
                , intValue(costo3*fortaleza.costo));
        if(tiempoespera+fortaleza.construccion>=1){
            especialista.setEspera(tiempoespera+fortaleza.construccion);
        }else especialista.setEspera(tiempoespera);
        especialista.setVida(intValue(vida*fortaleza.vida));
        return especialista;
    }
}
