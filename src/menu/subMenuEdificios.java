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
import static menu.subMenuRecursos.opciones;
import static menu.subMenuRecursos.recolectar;
import static oracle.jrockit.jfr.events.Bits.intValue;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuEdificios {
    //private static void 
    private static void opciones(){
        System.out.println("1. edificio recursos");
        System.out.println("2. edificio de milicia");
        System.out.println("3. edificio de vehiculo");
        System.out.println("4. mejorar centro de mando");
        System.out.println("5. regresar");
    }
    private static void opcionesRecursos(Razas raza,Fortaleza fortaleza,Factory factory,CentroDeMando th){
        System.out.println(th.recursosToSting());
        
        Edificio a=factory.getEdificio(edificioType.RECURSO1, raza, fortaleza);
        System.out.println("1. edificio "+a.costoToString());
        
        a=factory.getEdificio(edificioType.RECURSO2, raza, fortaleza);
        System.out.println("2. edificio "+a.costoToString());
        
        a=factory.getEdificio(edificioType.RECURSO3, raza, fortaleza);
        System.out.println("3. edificio "+a.costoToString());
        
        System.out.println("4. regresar");
        
    }
    
    
    private static void OpcionesMilicia(Razas raza,Fortaleza fortaleza,Factory factory,CentroDeMando th){
        System.out.println(th.recursosToSting());
        Edificio a=factory.getEdificio(edificioType.MILICIA, raza, fortaleza);
        System.out.println("1. construir edificio de "+a.costoToString());
        System.out.println("2. regresar");
    }
    
    private static void opcionesVeehiculos(Razas raza,Fortaleza fortaleza,Factory factory,CentroDeMando th){
        System.out.println(th.recursosToSting());
        
        Edificio a=factory.getEdificio(edificioType.VEHICULO1, raza, fortaleza);
        System.out.println("1. edificio "+a.costoToString());
        
        a=factory.getEdificio(edificioType.VEHICULO2, raza, fortaleza);
        System.out.println("2. edificio "+a.costoToString());
    
        System.out.println("3. regresar");
        
        
    }
    
    private static void Vehiculo(CentroDeMando th,Razas raza,Fortaleza fortaleza,Factory factory){
        
        int opcion=0;
        while(opcion!=3){
            Utils.clear();
            System.out.println("-----Que edificio de vehiculo desea crear-----");
            opcionesVeehiculos(raza,fortaleza,factory,th);
            Edificio a=null;
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 3);
        switch(opcion){
            case 1:
                a=factory.getEdificio(edificioType.VEHICULO1, raza, fortaleza);
                break;
                case 2:
                a=factory.getEdificio(edificioType.VEHICULO2, raza, fortaleza);
                break;
                
        }
        if(a!=null){
            
         if(th.elaborar(a.getCosto()[0], a.getCosto()[1], a.getCosto()[2])){
                th.edificaciones.add(a);
                th.elaborar(a.getCosto());
                    System.out.println("edificio creado");
                    
                    
                }else System.out.println("recursos insuficientes para crear edificio");       
        }if(opcion!=3)Utils.stop();
        }
    }
    
    private static void milicia(CentroDeMando th,Razas raza,Fortaleza fortaleza,Factory factory){
        int opcion=0;
        while(opcion!=2){
            Utils.clear();
            System.out.println("-------edificio militar--------");
            OpcionesMilicia(raza, fortaleza, factory,th);
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 2);
            if (opcion==1){
                Edificio a=factory.getEdificio(edificioType.MILICIA, raza, fortaleza);
                if(th.elaborar(a.getCosto()[0], a.getCosto()[1], a.getCosto()[2])){
                th.edificaciones.add(a);
                th.elaborar(a.getCosto());
                    System.out.println("edificio creado");
                    
                    
                }else System.out.println("recursos insuficientes para crear edificio");       
        
            }
            if(opcion!=2)Utils.stop();
        }
        
    }
    private static void recursos(CentroDeMando th,Razas raza,Fortaleza fortaleza,Factory factory){
        
        
        int opcion=0;
        while(opcion!=4){
            Utils.clear();
            System.out.println("-----Que edificio de recursos desea crear-----");
            opcionesRecursos(raza,fortaleza,factory,th);
            Edificio a=null;
            opcion=Utils.pedirEntero("ingrese su opcion", 1, 4);
        switch(opcion){
            case 1:
                a=factory.getEdificio(edificioType.RECURSO1, raza, fortaleza);
                break;
                case 2:
                a=factory.getEdificio(edificioType.RECURSO2, raza, fortaleza);
                break;
                case 3:
                a=factory.getEdificio(edificioType.RECURSO3, raza, fortaleza);
                break;
                
        }
        if(a!=null){
            
         if(th.elaborar(a.getCosto()[0], a.getCosto()[1], a.getCosto()[2])){
                th.edificaciones.add(a);
                th.elaborar(a.getCosto());
                    System.out.println("edificio creado");
                    
                    
                }else System.out.println("recursos insuficientes para crear edificio");       
        }if(opcion!=4)Utils.stop();
        }
    }
    
    public static void mostrar(CentroDeMando th){
        
        
        //-------------obteniendo la raz, fortaleza y la fabrica----------
        Razas raza=th.getRaza();
        Fortaleza fortaleza=th.getFortaleza();
        Factory factory;
        factory = FactoryProducer.getFatory(3);
        //----------------------------------------------------------------
        
        
        int opcion = 1;
        while (opcion!=5){
            Utils.clear();
            System.out.println("--------------Que edificio desea crear-----------");
            opciones();
            opcion=Utils.pedirEntero("ingrese su opcion",1,5);
            switch(opcion){
                case 1:
                    recursos(th,raza,fortaleza,factory);
                    break;
                case 2:
                    milicia(th,raza,fortaleza,factory);
                    break;
                case 3:
                    Vehiculo(th, raza, fortaleza, factory);
                    break;
                case 4:
                    
                    centroMando(th);
                    break;
            }
            
            
        }





    }

    private static void centroMando(CentroDeMando th) {
        Utils.clear();
        System.out.println("-----------mejorar centro de mando-----------");
        th.recursosToSting();
        th.toString();
        System.out.println("costo:  {"+0.25*th.maxRe1+"  "+edificioType.RECURSO1+",  "+0.25*th.maxRe2+"  "+edificioType.RECURSO2+", "
                +0.25*th.maxRe3+"  "+edificioType.RECURSO3+" }");
        System.out.println("1. continuar");
        System.out.println("2. regresar");
        int opcion=Utils.pedirEntero("ingrese opcion", 1, 2);
        if(opcion==1){
            th.levelUp();
        }
        Utils.stop();
        
        
        
        
    }

}
