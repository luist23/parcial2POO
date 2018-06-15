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
import Factorys.MiliciaType;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public class EdificioMilicia extends Edificios implements Edificio{
    public ArrayList<Milicia> milicia;
    public int tasaRecurso;
    
    public EdificioMilicia(edificioType type){//constructor
        milicia = new ArrayList<>();
        this.type=type;
    }

    @Override
    public void recibirDaño(int daño) { vida -= daño;}//funcion de daño

    @Override
    public void generarRecurso() {}
    @Override
    public void recogerRecurso(CentroDeMando th) {}

    @Override
    public void generarTropa(Razas raza, Fortaleza fortaleza, int milicia,CentroDeMando th) {
        if(this.milicia.size()<10){
        Factory factory;
        factory = FactoryProducer.getFatory(1);
        if (milicia == 1) {
            Milicia a=factory.getMilicia(MiliciaType.ECUADRON, raza, fortaleza);
            if(th.elaborar(a.getCosto()[0], a.getCosto()[1], a.getCosto()[2])){
            this.milicia.add(a);
            th.elaborar(a.getCosto());
            System.out.println("tropa creada");
            }else
            System.out.println("no hay sufucuientes recursos para elaborar");
            
        } else {
            
                //th.especialista=
            Milicia a=factory.getMilicia(MiliciaType.ESPECIALISTA, raza, fortaleza);
            if(th.elaborar(a.getCosto()[0], a.getCosto()[1], a.getCosto()[2])){
            th.especialista=a;
            th.elaborar(a.getCosto());
            System.out.println("tropa creada");
            
            }else
            System.out.println("no hay sufucuientes recursos para elaborar");
        }

    }else System.out.println("edificio seleccionado lleno");
    
    }

    @Override
    public void generarTropa(Razas raza, Fortaleza fortaleza,CentroDeMando th) {}//reservado para edificio de vehiculos

    @Override
    public void setCosto(int recurso1, int recurso2, int recurso3) {//establecer costo edificio
        costo=new int[3];
        costo[0]=recurso1;
        costo[1]=recurso2;
        costo[2]=recurso3;
    }

    @Override
    public void setVida(int vida) {//establece vida inicial
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
        return edificioType.MILICIA;
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
    public String getElementos() {
        int escuadron=0;
        //String a="";
        int escuadron1=0;
        for (Milicia e:milicia){
            if(e.getDetectable())
            escuadron++;
            else escuadron1++;
        }
        return escuadron + " escuadrones disponibles, "+escuadron1+" escuadrones entrenando";
    }

    @Override
    public int[] getCosto() {
        return costo;
    }
    @Override
    public String toString(){
        String espera="";
        if(!detectable)
            espera="edificio no disponible tiempo restante: "+tiempoespera;
        else espera=" unidades en edificio: "+milicia.size();
        return type +":  vida:"+vida+espera;
    }

    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public String costoToString() {
        return edificioType.MILICIA+"   costo{ "+edificioType.RECURSO1+": "
                +costo[0]+"  "+edificioType.RECURSO2+": "
                +costo[1]+"  "+edificioType.RECURSO2+": "+costo[2]+" }";
    }

    @Override
    public void setFase(ArrayList<String> mensajes) {
        if(!detectable){
            
        tiempoespera-=1;
        if(tiempoespera==0){
            detectable=true;
            mensajes.add(edificioType.MILICIA+" "+raza+" construido");
        }
    }else{
         for (Milicia e:milicia){
             e.setFase(mensajes,true);}}
    }

    @Override
    public int getTiempoEspera() {
        return tiempoespera;
    }

    @Override
    public ArrayList<Milicia> getMilicias() {
        return milicia;
    }
    @Override
    public ArrayList<Vehiculo> getVehiculos() {
        return null;
    }
    
    
}
