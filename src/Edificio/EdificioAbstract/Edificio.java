/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificio.EdificioAbstract;

import Builders.Fortaleza;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public interface Edificio {
    public void recibirDaño(int daño);
    public void generarRecurso();
    public void recogerRecurso(CentroDeMando th);
    public void generarTropa(Razas raza,Fortaleza fortaleza,int milicia,CentroDeMando th);
    public void generarTropa(Razas raza,Fortaleza fortaleza,CentroDeMando th);
    public void setCosto(int recurso1,int recurso2,int recurso3);
    public void setVida(int vida);
    public void setEspera(int tiempo);
    public void setDetectable(boolean detectable);
    public edificioType getType();
    public boolean getInmortal();
    public boolean getDetectable();
    public void setInmortal(boolean i);
    public void setRaza(Razas raza);
    public Razas getRaza();
    public void setTazaRecurso(int taza);
    public String getElementos();
    public int[] getCosto();
    public int getVida();
    public String costoToString();
    public void setFase(ArrayList<String> mensajes);
    public int getTiempoEspera();
    public ArrayList<Milicia> getMilicias();
    public ArrayList<Vehiculo> getVehiculos();
    
            }
