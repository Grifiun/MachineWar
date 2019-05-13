/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author guatemla
 */
class CrearVehiculos extends Menus{
    protected JPanel panelCrearVehiculos = new JPanel();
    private JButton[] botonesCrearVehiculos = new JButton[3];
    private JTextField cajaTexto;
    
    /**
     * Se hace una referencia al Heap de Menus
     * @param menus 
     */
    public CrearVehiculos(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelCrearVehiculos);
        
    }
    
    /**
     * Se crean los botones iniciales del menu
     */
    public void crearVehiculos (){        
        String[] titulos = {"TANQUE", "AVION", "REGRESAR"};
        agregarComponentes(panelCrearVehiculos, botonesCrearVehiculos, titulos);
        agregarCajaTexto();
    }
    
    /**
     * Se sobreescribe las acciones al presionar los nuevos botones
     *
     */
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = cajaTexto.getText();
                switch(i){
                    case 0:
                        
                        if(texto.length() == 0)
                            JOptionPane.showMessageDialog(null, "INGRESA NOMBRE DEL VEHICULO");
                        else{
                            menus.datos.agregarVehiculo("Tanque", cajaTexto.getText(), menus.getIdJug1());
                            cajaTexto.setText("");
                            JOptionPane.showMessageDialog(null, "TANQUE CREADO CON EXITO");
                        }
                        break;
                    case 1:
                        if(texto.length() == 0)
                            JOptionPane.showMessageDialog(null, "INGRESA NOMBRE DEL VEHICULO");
                        else{                        
                            menus.datos.agregarVehiculo("Avion", cajaTexto.getText(), menus.getIdJug1());
                            cajaTexto.setText("");
                            JOptionPane.showMessageDialog(null, "AVION CREADO CON EXITO");
                        }
                        break; 
                    case 2:
                        panelCrearVehiculos.setVisible(false);
                        menus.partida.panelPartida.setVisible(true);
                        break;
                }
            }
        };                            
        boton.addActionListener(accion);
    }

    private void agregarCajaTexto() {
        cajaTexto = new JTextField();
        cajaTexto.setBackground(Color.DARK_GRAY);
        cajaTexto.setForeground(Color.CYAN);
        cajaTexto.setBounds(350, 305, 100, 20);
        panelCrearVehiculos.add(cajaTexto);
    }
}
