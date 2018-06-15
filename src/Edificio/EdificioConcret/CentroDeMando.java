/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificio.EdificioConcret;

import Builders.BuilderFortaleza;
import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.Edificios;
import Edificio.EdificioAbstract.edificioType;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import VehiculosConcrect.Vehiculos;
import java.util.ArrayList;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * @author LuisT23
 */
public class CentroDeMando extends Edificios{
    public ArrayList<Milicia> milicia;//milicias en campos enemigos
    public ArrayList<Vehiculo> vehiculo;//vehiculos en campo enenmigos
    public ArrayList<Edificio> edificaciones;//edificios existentes
    
    public ArrayList<Milicia> miliciaEnemiga;//milicias en campos enemigos
    public ArrayList<Vehiculo> vehiculoEnnemigo;//vehiculos en campo enenmigos
    public ArrayList<Edificio> edificacionesEnemigo;//edificios existentes
    public CentroDeMando thEnemigo;
    
    public Milicia especialista;
    public int recurso1,maxRe1;
    public int recurso2,maxRe2;
    public int recurso3,maxRe3;
    public int nivel;
    public Fortaleza fortaleza;
    public Fortaleza getFortaleza(){
        return fortaleza;
    }
    
    public void setEnemigos(ArrayList<Milicia> miliciaEnemiga,ArrayList<Vehiculo> vehiculoEnnemigo,ArrayList<Edificio> edificacionesEnemigo){
        this.miliciaEnemiga=miliciaEnemiga;
        this.vehiculoEnnemigo=vehiculoEnnemigo;
        this.edificacionesEnemigo=edificacionesEnemigo;
    }

    public CentroDeMando(int vida,Razas raza) {
        milicia=new ArrayList<>();
        edificaciones=new ArrayList<>();
        vehiculo=new ArrayList<>();
        this.vida=vida;
        this.detectable=true;
        this.tiempoespera=0;
        this.raza=raza;
        this.inmortal=false;
        //-------------recursos iniciales---------------
        recurso1=0;maxRe1=10000;
        recurso2=0;maxRe2=5000;
        recurso3=0;maxRe3=3000;
        fortaleza=BuilderFortaleza.getFortaleza(raza);
       
    }
    
    
    
    /**
     * almacena los recursos que se le envian verificando que no sobrepase el limite
     * y retorna la cantidad almacenada de recursos
     * @param recurso1
     * @param recurso2
     * @param recurso3
     * @return 
     */
    public int[] setRecursos(int recurso1, int recurso2, int recurso3) {
        int[] a = {recurso1, recurso2, recurso3};

        if (this.recurso1 + recurso1 >= maxRe1+1) {
            a[0] = maxRe1 - this.recurso1;
            System.out.println("almacen llenorecurso: "+edificioType.RECURSO1);
            System.out.println("se recogieron "+(maxRe1 - this.recurso1)+" de "+edificioType.RECURSO1);
            this.recurso1 = maxRe1;
            
        } else {
            this.recurso1 += recurso1;System.out.println("se recogieron "+recurso1+" de "+edificioType.RECURSO1);
        }
        if (this.recurso2 + recurso2 >= maxRe2+1) {
            a[1] = maxRe2 - this.recurso2;
            System.out.println("almacen llenorecurso: "+edificioType.RECURSO2);
            System.out.println("se recogieron "+(maxRe2 - this.recurso2)+" de "+edificioType.RECURSO2);
            this.recurso2 = maxRe2;
            //System.out.println("almacen llenorecurso: "+edificioType.RECURSO2);
        } else {
            this.recurso2 += recurso2;System.out.println("se recogieron "+recurso2+" de "+edificioType.RECURSO1);
        }
        if (this.recurso3 + recurso3 >= maxRe3+1) {
            a[2] = maxRe3 - this.recurso3;
            System.out.println("almacen llenorecurso: "+edificioType.RECURSO3);
            System.out.println("se recogieron "+(maxRe3 - this.recurso3)+" de "+edificioType.RECURSO3);
            this.recurso3 = maxRe3;
            //System.out.println("almacen llenorecurso: "+edificioType.RECURSO3);
        } else {
            this.recurso3 += recurso3;System.out.println("se recogieron "+recurso3+" de "+edificioType.RECURSO1);
        }
        return a;
    }
    

