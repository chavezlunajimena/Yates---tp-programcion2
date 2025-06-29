
package yachtclub;


class AsignacionZona {
    private int barcosAsignados;
    private Zona zona;

    /// paso el empleado a asignar a la zona con la cantidad de barcos qe se va a encargar
    public AsignacionZona(int barcosAsignados, Empleado empleado, Zona zona) {
        this.barcosAsignados = barcosAsignados;
        this.zona = zona;
    }

    public int getBarcosAsignados() {
        return barcosAsignados;
    }

    public Zona getZona() {
        return zona;
    }

    public void setBarcosAsignados(int barcosAsignados) {
        this.barcosAsignados = barcosAsignados;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    @Override
    public String toString() {
        return "Zona: " + zona.getLetra() + " | Barcos asignados: " + barcosAsignados;
    }


    
    
    
    
    
    
    
}
