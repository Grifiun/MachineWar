/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author guatemla
 */
public class TipoBatallas extends Menus{
    protected JPanel panelTipoBatallas = new JPanel();
    private JButton[] botonesTipoBatallas = new JButton[3];
    protected PVE pve;
    /**
     * Constructor de la clase "TipoBatallas", se encarga de la copia del heap de menus
     * @param menus 
     */
    public TipoBatallas(Menus menus) {
        setMenus(menus);   
        menus.agregarVentana(panelTipoBatallas);
    }
    /**
     * Genera los botones que necesita el panel "panelTipoBatallas"
     */
    public void tipoBatllas(){
        String[] titulos = {"PVE", "PVP", "REGRESAR"};        
        agregarComponentes(panelTipoBatallas, botonesTipoBatallas, titulos);
    }
    /**
     * Hace los cambios necesarios para que los botones del panel tengan una acción al ser pulsados
     * @param i
     * @param boton 
     */
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTipoBatallas.setVisible(false);
                switch(i){
                    case 0:
                        pve = new PVE(menus);
                        pve.pve();
                        pve.setPve(pve);
                        break;
                    case 1:                        
                        
                        break;  
                    case 2:                        
                        
                        break; 
                }
            }
        };                            
        boton.addActionListener(accion);
    }
}
