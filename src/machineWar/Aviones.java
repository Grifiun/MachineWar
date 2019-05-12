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
public class Aviones extends Vehiculos{
    private double velocidad;
    public Aviones(String nombreVehiculo, String tipoVehiculo){
        super(nombreVehiculo, tipoVehiculo);
        this.velocidad = 1.1;
        setAtaque(7);
        setDefensa(3);
        setPunteria(70);
    }
    
    /**
     * Modificar la Velocidad
     */
    public void modificarVelocidad(){
        this.velocidad = 1 + (getNivel() / 10);
    }
    /**
     * agrear velocidad adicional
     * @param velocidad 
     */
    public void agregarVelocidad(double velocidad){
        this.velocidad += velocidad;
    }
    
}
