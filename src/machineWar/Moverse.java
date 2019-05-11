/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guatemla
 */
public class Moverse extends Thread{
    private int i = 1;    
    private String vehiculo;
    private String direccion;
    private String restriccionVehiculo;
    private int casillasAMover;
    Random rand = new Random(System.currentTimeMillis());
    protected Escenarios escenarios;
    
    /**
     * Constructor de la clase Moverse, nombre es el nombre del proceso, escenarios es la copia del Heap de la clase Escenarios, x e y son las pociones iniciales, direccion es la dir a mover
     * @param nombre
     * @param escenarios
     * @param x
     * @param y
     * @param vehiculo
     * @param direccion 
     */
    public Moverse(String nombre, Escenarios escenarios, String vehiculo, String direccion){        
        super(nombre);
        this.escenarios = escenarios;      
        this.vehiculo = vehiculo;
        this.direccion = direccion;
        if(vehiculo == "TANQUE")
            this.restriccionVehiculo = "AGUA";
        if(vehiculo == "AVION")
            this.restriccionVehiculo = "MONTANA";
        casillasAMover = rand.nextInt(3) + 1; rand.setSeed(System.currentTimeMillis());
    }    
    /**
     * Sobre escritura de run()
     */
    @Override
    public void run(){            
            revisarRellenarCasillas(casillasAMover); //casiiasAMover 
            /*
            System.out.println("    "+escenarios.getTamanoY()+" - "+ casillasAMover+ " = "+(escenarios.getTamanoY() - casillasAMover));
            System.out.println("    "+escenarios.getTamanoY()+" + "+ casillasAMover+ " = "+(escenarios.getTamanoY() + casillasAMover));
            System.out.println("    "+escenarios.posX+" - "+ casillasAMover+ " = "+(escenarios.posX - casillasAMover));
            System.out.println("    "+escenarios.posX+" - "+ casillasAMover+ " = "+(escenarios.posX + casillasAMover));  */
            
    } 
    /**
     * Metodo recursivo para mover al vehiculo
     * @param x
     * @param y
     * @param vehiculo
     * @param direccion
     * @param casillasAMover 
     */
    public void revisarRellenarCasillas(int casillasAMover){       
        pause(500);        
        if(direccion == "ARRIBA"){ // Arriba
            cambiarDeCasilla(escenarios.posX, escenarios.posY, "");
            escenarios.posY--;
            cambiarDeCasilla(escenarios.posX, escenarios.posY, vehiculo);
        }
        if(direccion == "ABAJO"){ // Abajo          
            cambiarDeCasilla(escenarios.posX, escenarios.posY, "");
            escenarios.posY++;
            cambiarDeCasilla(escenarios.posX, escenarios.posY, vehiculo);
        }
        if(direccion == "IZQUIERDA"){// Izquierda
            cambiarDeCasilla(escenarios.posX, escenarios.posY, "");
            escenarios.posX++;
            cambiarDeCasilla(escenarios.posX, escenarios.posY, vehiculo);
        }
        if(direccion == "DERECHA"){// Derecha          
            cambiarDeCasilla(escenarios.posX, escenarios.posY, "");
            escenarios.posX--;
            cambiarDeCasilla(escenarios.posX, escenarios.posY, vehiculo);
                        
        } 
        
        if(i < casillasAMover){
            i++;
            revisarRellenarCasillas(casillasAMover);               
        } 
    }
    
    /**
     * Metodo encargado de cambiar de posicion
     * @param x
     * @param y
     * @param estado 
     */
    public void cambiarDeCasilla(int x, int y, String estado){
        if(estado != null){           
            escenarios.establecerVehiculo(x, y, estado);            
        }        
        else{            
                              
        }
        
    } 
    /**
     * Metodo encargado de pause
     * @param tiempo 
     */
    public void pause(int tiempo){
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Moverse.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
