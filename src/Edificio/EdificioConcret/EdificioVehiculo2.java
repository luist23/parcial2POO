/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificio.EdificioConcret;

import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.Edificios;
import Edificio.EdificioAbstract.edificioType;
import Factorys.Factory;
import Factorys.FactoryProducer;
import Factorys.Razas;
import Factorys.VehiculoType;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public class EdificioVehiculo2 extends Edificios implements Edificio{
    public ArrayList<Vehiculo> vehiculos;
    public int tasaRecurso;
    
    
    
    public EdificioVehiculo2(){//constructor
        vehiculos=new ArrayList<>();
    }

    public EdificioVehiculo2(edificioType type) {
        this.type=type;
        vehiculos=new ArrayList<>();
    }

    @Override
    public void recibirDaño(int daño) { vida -= daño;}//recivir daño
    
    @Override
    public void generarRecurso() {}
    @Override
    public void recogerRecurso(CentroDeMando th) {}//no es edificio de recursos
    
    @Override
    public void generarTropa(Razas raza,Fortaleza fortaleza,CentroDeMando th) {
        if(vehiculos.size()<10){
        Factory factory;
        factory=FactoryProducer.getFatory(2);
        Vehiculo e=factory.getVehiculo(VehiculoType.VEHICULO2, raza, fortaleza);
        if(th.elaborar(e.getCosto()[0], e.getCosto()[1], e.getCosto()[2])){
           vehiculos.add(e);
           th.elaborar(e.getCosto());System.out.println("vehiculo creado");
        }else
            System.out.println("no hay sufucuientes recursos para elaborar");
        
        
        }else System.out.println("edificio seleccionado lleno");
    }

    @Override
    public void generarTropa(Razas raza, Fortaleza fortaleza, int milicia,CentroDeMando th) {}

    @Override
    public void setCosto(int recurso1, int recurso2, int recurso3) {//establece el costo del edificio
        costo=new int[3];
        costo[0]=recurso1;
        costo[1]=recurso2;
        costo[2]=recurso3;
    }
    @Override
    public void setVida(int vida) {//establece la vida inicial del edificio
        this.vida=vida;
    }
    
@Override
    public void setEspera(int tiempo) {
        tiempoespera=tiempo;
    }

    @Override
    public void setDetectable(boolean detectable) {
        this.detectable=detectable;
    }
    @Override
    public edificioType getType() {
        return edificioType.VEHICULO2;
    }
    
@Override
    public boolean getInmortal() {
        return inmortal;
    }
    @Override
    public void setInmortal(boolean i) {
        inmortal=i;
    }
    @Override
    public void setRaza(Razas raza) {
        this.raza=raza;
    }

    @Override
    public Razas getRaza() {
        return raza;
    }
    @Override
    public void setTazaRecurso(int taza) {
    }
    @Override
    public boolean getDetectable() {
        return detectable;
    }
    @Override
    public int[] getCosto() {
        return costo;
    }
    @Override
    public String getElementos() {
        int escuadron=0;
        int escuadron2=0;
        for (Vehiculo e : vehiculos) {
            if(!e.getDetectable())
            escuadron++;
            else escuadron2++;
        }
        if(escuadron!=0 || escuadron2!=0){
        return escuadron + " vehiculos elaborandose  "+escuadron2+"  entrenados";}
        else return "sin vehiculos disponible";
    }
    
    @Override
    public String toString(){
        String espera="";
        if(!detectable)
            espera="edificio no disponible tiempo restante: "+tiempoespera;
        else espera=" unidades en edificio: "+vehiculos.size();
        return type +":  vida:"+vida+espera;
    }
    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public String costoToString() {
        return edificioType.VEHICULO2+"   costo{ "+edificioType.RECURSO1+": "
                +costo[0]+"  "+edificioType.RECURSO2+": "
                +costo[1]+"  "+edificioType.RECURSO2+": "+costo[2]+" }";
    }
    @Override
    public void setFase(ArrayList<String> mensajes) {
        if(!detectable){
            
        tiempoespera-=1;
        if(tiempoespera==0){
            detectable=true;
            mensajes.add(edificioType.VEHICULO2+" "+raza+" construido");
        }
    }else{
         for (Vehiculo e:vehiculos){
             e.setFase(mensajes);}}
    }
    @Override
    public int getTiempoEspera() {
        return tiempoespera;
    }
    @Override
    public ArrayList<Milicia> getMilicias() {
        return null;
    }
    @Override
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}

