
package yachtclub;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Conecto a la base de datos
        BaseDatosUsuarios bd = new BaseDatosUsuarios();
        
        //creo un socio de prueba con embarcaciones y amarres
        Direccion dirSocio = new Direccion("Puerto Madero", 100, "CABA");
        Socio socio1 = new Socio("Juan Perez", 2222, 33333333, 1166667777, dirSocio, LocalDate.now());

        Dimension dimVelero = new Dimension(3.5, 10);
        Velero velero1 = new Velero("VEL123", "Velero Aurora", dimVelero);

        Dimension dimMoto = new Dimension(1.2, 2.5);
        MotoDeAgua moto1 = new MotoDeAgua("MOT456", "Jet Yamaha", dimMoto);
        
        socio1.AgregarEmbarcacion(velero1);
        socio1.AgregarEmbarcacion(moto1);
        
        Amarre amarre1 = new Amarre(1, true);
        Amarre amarre2 = new Amarre(2, false);
        
        CompraAmarre compra1 = new CompraAmarre(amarre1, LocalDate.now());
        
        //agregar este socio a la base de datos
        bd.agregarUsuario(socio1);
        
        //crear usuarioSistema y ejecutar login + menu
        UsuarioSistema sistema = new UsuarioSistema(bd);
        sistema.run();
        
    }
    
}
