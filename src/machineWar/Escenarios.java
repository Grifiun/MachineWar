
package machineWar;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Escenarios extends Menus{
    protected Moverse moverse, moverBala;
    protected Escenarios escenarios;
    protected JPanel panelEscenarios = new JPanel();
    private JButton[][] botonesEscenario;
    private String[][] estadoBotonesEscenario;
    private JButton[] botonesOpcionesJugador = new JButton[5];  
    private int vehiculoElegido = 0;
    private ImageIcon tanque = new ImageIcon("tanque.png"), avion = new ImageIcon("avion.png"), tanqueE = new ImageIcon("tanqueE.png"), avionE = new ImageIcon("avionE.png");
    private int tamanoX, tamanoY;
    protected int posX = 0, posY = 0;
    protected PVE pve;
    private Random rand = new Random(System.currentTimeMillis());
    private JComboBox listaElegirVehiculos, listaDireccion;
    private int dirBala;
    
    /**
     * Constructor, crea una copia del heap de Menus
     * @param menus 
     */
    public Escenarios(Menus menus, PVE pve, int tamanoX, int tamanoY) {
        setMenus(menus);
        setPve(pve);
        this.tamanoX = tamanoX; this.tamanoY = tamanoY;  
        menus.agregarVentana(panelEscenarios);
        botonesEscenario = new JButton[tamanoX][tamanoY];
        estadoBotonesEscenario = new String[tamanoX][tamanoY];
    }
    
    /**
     * Metodo principal de Escenarios       
     */
    public void escenarios(){
        String[] titulos = {"MOVER", "ATACAR", "CAMBIAR V.", "ITEMS", "RENDIRSE"};
        menus.agregarVentana(panelEscenarios);
        modificarPanel(panelEscenarios);
        crearBotonesTipoEscenario();
        agregarBotones(panelEscenarios, botonesOpcionesJugador, titulos, 650, 140, 120, 20);
        crearListaDireccion();
        crearListaElegirVehiculos();
    }
    
    /**
     * Crea botones de la matriz botonesEscenario[x][y]
     * @param x
     * @param y 
     */
    private void botonesTipoEscenario(int x, int y){
        JButton boton = new JButton(); // Crea un objeto de tipo JButton
        boton.setBounds(5 + x * 600 / this.tamanoX,5 + y * 600 / this.tamanoX, 600 / this.tamanoX, 600 / this.tamanoX);// Modifica las coordenadas iniciales y el tamaño del boton
        //boton.setEnabled(false);
        this.botonesEscenario[x][y] = boton;// El botones[x][y] copia la referencia de "boton"   
        // Por el azar se elige el tipo de terreno que tendrá el botón
        int azar;
        azar = rand.nextInt(5); azar = rand.nextInt(5);
        colocarTipoTerreno(x, y, azar);         
        rand.setSeed(System.currentTimeMillis());   rand.setSeed(System.currentTimeMillis());  rand.setSeed(System.currentTimeMillis());  rand.setSeed(System.currentTimeMillis());
        this.panelEscenarios.add(botonesEscenario[x][y]);// Se agrega el botones[x][y] al panel        
    }
    /**
     * Le agrega un tipo de terreno al boton "botonesEscenaros" en la pos X,Y
     * @param x
     * @param y
     * @param azar 
     */
    private void colocarTipoTerreno(int x, int y, int azar){
         switch(azar){
                case 3:
                    this.botonesEscenario[x][y].setBackground(Color.CYAN); 
                    this.estadoBotonesEscenario[x][y] = "AGUA";
                    break;
                case 4:
                    this.botonesEscenario[x][y].setBackground(Color.RED);
                    this.estadoBotonesEscenario[x][y] = "MONTANA";
                    break;
                default:
                    this.botonesEscenario[x][y].setBackground(Color.GREEN);
                    this.estadoBotonesEscenario[x][y] = "PASTO";
            }
    }
    /**
     *
     * crea Botones
     * 
     * 
     **/    
    private void crearBotonesTipoEscenario(){
        for(int i = 0; i < this.tamanoX; i++){
            for(int j = 0; j < this.tamanoY; j++){
                botonesTipoEscenario(i,j);
            }
        }
        colocarTipoTerreno(0, 0, 0);
        establecerVehiculo(posX, posY, menus.datos.getListaJugadores().get(menus.getIdJug1()).getTipoVehiculo(0));
        if(getEstadoBotonesEscenario(tamanoX - 1, tamanoY - 1) == "AGUA")
        establecerVehiculo(tamanoX - 1, tamanoY - 1, "AvionE");
        else
        establecerVehiculo(tamanoX - 1, tamanoY - 1, "TanqueE");
        
    }
    /**
     * Sobre escribimos la accion del boton i
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
                        String dir;
                        dir = (String) listaDireccion.getSelectedItem();                        
                        moverse = new Moverse("proceso", escenarios, menus.datos.getTipoVehiculo(menus.getIdJug1(), listaElegirVehiculos.getSelectedIndex()), dir);
                        moverse.run();
                        
                        moverse.pause(700);
                        break;
                    case 1:                
                       
                        break;
                    case 2:
                        System.out.println("CambiarV");
                        if(listaElegirVehiculos.isVisible() == false)
                        listaElegirVehiculos.setVisible(true);
                        else{
                            establecerVehiculo(posX, posY, "");
                            establecerVehiculo(posX, posY, menus.datos.getTipoVehiculo(menus.getIdJug1(), listaElegirVehiculos.getSelectedIndex()));
                            listaElegirVehiculos.setVisible(false);
                        }                        
                        break;
                    case 3:                
                        
                        break;
                    case 4:                
                        panelEscenarios.setVisible(false);
                        pve.panelPVE.setVisible(true);
                        break;                     
                }
            }
        };                            
        boton.addActionListener(accion);
    }
    /**
     * Agregar/quitar vehiculo en las coordenadas (x,y)
     * @param x
     * @param y
     * @param tipoVehiculo 
     */
    public void establecerVehiculo(int x, int y, String tipoVehiculo){
        
        switch(tipoVehiculo){
            case "Tanque":
                botonesEscenario[x][y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(botonesEscenario[0][0].getHeight(), botonesEscenario[0][0].getHeight(), Image.SCALE_SMOOTH)));
                break;
            case "Avion":
                botonesEscenario[x][y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(botonesEscenario[0][0].getHeight(), botonesEscenario[0][0].getHeight(), Image.SCALE_SMOOTH)));
                break;
            case "TanqueE":
                botonesEscenario[x][y].setIcon(new ImageIcon(tanqueE.getImage().getScaledInstance(botonesEscenario[0][0].getHeight(), botonesEscenario[0][0].getHeight(), Image.SCALE_SMOOTH)));
                break;
            case "AvionE":
                botonesEscenario[x][y].setIcon(new ImageIcon(avionE.getImage().getScaledInstance(botonesEscenario[0][0].getHeight(), botonesEscenario[0][0].getHeight(), Image.SCALE_SMOOTH)));
                break;
            case "":
                botonesEscenario[x][y].setIcon(null);
                break;
        }
    }
    /**
     * set de pve
     * @param pve 
     */
    private void setPve(PVE pve) {
        this.pve = pve;
    }
    /**
     * Retorna el valor del tamaño del tablero en X
     * @return 
     */
    public int getTamanoX() {
        return tamanoX;
    }
    /**
     * Retorna el valor del tamaño del tablero en Y
     * @return 
     */
    public int getTamanoY() {
        return tamanoY;
    }
    /**
     * Obtiene que vehiculo esta en las posiciones (x,y)
     * @param x
     * @param y
     * @return 
     */
    public String getEstadoBotonesEscenario(int x, int y){
        return estadoBotonesEscenario[x][y];
    }

    public void setEscenarios(Escenarios escenarios) {
        this.escenarios = escenarios;
    }

    public void setVehiculoElegido(int vehiculoElegido) {
        this.vehiculoElegido = vehiculoElegido;
    }
    
    private void crearListaElegirVehiculos(){
        listaElegirVehiculos = new JComboBox();
        listaElegirVehiculos.setBackground(Color.DARK_GRAY);
        listaElegirVehiculos.setForeground(Color.CYAN);
        listaElegirVehiculos.setBounds(650, 285, 120, 20);
        panelEscenarios.add(listaElegirVehiculos);
        for(int i = 0; i < menus.datos.getSizeNombreVehiculos(menus.getIdJug1()); i++){
            listaElegirVehiculos.addItem(menus.datos.getNombreVehiculo(menus.getIdJug1(), i));
        }
        listaElegirVehiculos.setVisible(false);        
       
    }
     private void crearListaDireccion(){
         listaDireccion = new JComboBox();
         listaDireccion.setBackground(Color.DARK_GRAY);
         listaDireccion.setForeground(Color.CYAN);
         listaDireccion.setBounds(650, 260, 120, 20);
         panelEscenarios.add(listaDireccion);
        
         listaDireccion.addItem("ARRIBA");
         listaDireccion.addItem("ABAJO");
         listaDireccion.addItem("DERECHA");
         listaDireccion.addItem("IZQUIERDA");  
     }
    
    
}
