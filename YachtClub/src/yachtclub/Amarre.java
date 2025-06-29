
package yachtclub;


public class Amarre {
    private int numero;
    private boolean servicioMantenimiento;
    private boolean ocupado;
    /*private int contadorLuz;
    private int contadorAgua;
    private boolean amarreOcupado;
    */
// constructor donde inicializo los booleanos con falso hasta que lo modifiquen- debe recibir el contador de agua y luz por parametro??
    public Amarre(int numero, boolean servicioMantenimiento /*int contadorLuz, int contadorAgua*/) {
        this.numero = numero;
        this.servicioMantenimiento = servicioMantenimiento;
        this.ocupado = false; // empieza como libre para empezar
        
        /*this.contadorLuz = contadorLuz;
        this.contadorAgua = contadorAgua;
        this.amarreOcupado = false;*/
    }

    public int getNumero() {
        return numero;
    }
   
    public boolean tieneServicioMantenimiento(){
        return servicioMantenimiento;
    }

    public boolean isOcupado(){
        return ocupado;
    }
    
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Amarre #" + numero + " | Servicio mantenimiento: " + servicioMantenimiento + " | Ocupado: " + ocupado;
    }
    
    
}
