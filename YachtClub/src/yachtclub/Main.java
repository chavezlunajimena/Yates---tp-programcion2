
package yachtclub;

public class Main {
    public static void main(String[] args) {
        //Conecto a la base de datos
        BaseDeDatos bd = new BaseDeDatos();

        //agrego socio
        bd.agregarUsuario("socio1", 1, 1, 1234567891, "Puerto Madero", 100, "CABA", java.time.LocalDate.now());
        bd.agregarUsuario("socio2", 6, 6, 1234567891, "Puerto Madero", 100, "CABA", java.time.LocalDate.now());
        bd.agregarUsuario("socio3", 5, 5, 1234567891, "Puerto Madero", 100, "CABA", java.time.LocalDate.now());
        //empleado
        bd.agregarUsuario("empleado1", 2, 2, 1160105487, "Rivadavia", 9100, "CABA", "mantenimiento");
        //admin
        bd.agregarUsuario("admin1", 3, 3, 1160134487, "Ayacucho", 300, "CABA");
        bd.agregarZona("A", "yate", 23, 455);
        bd.agregarZona("B", "bote", 23, 455);
        bd.agregarAmarre(2, true, 10, 10,"A");
        bd.agregarAmarre(22, true, 20, 20,"A");
        bd.agregarAmarre(1, true, 20, 20,"A");
        UsuarioSistema sistema = new UsuarioSistema(bd);
        sistema.ejecutar();

    }
    
}
