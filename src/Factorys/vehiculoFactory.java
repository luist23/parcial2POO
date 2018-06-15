/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Builders.BuilderVehiculo1;
import Builders.BuilderVehiculo2;
import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;
import VehiculosConcrect.Vehiculo1Raza1;
import VehiculosConcrect.Vehiculo1Raza2;
import VehiculosConcrect.Vehiculo1Raza3;
import VehiculosConcrect.Vehiculo2Raza1;
import VehiculosConcrect.Vehiculo2Raza2;
import VehiculosConcrect.Vehiculo2Raza3;

/**
 *
 * @author LuisT23
 */
public class vehiculoFactory extends Factory{
    @Override public Milicia getMilicia(MiliciaType type,Razas raza, Fortaleza fortaleza) {return null;}
    @Override public Edificio getEdificio(edificioType tipe,Razas raza, Fortaleza fortaleza) {return null;}

    @Override 
    public Vehiculo getVehiculo(VehiculoType type,Razas raza,Fortaleza fortaleza) {
        
        switch(raza){
            case RAZA1:
                switch(type){
                    case VEHICULO1:
                        return BuilderVehiculo1.getVehiculo(new Vehiculo1Raza1(raza),fortaleza);
                    case VEHICULO2:
                        return BuilderVehiculo2.getVehiculo(new Vehiculo2Raza1(raza),fortaleza);}
            case RAZA2:
                switch(type){
                    case VEHICULO1:
                        return BuilderVehiculo1.getVehiculo(new Vehiculo1Raza2(raza),fortaleza);
                    case VEHICULO2:
                        return BuilderVehiculo2.getVehiculo(new Vehiculo2Raza2(raza),fortaleza);}
            case RAZA3:
                switch(type){
                    case VEHICULO1:
                        return BuilderVehiculo1.getVehiculo(new Vehiculo1Raza3(raza),fortaleza);
                    case VEHICULO2:
                        return BuilderVehiculo2.getVehiculo(new Vehiculo2Raza3(raza),fortaleza);}
        }
        
        
        return null;
}

}