    public Razas getRaza() {
        return raza;
    }
    
    /**
     * verifica si hay recursos suficiente para elaborar una tropa, vehiculo
     * o para construir un edificio
     * 
     * @param recurso1: recurso1 necesario
     * @param recurso2: recurso2 necesario
     * @param recurso3: recurso3 necesario
     * @return si hay recursos sufucuentes almacenados
     */
    public boolean elaborar(int recurso1,int recurso2, int recurso3){
        return this.recurso1 >= recurso1 && this.recurso2 >= recurso2 && this.recurso3 >= recurso3;
}
    public void elaborar(int[] a){
        recurso1-=a[0];
        recurso2-=a[1];
        recurso3-=a[2];
    }

    @Override
    public String toString() {
        String a="";
        if(especialista!=null)
            if(especialista.getDetectable())
                a=" especialista disponile";
        return "centro de mando:  vida: "+vida+"  nivel: "+nivel+a+"{ "+edificioType.RECURSO1+": "+recurso1+"  "+edificioType.RECURSO2+": "+recurso2
                +"  "+edificioType.RECURSO3+": "+recurso3+" }";
    }
    public String recursosToSting(){
        return "\nRecursos disponibles--- "+edificioType.RECURSO1+": "+recurso1+"  "+edificioType.RECURSO2+": "+recurso2
                +"  "+edificioType.RECURSO3+": "+recurso3+"\n";
    }
    public void setRaza(Razas raza){
        this.raza=raza;
    }
    
    
    public void setFase(ArrayList<String> mensajes){
        for (Vehiculo e:vehiculo){if(e.getVida()<=0)vehiculo.remove(e);
        else e.setFase(mensajes);
        }
        for(Milicia e:milicia){if(e.getVida()<=0)milicia.remove(e);
        else e.setFase(mensajes,false);
        
        }
        int a=0;
        for(Edificio e:edificaciones){if(e.getVida()<=0)edificaciones.remove(e);
        else e.setFase(mensajes);
        a++;
        }
        if(a!=0 && !inmortal)inmortal=true;
        if(especialista!=null)
            if(especialista.getVida()<=0)especialista=null;
            else especialista.setFase(mensajes,true);
        if(a==0&&inmortal){
            inmortal=false;
            //delete(especialista);
        }
    }
    
    public void setAtaque(ArrayList<String> mensajes,ArrayList<String> mensajesenemigo){
        for (Vehiculo e:vehiculoEnnemigo){if(e.getVida()<=0){
            vehiculoEnnemigo.remove(e);
            mensajes.add(" se elimino vehiculo enemiga");
            mensajesenemigo.add(" eliminaron uno de tus vehiculos");
        }
        //else e.setFase(mensajes);
        }
        for(Milicia e:miliciaEnemiga){if(e.getVida()<=0){
            miliciaEnemiga.remove(e);
            mensajes.add(" se elimino una tropa enemiga");
            mensajesenemigo.add(" eliminaron una de tus tropas");
        }
        //else e.setFase(mensajes,false);
        
        }
    }
    
    public void levelUp(){
        if (nivel<3){
            
            
            int re1,re2,re3;
            re1=intValue(0.25*maxRe1);
            re2=intValue(0.25*maxRe2);
            re3=intValue(0.25*maxRe3);
            if(elaborar(re1,re2,re3)){
                double[] i={1.1,1.3,1.5};
                nivel++;
                recurso1-=re1;
                recurso2-=re2;
                recurso3-=re3;
                maxRe1=intValue(maxRe1*i[nivel-1]);
                maxRe2=intValue(maxRe2*i[nivel-1]);
                maxRe3=intValue(maxRe3*i[nivel-1]);
                System.out.println("nivel aumentado a"+nivel);
            }else System.out.println("recursos insufisientes para mejorar");
        }
    }
    
    
    
}
