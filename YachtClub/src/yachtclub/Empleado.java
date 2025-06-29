
package yachtclub;

import java.util.ArrayList;
import java.util.List;


public class Empleado extends Usuario {
    private String especialidad;
    private List<AsignacionZona> zonaAsignada;// tiene su lista de zonas asignadas

    public Empleado(String nombre, int codigo, int dni, int telefono, Direccion direccion, String especialidad) {
        super(nombre, codigo, dni, telefono, direccion);
        this.especialidad = especialidad;
        this.zonaAsignada = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<AsignacionZona> getZonaAsignada() {
        return zonaAsignada;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    //muestra las zonas asignadas
    public void verZonasAdignadas(){
        System.out.println("Zonas asignadas a " + this.getNombre() + ":");
        if(zonaAsignada.isEmpty()){
            System.out.println("No tiene zonas asignadas.");
        }else{
            for(AsignacionZona az: zonaAsignada){
                System.out.println(az);
            }
        }
    }
    //metodo set para agregar la lista de zonas desde el admin
   public void setZonaAsignada(List<AsignacionZona> zonasAsignadas){
       this.zonaAsignada = zonaAsignada;
   }
   
   //metodo agregar asignacion de zona solo usado por el admin
   public void agregarZonaAsignada(AsignacionZona z){
       zonaAsignada.add(z);
   }
    
}
