/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guatemla
 */
public class Jugadores implements Serializable{
    private String nombre;
    private List<Vehiculos> vehiculos = new ArrayList();

    public Jugadores(String nombre) {
        this.nombre = nombre;
    }        
    /**
     * Crea un vehiculo y luego lo agrega a la Lista de vehiculos
     * @param tipo
     * @param nombreVehiculo 
     */
    public void agregarVehiculo(String tipo, String nombreVehiculo){
        Vehiculos vehiculo;
        if(tipo == "Avion"){
            vehiculo = new Aviones(nombreVehiculo, tipo);            
            vehiculos.add(vehiculo);
        }
        if(tipo == "Tanque"){
            vehiculo = new Tanques(nombreVehiculo, tipo);
            vehiculos.add(vehiculo); 
        }       
    }
    /**
     * Obtiene el nombre del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getNombreVehiculo(int numVehiculo){
        return vehiculos.get(numVehiculo).getNombreVehiculo();
    }
    
    /**
     * Obtiene el tipo del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getTipoVehiculo(int numVehiculo){
        return vehiculos.get(numVehiculo).getTipoVehiculo();
    }
    
    /**
     * Obtiene la cantidad de vehiculos que posee el jugador "idJugador"
     * @param idJugador
     * @return 
     */
    public int getSizeNombreVehiculos(){ 
        return vehiculos.size();
    }
    /**
     * Obtiene el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    
}
