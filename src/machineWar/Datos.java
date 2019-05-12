/*
 * VERSION 2.0
 */
package machineWar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guatemla
 */
public class Datos {
    private ArrayList<Jugadores> listaJugadores = new ArrayList();
    private ArrayList<Jugadores> listaJugadoresAuxiliar = new ArrayList();
    private File datosJugadores = new File("datosJugadores");
    private ObjectOutputStream flujoObjetosSalida;
    private ObjectInputStream flujoObjetosEntrada;
    /**
     * Se encarga de guardar Datos
     */
    public void guardarDatos(){        
        try {
            /*if(datosJugadores.exists())
            datosJugadores.delete();
            */
            flujoObjetosSalida = new ObjectOutputStream(new FileOutputStream(datosJugadores));
            flujoObjetosSalida.writeObject(listaJugadores);
            flujoObjetosSalida.close(); 
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    /**
     * Se encarga de cargar los datos 
     */
    public void cargarDatos(){
        try {
            flujoObjetosEntrada = new ObjectInputStream(new FileInputStream(datosJugadores));
            this.listaJugadoresAuxiliar = (ArrayList<Jugadores>)flujoObjetosEntrada.readObject();
            flujoObjetosEntrada.close();
        } catch (FileNotFoundException ex) {
            System.out.println("ARCH NO ENCONTRADO");
        } catch (IOException e){ System.out.println("xD");
        } catch (ArrayIndexOutOfBoundsException ae){
            System.out.println(ae.getMessage());
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(datosJugadores.exists())
            System.out.println("Existe");
        System.out.println(""); System.out.println(listaJugadoresAuxiliar.size());
        
        this.listaJugadores = this.listaJugadoresAuxiliar;
    }  
    /**
     * Agrega un nuevo jugador
     * @param nombre 
     */
    public void addJugador(String nombre){
        Jugadores jugadores = new Jugadores(nombre);
        listaJugadores.add(jugadores);
    }
    
    /**
     * Agrega un vehiculo en el personaje "idJugador"
     * @param tipo
     * @param nombreVehiculo
     * @param idJugador 
     */
    public void agregarVehiculo(String tipo, String nombreVehiculo, int idJugador){
        Jugadores aux;
        aux = listaJugadores.get(idJugador);
        aux.agregarVehiculo(tipo, nombreVehiculo);        
    }
       
    /**
     * Obtiene la cantidad de usuarios registrados
     * @return 
     */
    public int getSizeListaJugadores(){
        return listaJugadores.size();
    }
    /**
     * Obtiene el nombre del jugador "idJugador"
     * @param idJugador
     * @return 
     */
    public String getNombreJugador(int idJugador){
        return listaJugadores.get(idJugador).getNombre();
    }
    
    /**
     * Obtiene el nombre del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getNombreVehiculo(int idJugador, int numVehiculo){
        Jugadores aux;
        aux = listaJugadores.get(idJugador);
        return aux.getNombreVehiculo(numVehiculo);
    }
    
    /**
     * Obtiene el tipo del vehículo numero "numVehiculo" del jugador "idJugador"
     * @param idJugador
     * @param numVehiculo
     * @return 
     */
    public String getTipoVehiculo(int idJugador, int numVehiculo){
        Jugadores aux;
        aux = listaJugadores.get(idJugador);
        return aux.getTipoVehiculo(numVehiculo);
    }
    
    /**
     * Obtiene la cantidad de vehiculos que posee el jugador "idJugador"
     * @param idJugador
     * @return 
     */
    public int getSizeNombreVehiculos(int idJugador){
        Jugadores aux;
        aux = listaJugadores.get(idJugador);
        return aux.getSizeNombreVehiculos();
    }
}
