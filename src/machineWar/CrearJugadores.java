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
    private JButton finalizarCreacion;
    private JTextField cajaTexto;
    protected JLabel mensaje = new JLabel("NOMBRE VEHICULO");
    protected Partida partida;
    
    private int vehiculosCreados = 0;
    /**
     * Constructor de la clase CrearJugadores, recibe una copia del heap de Menus
     * @param menus 
     */
    public CrearJugadores(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelCrearJugadores);
    }
    
    public void crearJugadores(){
        String[] titulos = {"TANQUE", "AVION", "FINALIZAR"};        
        agregarComponentes(panelCrearJugadores, botonesCrearJugadores, titulos);
        crearCajaTexto();
        crearMensaje();        
    }
    
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(i){
                    case 0:                             
                            //menus.datos.setNombreVehiculos(cajaTexto.getText(), "TANQUE", menus.datos.getSizeNombreJugadores());
                            menus.datos.agregarVehiculo("Avion", cajaTexto.getText());
                            vehiculosCreados++;                        
                        break;
                    case 1: 
                            //menus.datos.setNombreVehiculos(cajaTexto.getText(), "AVION", menus.datos.getSizeNombreJugadores());
                            menus.datos.agregarVehiculo("Avion", cajaTexto.getText());
                            vehiculosCreados++;  
                        break;
                    case 2:                            
                            System.out.println("USUARIO CREADO");
                            menus.datos.addNombre(cajaTexto.getText());                            
                            
                            panelCrearJugadores.setVisible(false);
                            partida = new Partida(menus);                            
                            partida.partida();
                        break;     
                }
                cajaTexto.setText("");  
                if(vehiculosCreados == 3){
                   menus.datos.agregarListaVehiculos();
                   mensaje.setText("NOMBRE JUGADOR");
                }
                
            }
        };                            
        boton.addActionListener(accion);
    }
    
    public void crearCajaTexto(){
        cajaTexto = new JTextField();            
        panelCrearJugadores.add(cajaTexto);
        cajaTexto.setBackground(Color.DARK_GRAY);
        cajaTexto.setForeground(Color.CYAN);
        cajaTexto.setBounds(350, 305, 100, 20);
    }
    
    public void crearMensaje(){
        mensaje.setBounds(343, 280, 200, 20);
        mensaje.setBackground(Color.DARK_GRAY);
        mensaje.setForeground(Color.CYAN);
        panelCrearJugadores.add(mensaje);
    }
    
    
}
