package machineWar;

import java.util.ArrayList;
import java.util.List;

public class Vehiculos {
    private String nombreVehiculo;
    private int puntosVida;
    private int puntosPoder;
    private int nivel;
    private int experiencia;    
    private int defensa;
    private int ataque;
    private double punteria;
    private boolean estado;
    private int expRequerido;
    private String tipoVehiculo;
    private List<List<String>> enemigosDerrotados = new ArrayList<>();
    private List<List<String>> vecesDestruido = new ArrayList<>();
    /**
     * Construcr de la clase vehiculos, recibe el nombre del vehiculo a crear y creo un vehiculo con stats iniciales
     * @param nombreVehiculo 
     */
    public Vehiculos(String nombreVehiculo, String tipoVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
        this.tipoVehiculo = tipoVehiculo;
        this.puntosVida = 50;
        this.puntosPoder = 5;
        this.nivel = 1;
        this.experiencia = 0;
        this.estado = true;    
        this.expRequerido = 60 + 40*this.nivel;
    }
    /**
     * Establecemos el nombre que tendrá el vehiculo
     * @param nombreVehiculo 
     */
    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }
    /**
     * Modifica los valores de la vida
     * @param puntosVida 
     */
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    /**
     * Modifica los puntos de poder
     * @param puntosPoder 
     */
    public void setPuntosPoder(int puntosPoder) {
        this.puntosPoder = puntosPoder;
    }
    /**
     * Modifica el nivel
     * @param nivel 
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    /**
     * Modifica la experiencia
     * @param experiencia 
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    /**
     * Modifica la defensa
     * @param defensa 
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    /**
     * Modifica el ataque
     * @param ataque 
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    /**
     * Modifica la punteria
     * @param punteria 
     */
    public void setPunteria(double punteria) {
        this.punteria = punteria;
    }
    /**
     * Modifica el estado del vehiculo "verdadero/falso"
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    /**
     * Modifica la cantidad de experiencia necesaria para subir de nivel
     * @param expRequerido 
     */
    public void setExpRequerido(int expRequerido) {
        this.expRequerido = expRequerido;
    }
    /**
     * Modifica el tipo de vehículo
     * @param tipoVehiculo 
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    /**
     * Modifica el nivel y con ello varios valores del vehiculo
     * @param nivel 
     */    
    public void modificarNivel(int nivel){
        this.puntosVida = 50 * nivel;
        this.puntosPoder = 3 + (2 * nivel);
        this.nivel = nivel;       
        this.expRequerido = 100 + (50 * nivel);
        this.ataque += 2;
        this.defensa += 1;
        this.punteria += 1/2;
    }
    /**
     * Retorna el nombre del vehiculo
     * @return 
     */
    public String getNombreVehiculo() {
        return nombreVehiculo;
    }
    /**
     * Retorna los puntos de vida del vehiculo
     * @return 
     */
    public int getPuntosVida() {
        return puntosVida;
    }
    /**
     * Retorna los puntos de poder del vehiculo
     * @return 
     */
    public int getPuntosPoder() {
        return puntosPoder;
    }
    /**
     * Retorna el nivel del vehiculo
     * @return 
     */
    public int getNivel() {
        return nivel;
    }
    /**
     * Retorna la experiencia del vehiculo
     * @return 
     */
    public int getExperiencia() {
        return experiencia;
    }
    /**
     * Retorna la defensa del vehiculo
     * @return 
     */
    public int getDefensa() {
        return defensa;
    }
    /**
     * Retorna el ataque del vehiculo
     * @return 
     */
    public int getAtaque() {
        return ataque;
    }
    /**
     * Retorna la punteria del vehiculo
     * @return 
     */
    public double getPunteria() {
        return punteria;
    }
    /**
     * Retorna el estado del vehiculo
     * @return 
     */
    public boolean isEstado() {
        return estado;
    }
    /**
     * Retorna la cantidad de exp necesaria para la subida de nivel del vehiculo
     * @return 
     */
    public int getExpRequerido() {
        return expRequerido;
    }
    /**
     * Retorna la cantidad de enemigos derrotados por el vehiculo
     * @return 
     */
    public int getEnemigosDerrotados() {
        return enemigosDerrotados.size();
    }
    /**
     * Retorna la cantidad de veces que el vehiculo ah sido destruido
     * @return 
     */
    public int getVecesDestruido() {
        return vecesDestruido.size();
    }
    /**
     * Retorna el tipo de vehiculo
     * @return 
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    
    
    
}
