/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;

/**
 *
 * @author LuisT23
 */
public abstract class Factory {
    public abstract Milicia getMilicia(MiliciaType type,Razas raza, Fortaleza fortaleza);
    public abstract Edificio getEdificio(edificioType tipe,Razas raza, Fortaleza fortaleza);
    public abstract Vehiculo getVehiculo(VehiculoType type, Razas raza, Fortaleza fortaleza);
}
