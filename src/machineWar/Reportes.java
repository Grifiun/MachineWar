/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author guatemla
 */
public class Reportes extends Menus{
    private JButton[] botonesReportes = new JButton[6];
    protected JPanel panelReportes = new JPanel();
    private JTextArea areaTextoVehiculos = new JTextArea();
    private JTextArea areaTextoTipoVehiculos = new JTextArea();
    private JTextArea areaTextoEstadoVehiculos = new JTextArea();
    private JTextArea areaTextoNivelVehiculos = new JTextArea();
    private JTextArea areaTextoEnemigosDerrotados = new JTextArea();
    private JTextArea areaTextoEscenarioEnemigosDerrotados = new JTextArea();
    private JTextArea areaTextoVecesDestruido = new JTextArea();
    private JTextArea areaTextoEscenarioDestruido = new JTextArea();
    private JComboBox listaJugadores;
    private Partida partida;
    private boolean mostrarPanelMP = true;
    
    /**
     * Constructor de la clase Reportes, se encarga de hacer una copia del heap de la clase Menus
     * @param menus 
     */
    public Reportes(Menus menus){
        setMenus(menus);
        menus.agregarVentana(panelReportes);
        menus.datos.cargarDatos();
    }
    /**
     * Sobre escritura del constructor de la clase Reportes, se encarga de hacer una copia del heap de la clase Menus
     * elige el panel a mostrar
     * @param menus 
     */
    public Reportes(Menus menus, Partida partida){
        setMenus(menus);
        menus.agregarVentana(panelReportes);
        this.partida = partida;
        this.mostrarPanelMP = false;
    }
    /**
     * Metodo principal donde se generan los botones a utilizar
     */
    public void reportes(){
        String[] titulos = {"VEHICULOS", "BATALLAS", "MEJOR V.", "PEOR V.", "EXPORTAR", "REGRESAR"};
        modificarPanel(panelReportes);
        agregarBotones(panelReportes, botonesReportes, titulos, 20, 300, 120, 20);
        crearListaJugadores();
        establecerAreasTexto();       
        
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
                        reiniciarAreaTexto(listaJugadores.getSelectedIndex());
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
                        menus.datos.guardarDatos();
                        menus.datos.guardarDatosHTML();
                        break;                       
                    case 5:
                        System.out.println("REGRESAR");
                        panelReportes.setVisible(false);
                        if(mostrarPanelMP)
                            menus.panelMP.setVisible(true);
                        else
                            partida.panelPartida.setVisible(true);
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
        listaJugadores.setBounds(20, 275, 120, 20);
        panelReportes.add(listaJugadores);
    }
    /**
     * rediseña el JTextArea "areaTexto", donde "x" es la posición que tendrá en el eje horizontal y "y" en el eje vertical
     * @param areaTexto
     * @param x
     * @param y 
     */
    public void modificarAreaTexto(JTextArea areaTexto, int x, int y){ 
        areaTexto.setBackground(Color.DARK_GRAY);
        areaTexto.setForeground(Color.CYAN);
        areaTexto.setBounds(x, y, 120, 200);        
        panelReportes.add(areaTexto);
    
    }
    /**
     * Coloca las diversas Areas de texto que se usarán en los Reportes
     */
    public void establecerAreasTexto(){
        modificarAreaTexto(areaTextoVehiculos, 160, 40);         
        modificarAreaTexto(areaTextoTipoVehiculos, 280, 40);
        modificarAreaTexto(areaTextoEstadoVehiculos, 400, 40);         
        modificarAreaTexto(areaTextoNivelVehiculos, 520, 40);   
        modificarAreaTexto(areaTextoEnemigosDerrotados, 160, 250);
        modificarAreaTexto(areaTextoEscenarioEnemigosDerrotados, 280, 250);         
        modificarAreaTexto(areaTextoVecesDestruido, 400, 250);
        modificarAreaTexto(areaTextoEscenarioDestruido, 520, 250);
    }
    
    /**
     * Actualiza los datos de las areas de texto
     * @param idJugador 
     */
    public void reiniciarAreaTexto(int idJugador){        
        areaTextoVehiculos.setText(null); areaTextoVehiculos.append("VEHICULOS\n");
        areaTextoTipoVehiculos.setText(null); areaTextoTipoVehiculos.append("TIPO\n");
        
        areaTextoEstadoVehiculos.setText(null); areaTextoEstadoVehiculos.append("ESTADO\n");
        areaTextoNivelVehiculos.setText(null); areaTextoNivelVehiculos.append("NIVEL\n");
        
        areaTextoEnemigosDerrotados.setText(null); areaTextoEnemigosDerrotados.append("ENEMIGOS DER.\n");
        areaTextoEscenarioEnemigosDerrotados.setText(null); areaTextoEscenarioEnemigosDerrotados.append("ESCENARIO\n");
        
        areaTextoVecesDestruido.setText(null); areaTextoVecesDestruido.append("MUERTES\n");
        areaTextoEscenarioDestruido.setText(null); areaTextoEscenarioDestruido.append("ESCENARIO\n");
        
        for(int i = 0; i < menus.datos.getSizeNombreVehiculos(idJugador); i++){
            areaTextoVehiculos.append(menus.datos.getNombreVehiculo(listaJugadores.getSelectedIndex(), i)+"\n");
            areaTextoTipoVehiculos.append(menus.datos.getTipoVehiculo(listaJugadores.getSelectedIndex(), i)+"\n");
            
            areaTextoEstadoVehiculos.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).isEstado()+"\n");
            areaTextoNivelVehiculos.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).getNivel()+"\n");
            
            areaTextoEnemigosDerrotados.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).getEnemigosDerrotados()+"\n");
            areaTextoEscenarioEnemigosDerrotados.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).getEscenarioEnemigosDerrotados(i)+"\n");
            
            areaTextoVecesDestruido.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).getVecesDestruido()+"\n");
            areaTextoEscenarioDestruido.append(menus.datos.getListaJugadores().get(listaJugadores.getSelectedIndex()).vehiculos.get(i).getEscenarioVecesDestruido(i)+"\n");
        }
    }
    
    
}
