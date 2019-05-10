/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

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
    
    /**
     * Constructor de la clase Reportes, se encarga de hacer una copia del heap de la clase Menus
     * @param menus 
     */
    public Reportes(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelReportes);
    }
    
    /**
     * Metodo principal donde se generan los botones a utilizar
     */
    public void reportes(){
        String[] titulos = {"VEHICULOS", "BATALLAS", "MEJOR V.", "PEOR V.", "EXPORTAR", "REGRESAR"};
        agregarComponentes(panelReportes, botonesReportes, titulos);        
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
                        menus.panelMP.setVisible(true);
                        break;                   
                }
            }
        };        
        boton.addActionListener(accion);
    }
}
