package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Partida extends Menus{
    protected JPanel panelPartida = new JPanel();
    private JButton[] botonesPartida = new JButton[4];
    protected TipoBatallas tipoBatallas;
    /**
     * Constructor de la clase Partida
     * @param menus 
     */
    public Partida(Menus menus) {
        setMenus(menus);
        menus.agregarVentana(panelPartida);        
    }
    /**
     * Creacion de los botones utilizados en este panel
     */
    public void partida(){
        String[] titulos = {"BATALLA", "TIENDA", "REPORTES", "SALIR"};        
        agregarComponentes(panelPartida, botonesPartida, titulos);         
    }
    /**
     * Sobre-escritura de las acciones que tendrán los botones generados anteriormente
     * @param i
     * @param boton 
     */
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPartida.setVisible(false);
                switch(i){
                    case 0:
                        tipoBatallas = new TipoBatallas(menus);                        
                        tipoBatallas.tipoBatllas();
                        break;
                    case 1:                        
                        //JOptionPane.showMessageDialog(null, "MENSAJE");
                        break;  
                    case 2:                        
                        reportes = new Reportes(menus, menus.jugar.nuevo.crearJugadores.partida);
                        reportes.reportes();
                        break; 
                    case 3:                        
                        menus.panelMP.setVisible(true);
                        break; 
                }
            }
        };                            
        boton.addActionListener(accion);
    }
}
