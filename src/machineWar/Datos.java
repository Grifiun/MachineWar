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
    
    public void agregarListaVehiculos(){
        listaVehiculos.add(vehiculos);
    }
    
    public String getNombreVehiculo(int idJugador, int numVehiculo){
        return listaVehiculos.get(idJugador).get(numVehiculo).getNombreVehiculo();
    }
    
    public String getTipoVehiculo(int idJugador, int numVehiculo){
        return listaVehiculos.get(idJugador).get(numVehiculo).getTipoVehiculo();
    }
    
    public int getSizeNombreVehiculos(int idJugador){ 
        return listaVehiculos.get(idJugador).size();
    }
    
    public int getSizeNombreJugadores(){
        return nombreJugadores.size();
    }
    
}
