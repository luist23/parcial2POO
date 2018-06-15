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
public class Player2 {
    private static String nombre;
    private static Razas raza;
    private static CentroDeMando th;
    private static Fortaleza fortaleza;
    private static Player2 jugador;
    
    private Player2(){}
    
    public static Player2 getInstance(){
        if (jugador==null)
            jugador=new Player2();
        return jugador;}
    
    
    public static void setNombre(String nombre){
        Player2.nombre=nombre;
    }
    
    public static void setRaza(Razas raza){
        Player2.raza=raza;
        Player2.fortaleza=BuilderFortaleza.getFortaleza(raza);
        Player2.th=new CentroDeMando(5000,raza);
        th.setRecursos(1000, 600, 300);
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