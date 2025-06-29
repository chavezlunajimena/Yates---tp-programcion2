
package yachtclub;

import java.util.Scanner;


public class UsuarioSistema {
    private BaseDatosUsuarios bdUsuarios;
    private Scanner sc;

    public UsuarioSistema(BaseDatosUsuarios bdUsuarios) {
        this.bdUsuarios = bdUsuarios;
        this.sc = sc;
    }
    
    public void run(){
        System.out.println("----Bienvenido al Sistema del Yacht Club----");
        
        System.out.println("Ingrese su DNI: ");
        int dni = sc.nextInt();
        
        System.out.println("Ingrese su codigo: ");
        int codigo = sc.nextInt();
        
        Usuario usuario = bdUsuarios.autenticarUsuario(dni, codigo);
        
        if(usuario != null){
            System.out.println("Autenticacion exitosa. Bienvenido/a " + usuario.getNombre());
            mostrarMenu(usuario);
        }else{
            System.out.println("Autenticacion fallida. DNI o codigo incorrecto. ");
        }
    }
    
    public void mostrarMenu(Usuario usuario){
        if(usuario instanceof Administrador){
            menuAdministrador((Administrador) usuario);
        }else if(usuario instanceof Empleado){
            menuEmpleado((Empleado) usuario);
        }else if(usuario instanceof Socio){
            menuSocio((Socio) usuario);
        }else{
            System.out.println("Tipo de usuario desconocido.");
        }
    }
    
    private void menuAdministrador(Administrador admin){
        System.out.println("-----Menu Administrador-----");
        System.out.println("1. Asignar embarcacion");
        System.out.println("2. Registrar compra de amarre");
        System.out.println("3. ver todas las embarcaciones");
        System.out.println("4. Salir");
        
        //implementar el switch de las opcionesss me dio fiaca
    }
    
    private void menuEmpleado(Empleado emp){
        System.out.println("-----Menu Empleado-----");
        System.out.println("1. Consultar zonas asignadas");
        System.out.println("2. Consultar embarcaciones en zona");
        System.out.println("3. Salir");
        
        //implementar el switch de las opcionesss me dio fiaca
    }
    
    private void menuSocio(Socio socio){
        System.out.println("-----Menú Socio-----");
        System.out.println("1. Ver amarres propios");
        System.out.println("2. Ver embarcaciones propias");
        System.out.println("3. Salir");
        
        //implementar el switch de las opcionesss me dio fiaca
    }
    
   

  


  
 
  
}
