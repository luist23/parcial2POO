/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Builders.BuilderFortaleza;
import Builders.Fortaleza;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.Razas;

/**
 *
 * @author LuisT23
 */
public class Player1 {
    private static String nombre;
    private static Razas raza;
    private static CentroDeMando th;
    private static Fortaleza fortaleza;
    private static Player1 jugador;
    
    private Player1(){}
    
    public static Player1 getInstance(){
        if (jugador==null)
            jugador=new Player1();
        return jugador;}
    
    
    public static void setNombre(String nombre){
        Player1.nombre=nombre;
    }
    
    public static void setRaza(Razas raza){
        Player1.raza=raza;
        Player1.fortaleza=BuilderFortaleza.getFortaleza(raza);
        Player1.th=new CentroDeMando(5000,raza);//----vida
        th.setRecursos(1000, 700, 300);//----recursos incialies
        th.setRaza(raza);
    }
    
    public static String getNombre(){
        return nombre;
    }
    public static Razas getRaza(){
        return raza;
    }
    public static CentroDeMando getCentroDeMando(){
        return th;
    }
}
