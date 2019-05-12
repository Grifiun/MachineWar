/*
 * VERSION 2.0
 */
package machineWar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guatemla
 */
public class Datos {
    private ArrayList<String> nombreJugadores = new ArrayList();
    private List<List<Vehiculos>> listaVehiculos = new ArrayList<>();
    private List<Vehiculos> vehiculos = new ArrayList();
    
    /**
     * Agrega un nuevo usuario
     * @param nombre 
     */
    public void addNombre(String nombre) {
        nombreJugadores.add(nombre);
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
     * Agrega la lista "Vehiculos" a la Lista de Listas "listaVehiculos"
     */
    public void agregarListaVehiculos(){
        listaVehiculos.add(vehiculos);
    }
    
    /**
     * Obtiene el nombre del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getNombreVehiculo(int idJugador, int numVehiculo){
        return listaVehiculos.get(idJugador).get(numVehiculo).getNombreVehiculo();
    }
    
    /**
     * Obtiene el tipo del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getTipoVehiculo(int idJugador, int numVehiculo){
        return listaVehiculos.get(idJugador).get(numVehiculo).getTipoVehiculo();
    }
    
    /**
     * Obtiene la cantidad de vehiculos que posee el jugador "idJugador"
     * @param idJugador
     * @return 
     */
    public int getSizeNombreVehiculos(int idJugador){ 
        return listaVehiculos.get(idJugador).size();
    }
    
    /**
     * Obtiene la cantidad de usuarios registrados
     * @return 
     */
    public int getSizeNombreJugadores(){
        return nombreJugadores.size();
    }
    
}
