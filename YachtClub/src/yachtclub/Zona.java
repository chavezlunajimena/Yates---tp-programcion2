
package yachtclub;

import java.util.ArrayList;
import java.util.List;


public class Zona {
    private String letra;
    private String tipoDeBarco;
    private double profundidad;
    private double anchoAmarre;
    private int cantEmbarcacion;

    public Zona(String letra, String tipoDeBarco, double profundidad, double anchoAmarre, int cantEmbarcacion) {
        this.letra = letra;
        this.tipoDeBarco = tipoDeBarco;
        this.profundidad = profundidad;
        this.anchoAmarre = anchoAmarre;
        this.cantEmbarcacion = cantEmbarcacion;
    }
    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setTipoDeBarco(String tipoDeBarco) {
        this.tipoDeBarco = tipoDeBarco;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setAnchoAmarre(double anchoAmarre) {
        this.anchoAmarre = anchoAmarre;
    }

    public void setCantEmbarcacion(int cantEmbarcacion) {
        this.cantEmbarcacion = cantEmbarcacion;
    }

    public String getTipoDeBarco() {
        return tipoDeBarco;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public double getAncho() {
        return anchoAmarre;
    }

    public int getCantEmbarcacion() {
        return cantEmbarcacion;
    }

    @Override
    public String toString() {
        return "Zona "+ letra + " | Tipo barcos: " + tipoDeBarco + " | Cantidad embarcaciones: " + cantEmbarcacion +
                " | Profundidad: " + profundidad + "m | Ancho amarre: " + anchoAmarre + "m";
    }

   
    
   
    
}
