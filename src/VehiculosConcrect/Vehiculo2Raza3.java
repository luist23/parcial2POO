/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculosConcrect;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;
import static oracle.jrockit.jfr.events.Bits.intValue;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class Vehiculo2Raza3 extends Vehiculos implements Vehiculo{
    public Vehiculo2Raza3(Razas raza) {
        this.raza=raza;
    }
    @Override
    public void atacar(ArrayList<String> mesajes,ArrayList<String> mesajesEnemigos,boolean prioridad) {
        double azar=Utils.aleatorio();
        String a="";
            if(prioridad){
        if (objetivoMilicia != null){ objetivoMilicia.recibirDaño(intValue(ataque[0]*azar));
        if(objetivoMilicia.getVida()<=0)a= " *tropa eliminada* ";
        mesajes.add("se daño: "+ataque[0]+" con porcentaje: "+azar*100+"%  = "+ataque[0]*azar+" a "+objetivoMilicia.toString()+a);
        mesajesEnemigos.add("te dañaron: "+ataque[0]+" con porcentaje: "+azar*100+"%  = "+ataque[0]*azar+" a "+objetivoMilicia.toString()+a);
        if(objetivoMilicia.getVida()<=0)objetivoMilicia=null;
        }}else{
                
            if(objetivoTh!=null){
                if (!objetivoTh.inmortal){
            //System.out.println("se ataco th");
            objetivoTh.vida-=intValue(ataque[2]*azar);
            //System.out.println("");
            mesajes.add("se daño: "+ataque[2]+" con porcentaje: "+azar*100+"%  = "+ataque[2]*azar+" a "+"Centro de mando enemigo"+a+" vida: "+objetivoTh.vida);
        mesajesEnemigos.add("te dañaron: "+ataque[2]+" con porcentaje: "+azar*100+"%  = "+ataque[2]*azar+" a "+" Centro de mando"+a+" vida: "+objetivoTh.vida);
        if(objetivoTh.vida<=0)a= " *Centro de mando enemigo eliminado* ";
        }else if(objetivoTh!=null)mesajes.add("Centro de mando enemigo inaxesible");
            }
        
            
        if (objetivoVehiculo != null){ objetivoVehiculo.recibirDaño(intValue(ataque[1]*azar));
        if(objetivoMilicia.getVida()<=0)a= " *vehiculo eliminada* ";
        mesajes.add("se daño: "+ataque[1]+" con porcentaje: "+azar*100+"%  = "+ataque[1]*azar+" a "+objetivoMilicia.toString()+a);
        mesajesEnemigos.add("te dañaron: "+ataque[1]+" con porcentaje: "+azar*100+"%  = "+ataque[1]*azar+" a "+objetivoMilicia.toString()+a);
        
        if(objetivoMilicia.getVida()<=0)objetivoMilicia=null;
        }  
        else if (objetivoEdificio != null){ objetivoEdificio.recibirDaño(intValue(ataque[2]*azar));
        if(objetivoMilicia.getVida()<=0)a= " *edificio eliminada* ";
        mesajes.add("se daño: "+ataque[2]+" con porcentaje: "+azar*100+"%  = "+ataque[2]*azar+" a "+objetivoMilicia.toString()+a);
        mesajesEnemigos.add("te dañaron: "+ataque[2]+" con porcentaje: "+azar*100+"%  = "+ataque[2]*azar+" a "+objetivoMilicia.toString()+a);
        if(objetivoMilicia.getVida()<=0)objetivoMilicia=null;
        }}}

    @Override public void recibirDaño(int daño) { vida -= daño;}

    @Override
    public void reAsignarObjetivo() {
        objetivoEdificio=null;
        objetivoMilicia=null;
        objetivoVehiculo=null;
        objetivoTh=null;
    }

    @Override
    public void asignarObjetivo(Milicia objetivo) { 
        reAsignarObjetivo();
        objetivoMilicia=objetivo;
            }

    @Override
    public void asignarObjetivo(Vehiculo objetivo) {
        reAsignarObjetivo();
        objetivoVehiculo=objetivo;
            }

    @Override
    public void asignarObjetivo(Edificio objetivo) {
        reAsignarObjetivo();
        objetivoEdificio=objetivo;
            }

    @Override
    public void setCosto(int recurso1, int recurso2, int recurso3) {
        costo=new int[3];
        costo[0]=recurso1;
        costo[1]=recurso2;
        costo[2]=recurso3;
    }

    @Override
    public int[] getCosto() {
        return costo;
    }

    @Override
    public void setAtaque(int milicia, int vehiculo, int edificio) {
        ataque=new int[3];
        ataque[0]=milicia;
        ataque[1]=vehiculo;
        ataque[2]=edificio;
    }

    @Override
    public void setEspera(int tiempo) {
        tiempoespera=tiempo;
    }

    @Override
    public boolean getDetectable() {
        return detectable;
    }

    @Override
    public void setDetectable(boolean estado) {
        detectable=estado;
    }
@Override
    public void setVida(int vida) {
        this.vida=vida;
    }
    @Override
    public String getObjetivo() {
        String a="";
        if(objetivoEdificio!=null)
            a="edificio:  vida:"+objetivoEdificio.getVida();
        else if (objetivoMilicia!=null)
            a="tropa enemiga:  vida:"+objetivoMilicia.getVida();
        else if(objetivoVehiculo!=null)
            a="vehiculo enemigo: vida:"+ objetivoVehiculo.getVida();
        else a=" sin objetivo actual";
        return a;
    }

    @Override
    public int getTiempoEspera() {
        return tiempoespera;
    }

    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public void setFase(ArrayList<String> mensajes) {
        if(!detectable){
            
        tiempoespera-=1;
        if(tiempoespera==0){
            detectable=true;
            mensajes.add(edificioType.VEHICULO2+" "+raza+" construido");
        }
    }}
    @Override
    public String toString() {
        
        return  edificioType.VEHICULO2+" "+ raza+" vida: "+vida+"   ataque { edificio: "+ataque[0]+"   milicia: "+ataque[1]+"   vehiculos"+ataque[2]+ " }";
        
        
        
    }
    @Override
    public void asignarObjetivo(CentroDeMando th) {
        objetivoTh=th;
    }
    @Override
    public String costoToString() {
        return edificioType.VEHICULO2+"   costo{ "+edificioType.RECURSO1+": "
                +costo[0]+"  "+edificioType.RECURSO2+": "
                +costo[1]+"  "+edificioType.RECURSO2+": "+costo[2]+" }"+"   ataque { edificio: "+ataque[0]+"   milicia: "+ataque[1]+"   vehiculos"+ataque[2]+ " }";
    }
}
