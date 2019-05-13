/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools |  Templates
 * and open the template in the editor. 
 */
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author guatemla
 */
public class CrearJugadores extends Menus{
    protected JPanel panelCrearJugadores = new JPanel();
    private JButton[] botonesCrearJugadores = new JButton[3];
    private JTextField cajaTexto;
    private JLabel mensaje = new JLabel("NOMBRE JUGADOR");    
    
    private int vehiculosCreados = 0;
    /**
     * Constructor de la clase CrearJugadores, recibe una copia del heap de Menus
     * @param menus 
     */
    public CrearJugadores(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelCrearJugadores);
    }
    /**
     * Creacion de "botonesCrearJugadores"
     */
    public void crearJugadores(){
        String[] titulos = {"TANQUE", "AVION", "USUARIO"};        
        agregarComponentes(panelCrearJugadores, botonesCrearJugadores, titulos);
        crearCajaTexto();
        crearMensaje();        
    }
    /**
     * Sobre-escritura de las acciones que tendrán los botones
     * @param i
     * @param boton 
     */
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(i){
                    case 0:                             
                            menus.datos.agregarVehiculo("Tanque", cajaTexto.getText(), menus.datos.getSizeListaJugadores() - 1);
                            vehiculosCreados++;                        
                        break;
                    case 1:                             
                            menus.datos.agregarVehiculo("Avion", cajaTexto.getText(), menus.datos.getSizeListaJugadores() - 1);
                            vehiculosCreados++;  
                        break;
                    case 2:                            
                            System.out.println("USUARIO CREADO");
                            menus.datos.addJugador(cajaTexto.getText()); 
                            menus.setIdJug1(menus.datos.getSizeListaJugadores() - 1);
                        break;                           
                       
                }
                cajaTexto.setText("");
                mensaje.setText("NOMBRE VEHICULO "+ (vehiculosCreados + 1));
                if(vehiculosCreados >= 3){
                            panelCrearJugadores.setVisible(false);
                            partida = new Partida(menus);
                            menus.setPartida(partida);
                            partida.partida();
                            menus.datos.guardarDatos();
                }
            }
        };                            
        boton.addActionListener(accion);
    }
    /**
     * Creación de un JTextField llamado "cajaTexto", el cual leerá los datos necesarios
     */
    public void crearCajaTexto(){
        cajaTexto = new JTextField();            
        panelCrearJugadores.add(cajaTexto);
        cajaTexto.setBackground(Color.DARK_GRAY);
        cajaTexto.setForeground(Color.CYAN);
        cajaTexto.setBounds(350, 305, 100, 20);
    }
    /**
     * Creacion de un label "mensaje" que se encargará de escribir los datos solicitados
     */
    public void crearMensaje(){
        mensaje.setBounds(343, 280, 200, 20);
        mensaje.setBackground(Color.DARK_GRAY);
        mensaje.setForeground(Color.CYAN);
        panelCrearJugadores.add(mensaje);
    }
    
    
}
