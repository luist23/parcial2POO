/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Milicia.miliciaConcret;

import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioConcret.CentroDeMando;
import Factorys.MiliciaType;
import Factorys.Razas;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;

/**
 *
 * @author LuisT23
 */
public class Milicias {
    public int vida;
    public int ataque[];//milicia,vehiculo,edificio
    public Milicia objetivoMilicia;
    public Vehiculo objetivoVehiculo;
    public Edificio objetivoEdificio;
    public CentroDeMando objetivoTh;
    public int costo[];//recurso1,recurso2,reurso3
    public int tiempoespera;
    public boolean detectable=false;
    public Razas raza;
    //public MiliciaType type;
    
}
