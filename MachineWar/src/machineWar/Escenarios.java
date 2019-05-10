
package machineWar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Escenarios extends Menus{
    protected JPanel panelEscenarios = new JPanel();
    private JButton[][] botonesEscenario;
    private JButton[] botonesOpcionesJugador = new JButton[5];
    private int tamanoX, tamanoY;
    protected PVE pve;
    private Random rand = new Random(System.currentTimeMillis());
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
    }
    
    /**
     * Metodo principal de Escenarios
     */
    public void escenarios(){
        String[] titulos = {"MOVERSE", "ATACAR", "CAMBIAR V.", "ITEMS", "RENDIRSE"};
        menus.agregarVentana(panelEscenarios);
        modificarPanel(panelEscenarios);
        crearBotonesTipoEscenario();
        agregarBotones(panelEscenarios, botonesOpcionesJugador, titulos, 650, 140, 120, 20);
    }
    
    /**
     * Crea botones de la matriz botonesEscenario[x][y]
     * @param x
     * @param y 
     */
    private void botonesTipoEscenario(int x, int y){
        JButton boton = new JButton(); // Crea un objeto de tipo JButton
        boton.setBounds(5 + x * 600 / this.tamanoX,5 + y * 600 / this.tamanoX, 600 / this.tamanoX, 600 / this.tamanoX);// Modifica las coordenadas iniciales y el tamaño del boton
        boton.setEnabled(false);
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
                    break;
                case 4:
                    this.botonesEscenario[x][y].setBackground(Color.RED);     
                    break;
                default:
                    this.botonesEscenario[x][y].setBackground(Color.GREEN);       
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
                        
                        break;
                    case 1:                
                        
                        break;
                    case 2:
                        
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
     * set de pve
     * @param pve 
     */
    private void setPve(PVE pve) {
        this.pve = pve;
    }

}
