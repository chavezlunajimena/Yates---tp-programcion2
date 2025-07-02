
package yachtclub;

import java.time.LocalDate;
import java.util.Date;


public class CompraAmarre {
    private LocalDate fechaCompra;
    private Amarre amarre;

    public CompraAmarre(LocalDate fechaCompra, Amarre amarre) {
        this.fechaCompra = fechaCompra;
        this.amarre = amarre;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public Amarre getAmarre() {
        return amarre;
    }

    @Override
    public String toString() {
        return "Compra de " + amarre + " | Fecha: " + fechaCompra;
    }

	public boolean estaDisponible() {
		return !this.amarre.isOcupado();
	}

    
    
    
    
}
