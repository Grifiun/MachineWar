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
public class Reportes extends Menus{
    private JButton[] botonesReportes = new JButton[6];
    protected JPanel panelReportes = new JPanel();
    private JTextArea areaTextoVehiculos = new JTextArea();
    private JTextArea areaTextoTipoVehiculos = new JTextArea();
    private Partida partida;
    private boolean mostrarPanelMP = true;
    
    /**
     * Constructor de la clase Reportes, se encarga de hacer una copia del heap de la clase Menus
     * @param menus 
     */
    public Reportes(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelReportes);
        
    }
    /**
     * Sobre escritura del constructor de la clase Reportes, se encarga de hacer una copia del heap de la clase Menus
     * elige el panel a mostrar
     * @param menus 
     */
    public Reportes(Menus menus, Partida partida){
        setMenus(menus);
        menus.agregarVentana(panelReportes);
        this.partida = partida;
        this.mostrarPanelMP = false;
    }
    /**
     * Metodo principal donde se generan los botones a utilizar
     */
    public void reportes(){
        String[] titulos = {"VEHICULOS", "BATALLAS", "MEJOR V.", "PEOR V.", "EXPORTAR", "REGRESAR"};
        modificarPanel(panelReportes);
        agregarBotones(panelReportes, botonesReportes, titulos, 20, 300, 120, 20);
        establecerAreasTexto();       
    }
    
    /**
     * Sobre-escritura del metodo agregarAccionBoton de la clase Menus, i es el tipo de accion y boton es el boton a colocar la accion
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
                        System.out.println("VEHICULOS");      
                        reiniciarAreaTextoVehiculos(0);
                        break;
                    case 1:
                        System.out.println("BATALLAS");                        
                        break;    
                    case 2:
                        System.out.println("MEJOR V.");                        
                        break;
                    case 3:
                        System.out.println("PEOR V.");                        
                        break;
                    case 4:
                        System.out.println("EXPORTAR");                        
                        break;                       
                    case 5:
                        System.out.println("REGRESAR");
                        panelReportes.setVisible(false);
                        if(mostrarPanelMP)
                            menus.panelMP.setVisible(true);
                        else
                            partida.panelPartida.setVisible(true);
                        break;                   
                }
            }
        };        
        boton.addActionListener(accion);
    }
    public void modificarAreaTexto(JTextArea areaTexto, int x, int y){
        
        areaTexto.setBackground(Color.DARK_GRAY);
        areaTexto.setForeground(Color.CYAN);
        areaTexto.setBounds(x, y, 120, 200);
        panelReportes.add(areaTexto);
    
    }
    public void establecerAreasTexto(){
        modificarAreaTexto(areaTextoVehiculos, 160, 20);
        modificarAreaTexto(areaTextoTipoVehiculos, 280, 20);
    }
    
    public void reiniciarAreaTextoVehiculos(int idJugador){        
        areaTextoVehiculos.setText(null);
        areaTextoTipoVehiculos.setText(null);
        for(int i = 0; i < menus.datos.getSizeNombreVehiculos(idJugador); i++){
            areaTextoVehiculos.append(menus.datos.getNombreVehiculo(idJugador, i)+"\n");
            areaTextoTipoVehiculos.append(menus.datos.getTipoVehiculo(idJugador, i)+"\n");
        }
    }
}
