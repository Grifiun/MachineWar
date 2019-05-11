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
    private String nombre;
    private ArrayList<String> nombresVehiculos = new ArrayList<String>();
    private ArrayList<String> tipoVehiculos = new ArrayList<String>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Ingresa el nombre y tipo de los vehiculos
     * @param nombresVehiculos
     * @param tipoVehiculos 
     */
    public void setNombreVehiculos(String nombresVehiculos, String tipoVehiculos) {
        this.nombresVehiculos.add(nombresVehiculos);
        this.tipoVehiculos.add(tipoVehiculos);
    }
    
    public String getNombreVehiculos(int i){
        return nombresVehiculos.get(i);
    }
    
    public String getTipoVehiculos(int i){
        return tipoVehiculos.get(i);
    }
    
    public int getSizeNombreVehiculos(){ 
        return nombresVehiculos.size();
    }
    
    
}
