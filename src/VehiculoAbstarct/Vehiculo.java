/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAbstarct;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioConcret.CentroDeMando;
import Milicia.miliciaAbstract.Milicia;
import java.util.ArrayList;

/**
 *
 * @author LuisT23
 */
public interface Vehiculo {
    public void atacar(ArrayList<String> mesajes,ArrayList<String> mesajesEnemigos,boolean prioridad);
    public void recibirDaño(int daño);
    public void reAsignarObjetivo();
    public void asignarObjetivo(Milicia objetivo);
    public void asignarObjetivo(Vehiculo objetivo);
    public void asignarObjetivo(Edificio objetivo);
    public void asignarObjetivo(CentroDeMando th);
    public void setCosto(int recurso1,int recurso2,int recurso3);
    public void setAtaque(int milicia,int vehiculo,int edificio);
    public void setEspera(int tiempo);
    public int[] getCosto();
    public boolean getDetectable();
    public void setDetectable(boolean estado);
    public void setVida(int vida);
    public int getVida();
    public String getObjetivo();
    public int getTiempoEspera();
    public void setFase(ArrayList<String> mensajes);
    public String costoToString();
    
}
