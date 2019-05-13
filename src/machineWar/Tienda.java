/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author guatemla
 */
class Tienda extends Menus{
    protected JPanel panelTienda = new JPanel();
    private JButton[] botonesTienda = new JButton[5];
    protected CrearArmas crearArmas;
    protected CrearVehiculos crearVehiculos;
    private JTextArea listadoArmasTanques, listadoArmasAviones;
    
    public Tienda(Menus menus){
        this.menus = menus;
        menus.agregarVentana(panelTienda);
    }
    
    public void tienda(){
        String[] titulos = {"CR. ARMAS", "CR. VEHICULOS", "LIST. AR.", "POCIONES", "REGRESAR"};
        agregarComponentes(panelTienda, botonesTienda, titulos); 
        crearListados();
    }
    
    @Override
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(i){
                    case 0:
                        panelTienda.setVisible(false);
                        crearArmas = new CrearArmas(menus);
                        crearArmas.crearArmas();
                        break;
                    case 1:  
                        panelTienda.setVisible(false);
                        crearVehiculos = new CrearVehiculos(menus);
                        crearVehiculos.crearVehiculos();
                        break;                    
                       
                    case 2:
                        listadoArmasTanques.setVisible(true);
                        listadoArmasAviones.setVisible(true);
                        reiniciarDatosListados();
                        break;
                    case 3:
                        break;
                    case 4:    
                        panelTienda.setVisible(false);
                        menus.partida.panelPartida.setVisible(true);
                        break;     
                }
            }
        };                            
        boton.addActionListener(accion);
    }
    
    public void reiniciarDatosListados(){
        listadoArmasTanques.setText(null); listadoArmasTanques.append("TANQUES\n");
        listadoArmasAviones.setText(null); listadoArmasAviones.append("AVIONES\n");
        for(int i = 0; i < menus.datos.armas.size(); i++){
            listadoArmasTanques.append("D: "+menus.datos.armas.get(i).getAtaque()+"  PUN: "+menus.datos.armas.get(i).getPunteria()+"\n");
        }
        
        for(int i = 0; i < menus.datos.armasAviones.size(); i++){
            listadoArmasAviones.append("D: "+menus.datos.armasAviones.get(i).getAtaque()+" PUN: "+menus.datos.armasAviones.get(i).getPunteria()+" VEL: "+menus.datos.armasAviones.get(i).getVelocidad()+"\n");
        }
    }
    
    public void crearListados(){
        
        listadoArmasTanques = new JTextArea();
        listadoArmasTanques.setBackground(Color.DARK_GRAY);
        listadoArmasTanques.setForeground(Color.CYAN);
        listadoArmasTanques.setBounds(250, 50, 200, 200);
        listadoArmasTanques.setVisible(false);        
        panelTienda.add(listadoArmasTanques);
        
        listadoArmasAviones = new JTextArea();
        listadoArmasAviones.setBackground(Color.DARK_GRAY);
        listadoArmasAviones.setForeground(Color.CYAN);
        listadoArmasAviones.setBounds(450, 50, 200, 200);
        listadoArmasAviones.setVisible(false);        
        panelTienda.add(listadoArmasAviones);
    }    
    
}
