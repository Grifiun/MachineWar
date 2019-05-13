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
public class ArmasAviones extends Armas{
     private double velocidad;
    /**
     * Modificar velocidad, ataque y punteria
     * @param velocidad
     * @param ataque
     * @param punteria 
     */
    public ArmasAviones(double velocidad, int ataque, double punteria) {
        super(ataque, punteria);
        this.velocidad = velocidad;
    }
    /**
     * Retorna Velocidad
     * @return 
     */
    public double getVelocidad() {
        return this.velocidad;
    }
}
