/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Builders.BuilderEscuadron;
import Builders.BuilderEspecialista;
import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Milicia.miliciaAbstract.Milicia;
import Milicia.miliciaConcret.EscuadronRaza1;
import Milicia.miliciaConcret.EscuadronRaza2;
import Milicia.miliciaConcret.EscuadronRaza3;
import Milicia.miliciaConcret.EspecialistaRaza1;
import Milicia.miliciaConcret.EspecialistaRaza2;
import Milicia.miliciaConcret.EspecialistaRaza3;
import VehiculoAbstarct.Vehiculo;

/**
 *
 * @author LuisT23
 */
public class miliciaFactory extends Factory{

    @Override
    public Milicia getMilicia(MiliciaType type,Razas raza,Fortaleza fortaleza) {
        switch(raza){
            case RAZA1:
                switch(type){
                    case ECUADRON:
                        return BuilderEscuadron.getEscuadron(new EscuadronRaza1(raza),fortaleza);
                    case ESPECIALISTA:
                        return BuilderEspecialista.getEspecialista(EspecialistaRaza1.getInstance(raza),fortaleza);}
            case RAZA2:
                switch(type){
                    case ECUADRON:
                        return BuilderEscuadron.getEscuadron(new EscuadronRaza2(raza),fortaleza);
                    case ESPECIALISTA:
                        return BuilderEspecialista.getEspecialista(EspecialistaRaza2.getInstance(raza),fortaleza);}
            case RAZA3:
                switch(type){
                    case ECUADRON:
                        return BuilderEscuadron.getEscuadron(new EscuadronRaza3(raza),fortaleza);
                    case ESPECIALISTA:
                        return BuilderEspecialista.getEspecialista(EspecialistaRaza3.getInstance(raza),fortaleza);}
        }
        
    return null;
    }

    @Override public Edificio getEdificio(edificioType tipe,Razas raza, Fortaleza fortaleza) {return null;}
    @Override public Vehiculo getVehiculo(VehiculoType type, Razas raza,Fortaleza fortaleza) {return null;}
}
