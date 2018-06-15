/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Builders.BuilderEscuadron;
import Builders.BuilderVehiculo1;
import Builders.BuilderVehiculo2;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.MiliciaType;
import Milicia.miliciaAbstract.Milicia;
import Milicia.miliciaConcret.EscuadronRaza1;
import Milicia.miliciaConcret.EspecialistaRaza1;
import VehiculoAbstarct.Vehiculo;
import VehiculosConcrect.Vehiculo1Raza1;
import VehiculosConcrect.Vehiculo2Raza1;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class subMenuAtacar {
    private static void opciones(){
        System.out.println("1. atacar edificio");
        System.out.println("2. atacar tropa");
        System.out.println("3. regresar");
    }
    
    
    private static void opcionesEdificio(CentroDeMando th){
        System.out.println("1. atacar centro de mando"+th.thEnemigo.vida);
        System.out.println("2. atacar edificios");
        System.out.println("3. regresar");
    }
    
    private static void opcionAtacante(CentroDeMando th){
        System.out.println("1. atacar con "+Builders.BuilderEscuadron.getEscuadron(EspecialistaRaza1.getInstance(th.raza), th.fortaleza).toString());
        System.out.println("2. atacar con "+BuilderEscuadron.getEscuadron(new EscuadronRaza1(th.raza),th.fortaleza).toString());
        System.out.println("3. atacar con "+BuilderVehiculo1.getVehiculo(new Vehiculo1Raza1(th.raza),th.fortaleza).toString());
        System.out.println("4. atacar con "+BuilderVehiculo2.getVehiculo(new Vehiculo2Raza1(th.raza),th.fortaleza).toString());
        System.out.println("5. regresar");
    }
    private static void atacar(CentroDeMando th, boolean tropaVehiculo, boolean tropa, boolean vehiculo){
        if(tropaVehiculo){//------------ataca tropa
            Milicia atacante=atacante(th,tropa);
            if(atacante!=null){
                opcionesEdificio(th);
                int opcion=Utils.pedirEntero("ingrese opcion", 1, 3);
                //-----------------------maldita sea muy largo!!!!!!!!!!  :v
                switch(opcion){
                    case 1:
                        if(!th.thEnemigo.inmortal){
                        atacante.asignarObjetivo(th.thEnemigo);
                        atacante.setEspera(2);
                        atacante.setDetectable(false);
                        System.out.println("centro de mando elejido como objetivo");}
                        else System.out.println("Centro de mando inaccesible");
                        break;
                    case 2:
                        Edificio ed=edificioEnemigo(th);
                        if(ed!=null){
                        atacante.asignarObjetivo(ed);
                        atacante.setEspera(2);
                        atacante.setDetectable(false);
                            System.out.println("edificcio elejido como objetivo");
                        }
                        break;
                    case 3:
                        Milicia mil=tropaEnemigo(th);
                        if(mil!=null){
                        atacante.asignarObjetivo(mil);atacante.setEspera(10);
                        atacante.setDetectable(false);
                            System.out.println("tropa elejida como objetivo");}
                        break;    
                }
                
                th.milicia.add(atacante);
                Utils.stop();
                
                
                
                
                
            }else{
                System.out.println("no fue posible atacar");
                Utils.stop();
            }
            
        }else{//---- ataca vehiculo
            
            Vehiculo atacante=Vatacante(th,vehiculo);
            if(atacante!=null){
                opcionesEdificio(th);
                int opcion=Utils.pedirEntero("ingrese opcion", 1, 3);
                //-----------------------maldita sea muy largo!!!!!!!!!!  :v
                switch(opcion){
                    case 1:
                        if(!th.thEnemigo.inmortal){
                        atacante.asignarObjetivo(th.thEnemigo);
                        atacante.setEspera(2);
                        atacante.setDetectable(false);
                        System.out.println("centro de mando elejido como objetivo");}
                        else System.out.println("Centro de mando inaccesible");
                        break;
                    case 2:
                        Edificio ed=edificioEnemigo(th);
                        if(ed!=null){
                        atacante.asignarObjetivo(ed);
                        atacante.setEspera(2);
                        atacante.setDetectable(false);
                            System.out.println("edificcio elejido como objetivo");
                        }
                        break;
                    case 3:
                        
                        Milicia mil=tropaEnemigo(th);
                        if(mil!=null){
                        atacante.asignarObjetivo(mil);atacante.setEspera(10);
                        atacante.setDetectable(false);
                            System.out.println("tropa elejida como objetivo");}
                        break;    
                }
                
                th.vehiculo.add(atacante);
                Utils.stop();
                
                
                
                
                
            }else{
                System.out.println("no fue posible atacar");
                Utils.stop();
            }
            
        }
        
        
        
        
        
        
    }
    
    private static Edificio edificioEnemigo(CentroDeMando th){
        Utils.clear();
        System.out.println("--------elija edificio a atacar--------------");
        int i=1;
        for(Edificio e:th.edificacionesEnemigo){
            if (e.getDetectable()){
                System.out.println(i+ ". "+e.toString());
                i++;
            }
        }
        if(i!=1){
            
        int opcion=Utils.pedirEntero("elija edificio enemigo",1, i-1);
        i=1;
        for(Edificio e:th.edificacionesEnemigo){
            if (e.getDetectable()){
                if(i==opcion)return e;
                i++;
            }
        }}else{
        System.out.println("no hay edificios ");}
        Utils.stop();
        return null;
        
    }
    
    private static Milicia tropaEnemigo(CentroDeMando th){
        Utils.clear();
        System.out.println("-----------seleccione tropa a atacar--------------");
        int i=1;
        for(Milicia e:th.miliciaEnemiga){
            if (e.getDetectable()){
                System.out.println(i+ ". "+e.toString());
                i++;
            }
        }
        int opcion=Utils.pedirEntero("elija tropa enemiga",1, i-1);
        for(Milicia e:th.miliciaEnemiga){
            if (e.getDetectable()){
                if(i-1==opcion)return e;
                i++;
            }
        }
        System.out.println("no hay tropas enemigas en fortaleza");
        Utils.stop();
        return null;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    private static Milicia atacante(CentroDeMando th, boolean opcion){//obcion= true retorna especialista, fales escuadron
        Utils.clear();
        if(opcion){ if(th.especialista!=null){ return th.especialista;}else System.out.println("no hay "+MiliciaType.ESPECIALISTA+" entrenado");
        }//devoviendo especilaista
        else{
 System.out.println("-----seleccione edfificio donde se almacena la tropa * o * tropa ya desplegada------");
        int i=mostrarEdificios(th, edificioType.MILICIA);//mostrando edificios disponibles de milicia
        System.out.println(i+". tropa ya en territorio enemigo");//opcion para elejir tropas ya desplegadas
        
            if(true){
                System.out.println((i+1)+". regresar");//brindando la opcion de regresar
            boolean tropa=true;
            while(tropa){ System.out.println("-----seleccione edfificio------");
                    int opcionn=Utils.pedirEntero("ingrese opcion", 1, i+1);

                    //------------------tropa ya desplegada------------------
                    if(opcionn==i){
                        int mm=1;
                        for(Milicia m:th.milicia){
                            if (m.getDetectable()==true){ System.out.println(i+". "+m.toString()); mm++;}}

                        if(mm!=1){
                        int opcionmm=Utils.pedirEntero("seleccione tropa a reasignar objetivo", 1, mm-1);
                        mm=1;
                        for(Milicia m:th.milicia){
                            if (m.getDetectable()==true){
                                if (mm==opcionmm)return m;
                                mm++;
                            }
                        }}else { System.out.println("no se encontraron tropas en territorio enemigo"); return null;}

                    }//---------------------------------------------------------

                    //--------------------tropa en edificios------------------------------------------------------------------------------------
                    if(opcionn==i+1){//opcion............................
                        System.out.println("regreando");
                        Utils.stop();
                        return null;//////--------------regresar.......
                    }

                    //----------------obtenniendo edificio seleccionado-----------
                    Edificio E=obtenerEdificio(opcionn, th, edificioType.MILICIA);
                    int edificioElejido=1;
                    for (Milicia s:E.getMilicias() ){//----------mostrando tropas disponobles en edificio--------
                        if(s.getDetectable()){
                            System.out.println(edificioElejido+". "+s.toString());
                            edificioElejido++;  
                        }}
                    if(edificioElejido!=1){//------------revisando si el edifico seleccionado cuenta con tropas--------
                        System.out.println("seleccione tropa");//----------si el edificico cuenta con tropa se pide seleccionar una tropa--------
                        int temp=Utils.pedirEntero("ingrese opcion", 1, edificioElejido-1);
                        int temp1=1;
                        for (Milicia s:E.getMilicias() ){
                        if(s.getDetectable()){
                            if(temp==temp1){
                                E.getMilicias().remove(s);
                                return s;//------se devuelve la tropa seleccionada------------}
                            }
                            temp1++;
                        }}
                    }else System.out.println("edificio no cuenta contropas entrenadas");//-------si el edificio no cuenta con tropa se pide seleccionar otro
                }}
            else{//-----------se advierte de la inexistencia de edificios con tropa-----------


                System.out.println("no hay edificios elaborados de "+edificioType.MILICIA);
            Utils.stop();
            }
                
        }
        return null;}
    
    
    
    /**
     * obtener edififcio de un typo especifico --- ya elaborado-----
     * @param i
     * @param th
     * @return 
     */
    private static Edificio obtenerEdificio(int i,CentroDeMando th, edificioType type){
        int j=1;
        for (Edificio e:th.edificaciones){
                if(e.getType()==type){
                    //System.out.println(i+". Edificio "+edificioType.MILICIA+" cuenta con "+e.getElementos());
                    if(j==i)return e;
                    j++;}}
        return null;}
    
    
    private static int mostrarEdificios(CentroDeMando th, edificioType type){
        int i=1;
        for (Edificio e:th.edificaciones){
                if(e.getType()==type){
                    System.out.println(i+". Edificio "+type+" cuenta con "+e.getElementos());
                    i++;}}
        if(i==1)System.out.println("no hay edificios enemigos");
        return i;}
    

    public static void mostar(CentroDeMando th) {
        
        int opcion=1;
        while(opcion!=5){
            Utils.clear();
            System.out.println("--------menu de ataques---------");
        opcionAtacante(th);
        opcion=Utils.pedirEntero("ingrese su opcion",1,5);
        switch(opcion){
            case 1:
                atacar(th,true,true,false);
                break;
            case 2:
                atacar(th,true,false,false);
                break;
            case 3:
                atacar(th,false,false,true);
                break;
            case 4:
                atacar(th,false,false,false);
                break;}}}
    
   
    
        
        



private static Vehiculo Vatacante(CentroDeMando th, boolean opcion){//obcion= true retorna especialista, fales escuadron
    Utils.clear();
        if(opcion){ //----vehiculo 1----

        int i=mostrarEdificios(th, edificioType.VEHICULO1);//mostrando edificios disponibles de milicia
        System.out.println(i+". vehiculo ya en territorio enemigo");//opcion para elejir tropas ya desplegadas
        
            if(true){
                System.out.println(i+". regresar");//brindando la opcion de regresar
            boolean tropa=true;
            while(tropa){ System.out.println("-----seleccione edfificio------");
                    int opcionn=Utils.pedirEntero("ingrese opcion", 1, i+1);

                    //------------------tropa ya desplegada------------------
                    if(opcionn==i){
                        int mm=1;
                        for(Vehiculo m:th.vehiculo){
                            if (m.getDetectable()==true){ System.out.println(i+". "+m.toString()); mm++;}}

                        if(mm!=1){
                        int opcionmm=Utils.pedirEntero("seleccione vehiculo a reasignar objetivo", 1, mm-1);
                        mm=1;
                        for(Vehiculo m:th.vehiculo){
                            if (m.getDetectable()==true){
                                if (mm==opcionmm)return m;
                                mm++;
                            }
                        }}else { System.out.println("no se encontraron vehiculos en territorio enemigo"); return null;}

                    }//---------------------------------------------------------

                    //--------------------tropa en edificios------------------------------------------------------------------------------------
                    if(opcionn==i+1){//opcion............................
                        System.out.println("regreando");
                        Utils.stop();
                        return null;//////--------------regresar.......
                    }

                    //----------------obtenniendo edificio seleccionado-----------
                    Edificio E=obtenerEdificio(opcionn, th, edificioType.VEHICULO1);
                    int edificioElejido=1;
                    for (Vehiculo s:E.getVehiculos() ){//----------mostrando tropas disponobles en edificio--------
                        if(s.getDetectable()){
                            System.out.println(edificioElejido+". "+s.toString());
                            edificioElejido++;  
                        }}
                    if(edificioElejido!=1){//------------revisando si el edifico seleccionado cuenta con tropas--------
                        System.out.println("seleccione tropa");//----------si el edificico cuenta con tropa se pide seleccionar una tropa--------
                        int temp=Utils.pedirEntero("ingrese opcion", 1, edificioElejido-1);
                        int temp1=1;
                        for (Vehiculo s:E.getVehiculos()){
                        if(s.getDetectable()){
                            if(temp==temp1){
                                E.getVehiculos().remove(s);
                                return s;//------se devuelve la tropa seleccionada------------}
                            }
                            temp1++;
                        }}
                    }else System.out.println("edificio no cuenta con vehiculos entrenados");//-------si el edificio no cuenta con tropa se pide seleccionar otro
                }}
            else{//-----------se advierte de la inexistencia de edificios con tropa-----------


                System.out.println("no hay edificios elaborados de "+edificioType.VEHICULO1);
            Utils.stop();
            }
                
        }//devoviendo especilaista
        else{

        int i=mostrarEdificios(th, edificioType.VEHICULO2);//mostrando edificios disponibles de milicia
        System.out.println(i+". vehiculo ya en territorio enemigo");//opcion para elejir tropas ya desplegadas
        
            if(true){
                System.out.println((i+1)+". regresar");//brindando la opcion de regresar
            boolean tropa=true;
            while(tropa){ System.out.println("-----seleccione edfificio------");
                    int opcionn=Utils.pedirEntero("ingrese opcion", 1, i+1);

                    //------------------tropa ya desplegada------------------
                    if(opcionn==i){
                        int mm=1;
                        for(Vehiculo m:th.vehiculo){
                            if (m.getDetectable()==true){ System.out.println(i+". "+m.toString()); mm++;}}

                        if(mm!=1){
                        int opcionmm=Utils.pedirEntero("seleccione vehiculo a reasignar objetivo", 1, mm-1);
                        mm=1;
                        for(Vehiculo m:th.vehiculo){
                            if (m.getDetectable()==true){
                                if (mm==opcionmm)return m;
                                mm++;
                            }
                        }}else { System.out.println("no se encontraron vehiculos en territorio enemigo"); return null;}

                    }//---------------------------------------------------------

                    //--------------------tropa en edificios------------------------------------------------------------------------------------
                    if(opcionn==i+1){//opcion............................
                        System.out.println("regreando");
                        Utils.stop();
                        return null;//////--------------regresar.......
                    }

                    //----------------obtenniendo edificio seleccionado-----------
                    Edificio E=obtenerEdificio(opcionn, th, edificioType.VEHICULO2);
                    int edificioElejido=1;
                    for (Vehiculo s:E.getVehiculos() ){//----------mostrando tropas disponobles en edificio--------
                        if(s.getDetectable()){
                            System.out.println(edificioElejido+". "+s.toString());
                            edificioElejido++;  
                        }}
                    if(edificioElejido!=1){//------------revisando si el edifico seleccionado cuenta con tropas--------
                        System.out.println("seleccione tropa");//----------si el edificico cuenta con tropa se pide seleccionar una tropa--------
                        int temp=Utils.pedirEntero("ingrese opcion", 1, edificioElejido-1);
                        int temp1=1;
                        for (Vehiculo s:E.getVehiculos()){
                        if(s.getDetectable()){
                            if(temp==temp1){
                                E.getVehiculos().remove(s);
                                return s;//------se devuelve la tropa seleccionada------------}
                            }
                            temp1++;
                        }}
                    }else System.out.println("edificio no cuenta con vehiculos entrenados");//-------si el edificio no cuenta con tropa se pide seleccionar otro
                }}
            else{//-----------se advierte de la inexistencia de edificios con tropa-----------


                System.out.println("no hay edificios elaborados de "+edificioType.VEHICULO2);
            Utils.stop();
            }
                
        }
        return null;}



}