/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factorys;

import Builders.BuilderEdificioMilicia;
import Builders.BuilderEdificioRecurso1;
import Builders.BuilderEdificioRecurso2;
import Builders.BuilderEdificioRecurso3;
import Builders.BuilderEdificioVehiculo1;
import Builders.BuilderEdificioVehiculo2;
import Builders.Fortaleza;
import Edificio.EdificioAbstract.Edificio;
import Edificio.EdificioAbstract.edificioType;
import Edificio.EdificioConcret.EdificioMilicia;
import Edificio.EdificioConcret.EdificioRecurso1;
import Edificio.EdificioConcret.EdificioRecurso2;
import Edificio.EdificioConcret.EdificioRecurso3;
import Edificio.EdificioConcret.EdificioVehiculo1;
import Edificio.EdificioConcret.EdificioVehiculo2;
import Milicia.miliciaAbstract.Milicia;
import VehiculoAbstarct.Vehiculo;

/**
 *
 * @author LuisT23
 */
public class EdificioFactory extends Factory{

    @Override
    public Milicia getMilicia(MiliciaType type, Razas raza, Fortaleza fortaleza) {return null;
    }

    @Override
    public Edificio getEdificio(edificioType tipe,Razas raza, Fortaleza fortaleza) {
        switch(tipe){
            case MILICIA:
                return BuilderEdificioMilicia.getEdificio(new EdificioMilicia(edificioType.MILICIA),raza,fortaleza);//edificio ya instanciado y con sus valores
            case RECURSO1:
                return BuilderEdificioRecurso1.getEdificio(new EdificioRecurso1(edificioType.RECURSO1), raza, fortaleza);
            case RECURSO2:
                return BuilderEdificioRecurso2.getEdificio(new EdificioRecurso2(edificioType.RECURSO2), raza, fortaleza);
            case RECURSO3:
                return BuilderEdificioRecurso3.getEdificio(new EdificioRecurso3(edificioType.RECURSO3), raza, fortaleza);
            case VEHICULO1:
                return BuilderEdificioVehiculo1.getEdificio(new EdificioVehiculo1(edificioType.VEHICULO1), raza, fortaleza);
            case VEHICULO2:
                return BuilderEdificioVehiculo2.getEdificio(new EdificioVehiculo2(edificioType.VEHICULO2), raza, fortaleza);

        }
        
        
        
        
        
        return null;
        
    }

    @Override
    public Vehiculo getVehiculo(VehiculoType type, Razas raza, Fortaleza fortaleza) {return null;
    }
    
}
