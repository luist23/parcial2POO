/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.Factory;
import Factorys.FactoryProducer;
import Factorys.MiliciaType;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import java.util.Scanner;
import static menu.subMenuRecursos.opciones;
import static menu.subMenuRecursos.recolectar;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuTropa {
    
    
    
    private static void opciones(CentroDeMando th){
        
        Razas raza=th.getRaza();
        Fortaleza fortaleza=th.getFortaleza();
        Factory factory;
        factory = FactoryProducer.getFatory(1);
        
        Milicia a=factory.getMilicia(MiliciaType.ECUADRON, raza, fortaleza);
        
        System.out.println(th.recursosToSting());
        System.out.println("1. crear nuevo : "+a.costoToString());
        a=factory.getMilicia(MiliciaType.ESPECIALISTA, raza, fortaleza);
        System.out.println("2. crear nuevo: "+a.costoToString());
        //System.out.println("3. recolectar: "+edificioType.RECURSO3);
        System.out.println("3. regresar");
    }
    
    
    
    private static Edificio edificioCreador(CentroDeMando th){
        Utils.clear();
        int recursos=0;
        System.out.println("edificios existentes para la creacion");
        for (Edificio e:th.edificaciones ){
            if(e.getType()==edificioType.MILICIA){
                System.out.println("");
                if(e.getDetectable()){
                    System.out.println((recursos+1)+". Contiene: "+e.getElementos());
                recursos++;}
                
            }
        }
        if(recursos!=0){
            //Utils.clear();
        recursos=Utils.pedirEntero("ingrese el edificio con el que desea crear", 0, recursos);
        int i=1;
        for (Edificio e:th.edificaciones ){
            if(e.getType()==edificioType.MILICIA){
                System.out.println("");
                if(e.getDetectable()){
                    if (i==recursos)
                        return e;
                }
                
            }
        }}
        
            System.out.println("no hay ningun edificio de milicia");
            System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
        return null;
        
    }
    
    private static void crearEscuadron(CentroDeMando th){
        Edificio e=edificioCreador(th);
        if(e!=null){
            e.generarTropa(th.getRaza(), th.getFortaleza(), 1,th);
            
            Utils.stop();
        }
    }
    
    private static void crearEspecialista(CentroDeMando th){
        
        if (th.especialista!=null) {
                
                System.out.println("ya tienes un especialista");
                System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
                
            }
        else{
        Edificio e=edificioCreador(th);
        if(e!=null){
            e.generarTropa(th.getRaza(), th.getFortaleza(), 2,th);
            //e.getCosto();
            //System.out.println("especialista creado");
            System.out.println("precione una 'ENTER' para continuar");
            Scanner leer=new Scanner(System.in);
            leer.nextLine();
        }
    }}
    
    public static void mostrar(CentroDeMando th){
        //Utils.clear();
        int opcion=0;
        
        
        
        while(opcion!=3){
            Utils.clear();
            System.out.println("-----Que milicia desea crear-----");
        opciones(th);
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 3);
        switch(opcion){
            case 1:
                Utils.clear();
                crearEscuadron(th);
                break;
                case 2:
                    Utils.clear();
                    crearEspecialista(th);
                break;
                
        }
                
        }
    }
}
