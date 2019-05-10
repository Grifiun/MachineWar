package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PVP extends Menus{
    private JButton[] botonesPVP = new JButton[2];    
    protected JPanel panelPVP = new JPanel();
    
    /**
     * Constructor de la clase PVP, recibe de parametro una copia de la clase Menus
     * @param menus 
     */
    public PVP(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelPVP);
    }
    
    /**
     * Metodo encargado de la creacion de botones y colocacion del panel sobre la ventana
     */
    public void pvp(){
        String[] titulos = {"BATALLAR", "REGRESAR"};        
        agregarComponentes(panelPVP, botonesPVP, titulos);       
        
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
                        System.out.println("BATALLAR");
                        
                        break;
                    case 1:
                        System.out.println("SALIR");
                        panelPVP.setVisible(false);
                        menus.panelMP.setVisible(true);
                        break;                   
                }
            }
        };        
        boton.addActionListener(accion);
    }
}
