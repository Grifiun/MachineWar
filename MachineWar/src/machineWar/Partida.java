package machineWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Partida extends Menus{
    protected JPanel panelPartida = new JPanel();
    private JButton[] botonesPartida = new JButton[4];
    protected TipoBatallas tipoBatallas;
    public Partida(Menus menus) {
        setMenus(menus);
        menus.agregarVentana(panelPartida);        
    }
    
    public void partida(){
        String[] titulos = {"BATALLA", "TIENDA", "REPORTES", "SALIR"};        
        agregarComponentes(panelPartida, botonesPartida, titulos);         
    }
    
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
                        
                        break;  
                    case 2:                        
                        
                        break; 
                    case 3:                        
                        
                        break; 
                }
            }
        };                            
        boton.addActionListener(accion);
    }
}
