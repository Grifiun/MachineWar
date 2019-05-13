
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cargar extends Menus{
    private JButton[] botonesCargar = new JButton[2];
    protected JPanel panelCargar = new JPanel();
    private JComboBox listaJugadores;
    /**
     * Constructor de Datos, hace la copia del heap y carga datos
     * @param menus 
     */
    public Cargar(Menus menus){        
        this.menus = menus;
        menus.agregarVentana(panelCargar);
        menus.datos.cargarDatos();
    }
    /**
     * Crea los botones del panel
     */
    public void cargar(){
        String[] titulos = {"CARGAR D.", "REGRESAR"};
        setTitulos(titulos);       
        agregarComponentes(panelCargar, botonesCargar, titulos);
        crearListaJugadores();
    }
    /**
     * Sobre escribe las acciones que tendrán los botones
     * @param i
     * @param boton 
     */
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCargar.setVisible(false);
                switch(i){
                    case 0:
                        System.out.println("CARGAR P."); 
                        menus.setIdJug1(listaJugadores.getSelectedIndex());
                        menus.partida = new Partida(menus);                       
                        menus.partida.partida();
                        break;
                    case 1:
                        /*partida = new Partida(menus);                            
                        partida.partida();**/
                        
                        menus.panelMP.setVisible(true);
                        break;                    
                }
            }
        };        
        boton.addActionListener(accion);
    }
    private void crearListaJugadores(){
        listaJugadores = new JComboBox();
        for(int i = 0; i < menus.datos.getSizeListaJugadores(); i++){
            listaJugadores.addItem(menus.datos.getNombreJugador(i));
        }
        listaJugadores.setBackground(Color.DARK_GRAY);
        listaJugadores.setForeground(Color.CYAN);
        listaJugadores.setBounds(350, 300, 100, 20);
        panelCargar.add(listaJugadores);
    }
}
