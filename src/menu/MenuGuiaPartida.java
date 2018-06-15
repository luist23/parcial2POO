/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Edificio.EdificioConcret.CentroDeMando;
import Milicia.miliciaAbstract.Milicia;
import Player.Player1;
import Player.Player2;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public class MenuGuiaPartida {
    private static MenuPlayer1 jugador1;
    private static MenuPlayer2 jugador2;
    private static CentroDeMando th1;
    private static CentroDeMando th2;
    
    private MenuGuiaPartida(){}
    
    private static boolean ganador() {
        if (th1.vida <= 0 || th2.vida <= 0) {

            if (th1.vida <= 0) {
                System.out.println("-----victoria Jugador: " + Player1.getNombre());
            } else {
                System.out.println("-----victoria Jugador: " + Player2.getNombre());
            }
            jugador1.mostrar(false);
            //jugador2.mostrar(false);
            return false;
        }
        return true;
    }
    
    private static void generarrecursos(){
        th1.setRecursos(30, 20, 0);
        th2.setRecursos(30, 20, 0);
    }
    
    public static void mostrar(){
        System.out.println("*************A HACERSE CON EL TERRITORIO!!!!!!!!!*********");
        th1=Player1.getCentroDeMando();
        th2=Player2.getCentroDeMando();
        th1.setEnemigos(th2.milicia, th2.vehiculo, th2.edificaciones);
        th2.setEnemigos(th1.milicia, th1.vehiculo, th1.edificaciones);
        th1.thEnemigo=th2;
        th2.thEnemigo=th1;
        
        jugador1=MenuPlayer1.getInstance();
        jugador2=MenuPlayer2.getInstance();
        
        //---------------para los mensajes--------;v
        jugador1.setMensajesEnemigos(jugador2.getMensajes());
        jugador2.setMensajesEnemigos(jugador1.getMensajes());
        
        boolean jugando=true;
        //boolean juego=true;
        
        //---------------------------Control de Juego------------------------------------------------
        while(jugando){
            jugando=ganador();//-----revisar si na a habido un perdedor-----
            jugador1.mostrar(jugando);
            jugador2.mostrar(jugando);
            //jugando=ganador();//-----revisar si na a habido un perdedor-----
            generarrecursos();//-----recoger recursos que no dependen de edificaciones------
            th1.setFase(jugador1.getMensajes());
            th2.setFase(jugador2.getMensajes());
            //ArrayList <String> a=new ArrayList<> ();
            faseAtacar(jugador1.getMensajes(),jugador2.getMensajes(),th1,th2);
            //if(th1.vida<=0 || th2.vida<=0)jugando=false;
        }
        
        //if(th1.vida<=0)System.out.println("victoria para "+jugador2.getNombre());
        //--------------------------------------------------------------------------------------------
    }
    
    private static void faseAtacar(ArrayList<String> mensaje1,ArrayList<String> mensaje2,CentroDeMando th1,CentroDeMando th2){
        for (Milicia e:th1.milicia){
            if(e.getDetectable()){
           e.atacar(mensaje1, mensaje2, true);}
        }
        for (Milicia a:th2.milicia){
            if(a.getDetectable()){
           a.atacar(mensaje2, mensaje1, true);}
        }
        for (Vehiculo b:th1.vehiculo){
            if(b.getDetectable()){
           b.atacar(mensaje1, mensaje2, true);}
        }
        for (Vehiculo c:th2.vehiculo){
            if(c.getDetectable()){
           c.atacar(mensaje2, mensaje1, true);}
        }
        
        th1.setAtaque(mensaje1, mensaje2);
        th2.setAtaque(mensaje2, mensaje1);
        
        for (Milicia e:th1.milicia){
            if(e.getDetectable())
           e.atacar(mensaje1, mensaje2, false);
        }
        for (Milicia e:th2.milicia){
            if(e.getDetectable()){
           e.atacar(mensaje2, mensaje1, false);}
        }
        for (Vehiculo e:th1.vehiculo){
            if (e.getDetectable()){
           e.atacar(mensaje1, mensaje2, false);}
        }
        for (Vehiculo e:th2.vehiculo){
            if(e.getDetectable()){
           e.atacar(mensaje2, mensaje1, false);}
        }
    }
    
}
