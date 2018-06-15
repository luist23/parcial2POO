/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Milicia.miliciaAbstract.Milicia;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuUnidadesExistentes {
    
    private static void opciones(){
        System.out.println("1. unidades desplegadas");
        System.out.println("2. unidades en edificios");
        System.out.println("3. regresar");
    }
    private static void unidadesDesplegadas(CentroDeMando th){
        String a="";
        int i=1;
        for (Milicia e:th.milicia){
            if(e==th.especialista){
                a=a+" ESPECIALISTA";
            }else{
                a=a+" ECUADRON";
            }
            
            
            if(!e.getDetectable()){
                a=a+"  en camino, "+e.getTiempoEspera()+" fases de marcha";
            }
            else{
                a=a+"  en territorio enemigo, objetivo: "+e.getObjetivo();
            }
            a=a+", vida: "+e.getVida();
            System.out.println(i+". "+a);    
            i++;
        }
        if(i==1)System.out.println("no hay unidades Desplegadas");
        System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
        
    }
    
    private static void unidadesEdificios(CentroDeMando th){
        //String a="";
        int j=1;
        for (Edificio ed:th.edificaciones){
            if(ed.getType()==edificioType.MILICIA){
                System.out.println(j+". edificio "+ ed.getElementos());
                
        
        
    }}if(j==1)System.out.println("no hay edificios de unidades");
        System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
    }
    
    public static void mostrar(CentroDeMando th){
        int opcion=1;
        while(opcion!=3){
            Utils.clear();
            System.out.println("-----------mostrar tropas-----------");
            opciones();
            opcion=Utils.pedirEntero("ingrese su opcion ", 1, 3);
            switch(opcion){
                case 1:
                    unidadesDesplegadas(th);
                    break;
                case 2:
                    unidadesEdificios(th);
                    break;
                    
            }
        }
    }
    
}
