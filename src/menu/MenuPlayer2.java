/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Player.Player1;
import Player.Player2;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class MenuPlayer2 {
    
    private static MenuPlayer2 menu;
    private static Player2 jugador;
    private static ArrayList<String> mensajes;
    private static ArrayList<String> mensajesEnemigos;
    
    
    private MenuPlayer2(){}
    public static MenuPlayer2 getInstance(){
        if (menu==null){
             menu= new MenuPlayer2();
             mensajes=new ArrayList<>();
             jugador=Player2.getInstance();
             mensajes.add("bienvenido!!!!   *"+jugador.getNombre()+"*");
        }
        
        return menu;
    }
    
    private static void mostrarMensajesImportantes(){
        
        if(!mensajes.isEmpty()){
        System.out.println("Mensajes Importantes para: "+jugador.getNombre());
        int i=1;
        for (String e:mensajes){
            System.out.println(i+". "+e);
            i++;
        }
            System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
            mensajes.clear();
        }}
    
    private static void opciones(){
        
        System.out.println("----------sus opciones----------");
        System.out.println("1. recoger recursos");//recursos tipo:1,2,3
        System.out.println("2. crear edificio");//mostrar edificioc a crear
        System.out.println("3. crear tropa");//mostrar edificios de tropas disponibles para crear
        System.out.println("4. crear vehiculo");//mostrar edificios de vehiculos disponibles
        System.out.println("5. mostrar edificios");//constriccion----disponibles
        System.out.println("6. mostrar unidades");//unidades disponibles(casa//en Camino//en territorio enemigo----en elaboracion
        System.out.println("7. mostrar vehiculos");//disponibles(casa//camino//territorioEnemigo)----elaboracion
        System.out.println("8. atacar");//seleccione unidad para atacar----atacar tropas enemigas//edificiosenemigos
        System.out.println("9. continuar");
        
    }
    
    
    public static void mostrar(boolean victoria){
        Utils.clear();
        System.out.println("-----Menu de opciones jugador: "+jugador.getNombre()+" -------");
        mostrarMensajesImportantes();
        if(victoria){
            
        int opcion=1;
        while(opcion!=9){
            opciones();
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 9);
        switch(opcion){
            case 1:
                //System.out.println("1. recoger recursos");//recursos tipo:1,2,3
                subMenuRecursos.mostrar(jugador.getCentroDeMando());
                Utils.clear();
                break;
            case 2:
                subMenuEdificios.mostrar(jugador.getCentroDeMando());//mostrar edificioc a crear
                Utils.clear();
                break;
            case 3:
                subMenuTropa.mostrar(jugador.getCentroDeMando());//mostrar edificios de tropas disponibles para crear
                Utils.clear();
                break;
            case 4:
                subMenuVehiculo.mostrar(jugador.getCentroDeMando());//mostrar edificios de vehiculos disponibles
                Utils.clear();
                break;
            case 5:
                subMenuEdificiosExitentes.mostrar(jugador.getCentroDeMando());//constriccion----disponibles
                Utils.clear();
                break;
            case 6:
                subMenuUnidadesExistentes.mostrar(jugador.getCentroDeMando());//unidades disponibles(casa//en Camino//en territorio enemigo----en elaboracion
                Utils.clear();
                break;
            case 7:
                subMenuVehiculosExistentes.mostrar(jugador.getCentroDeMando());//disponibles(casa//camino//territorioEnemigo)----elaboracion
                Utils.clear();
                break;
            case 8:
                subMenuAtacar.mostar(jugador.getCentroDeMando());//seleccione unidad para atacar----atacar tropas enemigas//edificiosenemigos
                break;
            case 9:
                System.out.println("---siguiente jugador---");
                break;

        }
    }
    }else{ 
            mostrarMensajesImportantes();
            System.out.println("---siguiente jugador---");}
        
    }

    public static ArrayList<String> getMensajes() {
        return mensajes;
    }
    public static void setMensajesEnemigos(ArrayList<String> mensajes){
        mensajesEnemigos=mensajes;
    }
}