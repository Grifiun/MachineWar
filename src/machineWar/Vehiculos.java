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

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setPuntosPoder(int puntosPoder) {
        this.puntosPoder = puntosPoder;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setPunteria(double punteria) {
        this.punteria = punteria;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setExpRequerido(int expRequerido) {
        this.expRequerido = expRequerido;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
        
    public void modificarNivel(int nivel){
        this.puntosVida = 50 * nivel;
        this.puntosPoder = 3 + (2 * nivel);
        this.nivel = nivel;       
        this.expRequerido = 100 + (50 * nivel);
        this.ataque += 2;
        this.defensa += 1;
        this.punteria += 1/2;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getPuntosPoder() {
        return puntosPoder;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public double getPunteria() {
        return punteria;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getExpRequerido() {
        return expRequerido;
    }

    public int getEnemigosDerrotados() {
        return enemigosDerrotados.size();
    }

    public int getVecesDestruido() {
        return vecesDestruido.size();
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    
    
    
}
