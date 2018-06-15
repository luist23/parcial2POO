/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luistrujillo.s.world;

import Factorys.MiliciaType;
import Milicia.miliciaAbstract.Milicia;
import Milicia.miliciaConcret.EscuadronRaza1;
import Player.Player1;
import Player.Player2;
import java.util.ArrayList;
import menu.Menu;

/**
 *
 * @author LuisT23
 */
public class LuisTrujilloSWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //-------Inicializando Jugadores-------
        Player1 jugador1=Player1.getInstance();
        Player2 jugador2=Player2.getInstance();
        //-------------------------------------
        
        
        /*
        Milicia milicia;
        EscuadronRaza1 miliciaVida;
        milicia = new EscuadronRaza1();
        miliciaVida=(EscuadronRaza1) milicia;
        miliciaVida.vida=1000;
        System.out.println(miliciaVida.vida);
        ArrayList<Integer> entero=new ArrayList<>();
        int enterito[]= new int[3];
        enterito[1]=1;
        enterito[2]=2;
        System.out.println(MiliciaType.ESCUADRONRAZA1);
        */
        
        
        
        //------mostrando menu----------
        Menu.mostrar();
        //------------------------------
        
        
        
        System.out.println(Player1.getNombre());
        System.out.println(jugador1.getRaza());
        System.out.println(jugador2.getNombre());
        System.out.println(Player2.getRaza());
    }
    
}
