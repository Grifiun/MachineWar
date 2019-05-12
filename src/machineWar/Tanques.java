/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

/**
 *
 * @author guatemla
 */
public class Tanques extends Vehiculos{
    /**
     * Constructor de la clase Vehiculo, inicializa el ataque, la defensa y la puntería del vehiculo
     * @param nombreVehiculo
     * @param tipoVehiculo 
     */
    public Tanques(String nombreVehiculo, String tipoVehiculo) {
        super(nombreVehiculo, tipoVehiculo);
        setAtaque(10);
        setDefensa(6);
        setPunteria(60);
    }
    
}
