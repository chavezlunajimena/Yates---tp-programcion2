
package yachtclub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Socio extends Usuario {
    
    private LocalDate fechaIngreso;
    private List<Embarcacion> embarcaciones;
    private List<CompraAmarre> amarresPropios;
    

    public Socio(String nombre, int codigo, int dni, int telefono, Direccion direccion, LocalDate fechaIngreso) {
        super(nombre, codigo, dni, telefono, direccion);
        
        this.fechaIngreso= fechaIngreso;
        embarcaciones = new ArrayList<>();// inicializa los arrays
        amarresPropios = new ArrayList<>();//
        
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public List<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    public List<CompraAmarre> getAmarresPropios() {
        return amarresPropios;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    /**
     *
     * @param e
     */
    public void agregarEmbarcacion(Embarcacion e){
        embarcaciones.add(e);
    }
    
    public void comprarAmarre(CompraAmarre ca){
        amarresPropios.add(ca);
    }
    
    public void verEnbarcaciones(){//metodo para mostrar el array de embarcaciones
        System.out.println("Embarcaciones de " + this.getNombre() + ":");
        if(embarcaciones.isEmpty()){
            System.out.println("No posee embarcaciones registradas a su nombre.");
        }else{
            for (Embarcacion emb : embarcaciones) {
                System.out.println(emb);
            }
        }
        
    }
    
    public void verAmarresPropios(){//muestra el array de amarres
        System.out.println(" Amarres propios de " + this.getNombre() + ":");
        if(amarresPropios.isEmpty()){
            System.out.println("No posee amarres propios.");
        }else{
            for (CompraAmarre ca : amarresPropios) {
                System.out.println(ca);
            }
        }
    }
    
    public void agregarEmbarcacion (Embarcacion e){// para agregar embarcaciones que recibe por parametro al array 
        
        embarcaciones.add(e);
    }
    
    public void comprarAmarre( CompraAmarre ca){// agrega ammarres al array al comprar
        
        amarresPropios.add(ca);
    }
    ///////falta poner un metodo para ver zonas de las embarcaiones o amarres? hay que hacerlo aca o en embarcacion?
    
}
