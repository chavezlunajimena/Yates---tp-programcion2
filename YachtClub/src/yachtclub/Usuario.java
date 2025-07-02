
package yachtclub;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario implements MenuUsuario {
	private String nombre;
	private int codigo;
	private int dni;
	private int telefono;
	private Direccion direccion;

	public Usuario(String nombre, int codigo, int dni, int telefono, Direccion direccion) {
		this.setNombre(nombre);
		this.setCodigo(codigo);
		this.setDni(dni);
		this.setTelefono(telefono);
		this.setDireccion(direccion);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private void setDni(int dni) {
		this.dni = dni;
	}

	private void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	private void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void mostrarDatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("DNI: " + dni);
		System.out.println("Telefono: " + telefono);
		System.out.println("Direccion: " + direccion);
		System.out.println(getClass().getSimpleName());
	}

	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}

	public boolean mismoCodigo(int codigo) {
		return this.codigo == codigo;
	}

	public int elegirOpcionMenu(ArrayList<String> opcionesMenu, String titulo) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		mostrarTitulo(titulo);

		mostrarMenu(opcionesMenu);
		opcion = Integer.parseInt(sc.nextLine());
		while (opcion < 1 || opcion > opcionesMenu.size()) {
			System.out.println("Opcion ingresada invalida, intente nuevamente.");
			System.out.println("Debe ser un numero entre 1 y " + opcionesMenu.size());
			mostrarTitulo(titulo);
			mostrarMenu(opcionesMenu);
			opcion = Integer.parseInt(sc.nextLine());
		}
		
		return opcion;
	}

	private void mostrarMenu(ArrayList<String> opcionesMenu) {
		for (int i = 0; i < opcionesMenu.size(); i++) {
			System.out.println((i + 1) + ". " + opcionesMenu.get(i));
		}
	}
	
	private void mostrarTitulo(String titulo) {
		System.out.println(titulo);
	}
}
