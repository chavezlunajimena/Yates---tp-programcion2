
package yachtclub;

import java.time.LocalDate;


public class Administrador extends Usuario {

    public Administrador(String nombre, int codigo, int dni, int telefono, Direccion direccion) {
        super(nombre, codigo, dni, telefono, direccion);
    }
    
    //asigna embarcacion a un amarre
    public void asignarEmbarcacion(Embarcacion embarcacion, Socio socio){//recibe por parametro 
        socio.agregarEmbarcacion(embarcacion);
        System.out.println("Embarcacion " + embarcacion.getNombre() + " asignada al socio " + socio.getNombre());
    }
    
    //registra compra de amarre
    public void registrarCompraAmarre(Socio socio, CompraAmarre compra){
        socio.comprarAmarre(compra);
        System.out.println("Compra de amarre registrada para el socio " + socio.getNombre());
    }
    
    public void AsignarEmpleadoAZona(Empleado empleado, AsignacionZona asignacion){// para asignar recibe el empleado, zona y la cant de embarcacion
        empleado.agregarZonaAsignada(asignacion);
        System.out.println("Zona " + asignacion.getZona().getLetra()+ "asignada al empleado " + empleado.getNombre());
    }
    
    public void verDatosSocio(Socio socio){
        System.out.println("-----Datos del Socio-----");
        socio.mostrarDatos();
        socio.verEnbarcaciones();
        socio.verAmarresPropios();
    }
}
