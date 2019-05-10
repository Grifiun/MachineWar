package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Nuevo extends Menus{
    protected JPanel panelNuevo = new JPanel();
    private JButton[] botonesNuevo = new JButton[2];
    protected CrearJugadores crearJugadores;
    /**
     * Se hace una referencia al Heap de Menus
     * @param menus 
     */
    public Nuevo(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelNuevo);
    }
    
    /**
     * Se crean los botones iniciales del menu
     */
    public void nuevo (){        
        String[] titulos = {"CREAR", "REGRESAR"};
        agregarComponentes(panelNuevo, botonesNuevo, titulos);
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
                panelNuevo.setVisible(false);
                switch(i){
                    case 0:
                        crearJugadores = new CrearJugadores(menus);
                        crearJugadores.crearJugadores();
                        break;
                    case 1:                        
                        menus.jugar.panelJugar.setVisible(true);
                        break;     
                }
            }
        };                            
        boton.addActionListener(accion);
    }
    
}
