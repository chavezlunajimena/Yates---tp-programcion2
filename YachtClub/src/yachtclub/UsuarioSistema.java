
package yachtclub;

import java.util.Scanner;


public class UsuarioSistema {
    private BaseDeDatos bdUsuarios;

    public UsuarioSistema(BaseDeDatos bdUsuarios) {
        this.bdUsuarios = bdUsuarios;
    }
    
    public void ejecutar(){
		Scanner sc = new Scanner(System.in);
        System.out.println("----Bienvenido al Sistema del Yacht Club----");
        
        System.out.println("Ingrese su DNI: (0 = Salir del sistema)");
        int dni = Integer.parseInt(sc.nextLine());
        
        while (dni != 0){
            System.out.println("Ingrese su codigo: ");
            int codigo = Integer.parseInt(sc.nextLine());
        
            Usuario usuario = bdUsuarios.autenticarUsuario(dni, codigo);
        
            if(usuario != null){
                System.out.println("Autenticacion exitosa. Bienvenido/a " + usuario.getNombre());
                usuario.mostrarMenu();
            }else{
                System.out.println("Autenticacion fallida. DNI o codigo incorrecto. ");
            }
            System.out.println("Ingrese su DNI: (0 = Salir del sistema)");
            dni = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Vuelva pronto!!");
    }
}
