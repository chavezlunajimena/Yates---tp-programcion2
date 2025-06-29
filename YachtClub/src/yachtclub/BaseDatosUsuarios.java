
package yachtclub;

import java.util.ArrayList;
import java.util.List;

// para cargar los usuarios(socio,admin, empleados). y tambien las listas
public class BaseDatosUsuarios{
    private List<Usuario> usuarios;
    
    public BaseDatosUsuarios(){
    usuarios = new ArrayList<>();
    Direccion dir = new Direccion("Lavalle", 123, "CABA");
    usuarios.add(new Socio("admin1", 1234, 94606768, 1234567891, dir, java.time.LocalDate.now()));
    usuarios.add(new Empleado("empleado1", 4321, 45762656, 1160105487, dir, "mantenimiento"));
    usuarios.add(new Administrador("socio1", 4987, 94603456, 1123654569, dir));
    //completar la base de datos generados con chatgpt
    }

    public Usuario autenticarUsuario(int dni, int codigo){
        for(Usuario u: usuarios){
            if(u.getDni() == dni && u.getCodigo() == codigo){
                return u;
            }
        }
        return null;
    }
    
    public void agregarUsuario(Usuario u){
        usuarios.add(u);
    }
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public void mostrarTodosLosUsuarios(){
        System.out.println("-----Lista de usuarios registrados-----");
        for(Usuario u : usuarios){
            System.out.println(u.getNombre() + " | DNI: " + u.getDni() + " | Tipo: " + u.getClass().getSimpleName());
        }
    }
}
