/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Builders.BuilderFortaleza;
import Factorys.Razas;
import Player.Player1;
import Player.Player2;
import java.util.Scanner;
import utils.Utils;


public class MenuJugar {
    private static MenuJugar menu;
    private MenuJugar(){
    }
    
    public static MenuJugar getInstance(){
        if (menu==null){
            menu = new MenuJugar();
        }
        return menu;
    }
    
    private static void opciones(){//-----oppciones del menu------
        System.out.println("1. continuar");
        System.out.println("2. salir");
    }
    
    public static void mostrar(){
        
        Utils.clear();
        System.out.println("eligiran sus razas respectivas cada una con diferentes fortalezas");
        System.out.println("el juego es por turnos uno despues del otro  :v");
        System.out.println("Que lo disfruten");
        Utils.stop();
        Utils.clear();
        Scanner leer=new Scanner(System.in);//iniciando scanner
        //------definiendo jugador 1--------
        System.out.println("ingrese nombre jugador 1");
        Player1.setNombre(leer.nextLine());
        Player1.setRaza(opcionRaza());
        Utils.clear();
        //------definiendo jugador 2--------
        System.out.println("ingrese nombre jugador 2");
        Player2.setNombre(leer.nextLine());
        Player2.setRaza(opcionRaza());
        //-------definiendo ultima obcion de no jugar :v------
        int opcion =0;
        //------mostrando menu para decidir continuar o retirarse--------
        while(opcion!=2){
            Utils.clear();
            System.out.println("---------Menu principal----------");
            opciones();
            opcion = Utils.pedirEntero("ingrese una opcion");
            
            switch(opcion){
                case 1://--------dando inicio al juego----------
                    System.out.println("sub-sub-menu jugar");
                    MenuGuiaPartida.mostrar();////////iniciar juego!!!!!!!!!!!!!!!!!
                    opcion=2;
                    break;
                case 2://------arrepintidose de jugar :´v------
                    System.out.println("Gracias por jugar :v... adios");
                    break;
                default:
                    Utils.clear();
                    System.out.println("opcion no valida");
                    
            }
    }
        
    }
    
    private static Razas opcionRaza(){
        //--------Elijiendo raza----------
        System.out.println("*** elija una raza ***");
        int i=1,j=0;    boolean e=true;  Razas raza=Razas.RAZA1;
        
        while(e){
            
        for ( Razas r:Razas.values()){//-------mostrando las razas existentes-------
            if(j==0)System.out.println(i+". "+r+BuilderFortaleza.getFortaleza(r).toString());//-----se muestra la raza la primera vez-----
            
            //-------ya mostradas las razas y seleccionada una opcion en pocicion de una raza existente... 
            //se guarda la raza seleccionada-------
            if(i==j){
                raza=r;
                e=false;}
            i++;
            
        }
        if(j==0){//-------se pide una eleccion en el rango valido... de 1 al numero de razas existentes-----
                j=Utils.pedirEntero("ingrese su eleccion",1,i-1);
                i=1;}
        }
        //------se retorna la raza-------
        System.out.println("selecciono: "+raza+BuilderFortaleza.getFortaleza(raza).toString());
        return raza;
    }
    
    
}