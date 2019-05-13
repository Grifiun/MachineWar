package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author guatemla
 */
class CrearArmas extends Menus{
    protected JPanel panelCrearArmas = new JPanel();
    private JButton[] botonesCrearArmas = new JButton[2];
    private JTextField[] cuadrosTexto = new JTextField[3];
    private JLabel[] mensajes= new JLabel[3];
    /**
     * Se hace una referencia al Heap de Menus
     * @param menus 
     */
    public CrearArmas(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelCrearArmas);
    }
    
    /**
     * Se crean los botones iniciales del menu
     */
    public void crearArmas (){        
        String[] titulos = {"CREAR", "REGRESAR"};
        agregarComponentes(panelCrearArmas, botonesCrearArmas, titulos);
        crearCuadrosTexto();
        crearLabels();
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
                
                switch(i){
                    case 0:
                        System.out.println(cuadrosTexto[0].getText());
                        String palabra = cuadrosTexto[0].getText(), palabra2 = cuadrosTexto[1].getText(), palabra3 = cuadrosTexto[2].getText();
                        
                        if(palabra.length() == 0 || palabra2.length() == 0) {                           
                            JOptionPane.showMessageDialog(null, "INGRESA POR LO MENOS EL DANO Y LA PUNTERIA");
                        }
                        else{
                            if(palabra3.length() == 0)
                                menus.datos.addArmas(5, 5);
                            else
                                menus.datos.addArmas(5, 5, 1.2);
                        }
                        break;
                    case 1:                        
                        panelCrearArmas.setVisible(false);
                        menus.partida.panelPartida.setVisible(true);
                        break;     
                }
            }
        };                            
        boton.addActionListener(accion);
    }
    
    public void crearCuadrosTexto(){
        for(int i = 0; i < 3; i++){
            crearCuadroTexto(i);
        }        
    }
    
    public void crearCuadroTexto(int i){
        JTextField aux = new JTextField();
        aux.setBackground(Color.DARK_GRAY);
        aux.setForeground(Color.CYAN);
        aux.setBounds(350, 205 + 50 * i, 100, 20);
        this.cuadrosTexto[i] = aux;
        panelCrearArmas.add(cuadrosTexto[i]);
    }
    
    public void crearLabels(){
        for(int i = 0; i < 3; i++){
            crearLabel(i);
        }        
    }
    
    public void crearLabel(int i){
        String[] m ={"DANO", "PUNTERIA", "VELOCIDAD"};
        JLabel aux = new JLabel();
        aux.setBackground(Color.DARK_GRAY);
        aux.setForeground(Color.CYAN);
        aux.setBounds(360, 183 + 50 * i, 100, 20);
        aux.setText(m[i]);
        this.mensajes[i] = aux;
        panelCrearArmas.add(mensajes[i]);
    }
    
}
