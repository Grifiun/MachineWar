
package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author guatemla
 */
public class PVE extends Menus{
    private JButton[] botonesPVE = new JButton[4];
    protected JPanel panelPVE = new JPanel();  
    protected Escenarios escenarios;
    protected PVE pve;
    /**
     * Contructor de la clase PVE, se encarga de hacer una copia del heap de la clase Menus
     * @param menus 
     */
    public PVE(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelPVE);
    }
    
    /**
     * Metodo principal de la clase PVE, se encarga de crear los botones necesarios
     */
    public void pve (){        
        String[] titulos = {"ESCE. 1", "ESCE. 2", "ESCE. 3"};
        setTitulos(titulos);       
        agregarComponentes(panelPVE, botonesPVE, titulos);
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
                panelPVE.setVisible(false);
                switch(i){
                    case 0:
                        System.out.println("ESCE. 1"); 
                        escenarios = new Escenarios(menus, pve, 4, 4);
                        escenarios.escenarios();
                        break;
                    case 1:
                        System.out.println("ESCE. 2");
                        escenarios = new Escenarios(menus, pve, 6, 4);
                        escenarios.escenarios();
                        break;
                    case 2:
                        System.out.println("ESCE. 3");
                        escenarios = new Escenarios(menus, pve, 8, 9);
                        escenarios.escenarios();
                        break;
                    case 3:
                        System.out.println("REGRESAR");
                        break;
                }
            }
        };        
        boton.addActionListener(accion);
    }
    public void setPve(PVE pve){
        this.pve = pve;
    }
}
