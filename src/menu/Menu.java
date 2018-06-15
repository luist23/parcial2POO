/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class Menu {
    private static Menu menu;
    private Menu(){
    }
    
    public static Menu getInstance(){
        if (menu==null){
            menu = new Menu();
        }
        return menu;
    }
    
    private static void opciones(){
        System.out.println("1. jugar");
        System.out.println("2. salir");
    }
    
    public static void mostrar(){
        //Utils.clear();
        int opcion=0;
        while(opcion!=2){
            System.out.println("---------Menu principal----------");
            opciones();
            opcion = Utils.pedirEntero("ingrese una opcion valida",1,2);
            
            switch(opcion){
                case 1:
                    //System.out.println("sub-menu jugar");
                    MenuJugar.mostrar();
                    opcion=2;
                    break;
                case 2:
                    System.out.println("Gracias por jugar :v... adios");
                    break;
                default:
                    Utils.clear();
                    System.out.println("opcion no valida");
                    
            }
    }}
    
    
}
