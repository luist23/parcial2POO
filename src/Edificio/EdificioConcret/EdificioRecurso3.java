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
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public class EdificioRecurso3 extends Edificios implements Edificio{
    public int recurso;
    public int tasaRecurso;

    public EdificioRecurso3(edificioType type) {
        this.type=type;
    }

    @Override
    public void recibirDaño(int daño) {
        vida -= daño;
    }

    @Override
    public void generarRecurso() {
        recurso += tasaRecurso;
    }


    @Override
    public void recogerRecurso(CentroDeMando th) {
        recurso -= th.setRecursos(0,0,recurso)[2];
    }

    @Override
    public void generarTropa(Razas raza, Fortaleza fortaleza, int milicia,CentroDeMando th) {
    }

    @Override
    public void generarTropa(Razas raza, Fortaleza fortaleza,CentroDeMando th) {
    }

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
        return edificioType.RECURSO3;
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
        tasaRecurso=taza;
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
        return "";
    }
    @Override
    public String toString(){
        String espera="";
        if(!detectable)
            espera="edificio no disponible tiempo restante: "+tiempoespera;
        else espera=" recursos recolectados: "+recurso;
        return type +":  vida:"+vida+espera;
    }
    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public String costoToString() {
        return edificioType.RECURSO3+"   costo{ "+edificioType.RECURSO1+": "
                +costo[0]+"  "+edificioType.RECURSO2+": "
                +costo[1]+"  "+edificioType.RECURSO2+": "+costo[2]+" }";
    }
    @Override
    public void setFase(ArrayList<String> mensajes) {
        if(!detectable){
            
        tiempoespera-=1;
        if(tiempoespera==0){
            detectable=true;
            mensajes.add(edificioType.RECURSO3+" "+raza+" construido");
        }
    }
        else generarRecurso();
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
        return null;
    }
}
