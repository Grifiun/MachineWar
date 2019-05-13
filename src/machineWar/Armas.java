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
public class Armas{
    private int ataque;
    private double punteria;
    /**
     * Modificar ataque y punteria
     * @param ataque
     * @param punteria 
     */
    public Armas(int ataque, double punteria) {
        this.ataque = ataque;
        this.punteria = punteria;        
    }
    /**
     * Retorna ataque
     * @return 
     */
    public int getAtaque() {
        return ataque;
    }
    /**
     * Retorna punteria
     * @return 
     */
    public double getPunteria() {
        return punteria;
    }
}
