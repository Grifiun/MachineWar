
package machineWar;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menus extends JFrame{
    private JButton[] botonesMP = new JButton[4];    
    protected Menus menus;
    protected Jugar jugar;
    protected PVP pvp;
    protected Reportes reportes;   
    protected Datos datos = new Datos();
    protected JPanel panelMP = new JPanel();      
    private String titulos[] = {"JUGAR", "PVP", "REPORTES", "SALIR"};    
    
    /**
     * Contructor de la clase Menus
     */
    public Menus (){        
        this.setSize(800, 800); // Crea una ventana de tamano acorde al usuario
        this.setTitle("WAR MACHINE");// Agregamos un titulo a la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// Terminar programa al cerrar la ventana
        this.setLocationRelativeTo(null);// Centrar ventana al centro          
        agregarComponentes(panelMP, botonesMP, titulos);
        agregarVentana(panelMP);
    }
    
    /**
     * Metodo encargado de llamar a los metodos modificarPanel y agregarBotones, recibe y envia a los metodos mencionados los siguientes parametros
     * @param panel
     * @param boton
     * @param titulos 
     */
    public void agregarComponentes(JPanel panel, JButton[] boton, String[] titulos){
        modificarPanel(panel);   
        agregarBotones(panel, boton, titulos);           
    }
    
    /**
     * Cambia el color el color de fondo, desactiva el diseno y muestra el panel recibido como parametro
     * @param panel 
     */
    public void modificarPanel(JPanel panel){
        panel.setBackground(Color.DARK_GRAY); // Le cambiamos el color al panel a Gris Oscuro      
        panel.setLayout(null); // Desactivar diseño 
        panel.setVisible(true); // Mostar Panel
    }
    
    /**
     * Un metodo que genera varios botones, recibe varios parametros que son enviados al metodo crearBoton
     * @param panel
     * @param botones
     * @param titulos 
     */
    public void agregarBotones(JPanel panel, JButton[] botones, String[] titulos){             
        for(int i = 0; i < titulos.length; i++){
            crearBoton(i, titulos[i], panel, botones[i]);
        }        
    }
    
    /**
     * Un metodo que genera varios botones con mas parametros, recibe varios parametros que son enviados al metodo crearBoton
     * @param panel
     * @param botones
     * @param titulos
     * @param posX
     * @param posY
     * @param tamX
     * @param tamY 
     */
    public void agregarBotones(JPanel panel, JButton[] botones, String[] titulos, int posX, int posY, int tamX, int tamY){             
        for(int i = 0; i < titulos.length; i++){
            crearBoton(i, titulos[i], panel, botones[i], posX, posY, tamX, tamY);
        }        
    }
    
    /**
     * Metodo para crear un boton y colocarlo en el panel, i es el tipo de accion que tendra el boton, titulo lo que tendra escrito el boton, panel donde se colocara
     * @param i
     * @param titulo
     * @param panel
     * @param botones 
     */
    public void crearBoton(int i, String titulo, JPanel panel, JButton botones){
        botones = new JButton(titulo);
        botones.setBounds(350, 330 + 25 * i, 100, 20);
        botones.setForeground(Color.CYAN);
        botones.setBackground(Color.DARK_GRAY);
        agregarAccionBoton(i, botones);
        panel.add(botones);        
    }
    
    /**
     * Metodo para crear un boton y colocarlo en el panel, es mas especifico que el otro porque recibe mas parametros,  i es el tipo de accion que tendra el boton, titulo lo que tendra escrito el boton, panel donde se colocara
     * @param i
     * @param titulo
     * @param panel
     * @param botones
     * @param posX
     * @param posY
     * @param tamX
     * @param tamY 
     */
    public void crearBoton(int i, String titulo, JPanel panel, JButton botones, int posX, int posY, int tamX, int tamY){
        botones = new JButton(titulo);
        botones.setBounds(posX, posY + 25 * i, tamX, tamY);
        botones.setForeground(Color.CYAN);
        botones.setBackground(Color.DARK_GRAY);
        agregarAccionBoton(i, botones);
        panel.add(botones);        
    }
    
    /**
     * Agrega un accion de tipo i cuando se pulsa un boton
     * @param i
     * @param boton 
     */
    public void agregarAccionBoton(int i, JButton boton){
        ActionListener accion = new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMP.setVisible(false);
                switch(i){
                    case 0:                        
                        jugar = new Jugar(menus);                                                                  
                        jugar.jugar();                        
                        break;
                    case 1:
                        pvp = new PVP(menus);
                        pvp.pvp();
                        break;
                    case 2:
                        reportes = new Reportes(menus);
                        reportes.reportes();
                        
                        break;
                    case 3:
                        System.out.println("salir");
                        
                        break;
                }
            }
        };        
        boton.addActionListener(accion);
    }
        
    /**
     * cambia el valor del vector de tipo String titulos
     * @param titulos 
     */
    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }
    
    /**
     * Retorna el String en la posicion i del vector String titulos
     * @param i
     * @return 
     */
    public String getTitulos(int i){
        return titulos[i];
    }

    /**
     * Retorna el panelMP (panel del menu principal)
     * @return 
     */
    public JPanel getPanelMP() {
        return panelMP;
    }    
    
    /**
     * Recibe un parametro de tipo panel que se agrega a la ventana
     * @param panel 
     */
    public void agregarVentana(JPanel panel){
        this.getContentPane().add(panel);
    }
    
    /**
     * Modifica el objeto menus de tipo Menus
     * @param menus 
     */
    public void setMenus(Menus menus) {
        this.menus = menus;
    }
    
}
