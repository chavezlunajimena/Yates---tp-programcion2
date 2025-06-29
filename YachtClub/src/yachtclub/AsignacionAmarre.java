
package yachtclub;

import java.time.LocalDate;

/// utiliza en admin para asignar amarre
class AsignacionAmarre {
    private LocalDate fechaAsignacion;
    private Embarcacion embarcacion;
    private Amarre amarre;

    public AsignacionAmarre(Embarcacion embarcacion, Amarre amarre,LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
        this.embarcacion = embarcacion;
        this.amarre = amarre;
    }
    
    
}
