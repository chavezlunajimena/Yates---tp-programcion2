
package yachtclub;

import java.util.Scanner;

public class MenuSocio implements MenuUsuario {
    private Socio socio;
    private static final int verEmb = 1;// pongo los valores de las opciones de menu estaticos y finales
     private static final int verAmarres = 2;
      private static final int verZona = 3;
       private static final int salir = 5;

    public MenuSocio(Socio socio) {/// Recibe el socio por parametro
        this.socio = socio;
    }
    
    @Override
    public void MostrarMenu(){
        int opcion;
        do{
        System.out.println("Mostrar menu del socio: " + socio.getNombre());
        System.out.println("1- Ver embarcaciones propias.");
        System.out.println("2- Ver Amarres Propios: ");
//        System.out.println("3- Ver zona de embarcacion: ");
        System.out.println("4- Salir");
       Scanner sc = new Scanner(System.in);
       opcion = Integer.parseInt(sc.nextLine());
       
       switch(opcion){
           case 1:
               socio.VerEnbarcaciones();
               break;
           case 2: 
               socio.VerAmarresPropios();
               
           case 3: 
             //como hacer para ver la zona
               break;
           default:
               System.out.println("Opcion ingresada invalida, intente nuevamente.");
           
       }
            
        }while(opcion!=salir);// mientras sea distinto de salir vuelve a preguntar las opciones
        
        
    }
    
    
    
    
}
