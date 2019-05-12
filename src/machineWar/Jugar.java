package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.*;

public class Jugar extends Menus{
    private JButton[] botonesJugar = new JButton[3];
    public JPanel panelJugar = new JPanel();  
    protected Nuevo nuevo;
    protected Cargar cargar;
    
    /**
     * Constructor de la clase Jugar, se encarga unicamente de hacer una copia del Heap del objeto menus de tipo Menus
     * @param menus 
     */
    public Jugar(Menus menus){    
        setMenus(menus);
        menus.agregarVentana(panelJugar);
    }
    
    /**
     * Metodo donde se hace uso de varios metodos de la clase Menus para crear los botones y agregarlo a la ventana
     */
    public void jugar (){        
        String[] titulos = {"NUEVO", "CARGAR", "SALIR"};
        agregarComponentes(panelJugar, botonesJugar, titulos);   
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
               menus.jugar.panelJugar.setVisible(false);               
                switch(i){
                    case 0:
                        System.out.println("NUEVO");
                        nuevo = new Nuevo(menus);    
                        nuevo.nuevo();
                        break;
                    case 1:
                        System.out.println("CARGAR");
                        cargar = new Cargar(menus);
                        cargar.cargar();
                        break;
                    case 2:
                        System.out.println("SALIR");
                        panelJugar.setVisible(false);
                        menus.panelMP.setVisible(true);
                        break;                   
                }
            }
        };        
        boton.addActionListener(accion);
    }   
    
    
}
