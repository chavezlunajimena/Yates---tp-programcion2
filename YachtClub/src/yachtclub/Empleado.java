
package yachtclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empleado extends Usuario implements MenuUsuario {
	private String especialidad;
	private ArrayList<Zona> zonasAsignadas;
	private ArrayList<Embarcacion> embarcacionesAsignadas;

	public Empleado(String nombre, int codigo, int dni, int telefono, Direccion direccion, String especialidad) {
		super(nombre, codigo, dni, telefono, direccion);
		this.setEspecialidad(especialidad);
		this.zonasAsignadas = new ArrayList<>();
		embarcacionesAsignadas = new ArrayList<>();
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	private void verZonasAsignadas() {
		System.out.println("Zonas asignadas a " + this.getNombre() + ":");
		if (zonasAsignadas.isEmpty()) {
			System.out.println("No tiene zonas asignadas.");
		} else {
			for (Zona z : zonasAsignadas) {
				System.out.println(z);
			}
		}
	}

	public void agregarZonaAsignada(Zona z) {
		zonasAsignadas.add(z);
	}

	@Override
	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		int opcion;
		String titulo = "-----Menú Empleado-----";
		ArrayList<String> opcionesMenu = new ArrayList<>(List.of("Ver zonas asignadas","Ver embarcaciones asignadas por zona","Salir"));
		
		
		


		do {
			opcion = elegirOpcionMenu(opcionesMenu,titulo);

			switch (opcion) {
			case 1:
				this.verZonasAsignadas();
				break;
			case 2:
				for (Zona z : zonasAsignadas) {
					System.out.println(z);
					z.verEmbarcacionesAsignadas(this);
				}
				break;
			}

		} while (opcion != opcionesMenu.size());
		System.out.println("Saliendo del menu de empleado....");
	}

	public void agregarEmbarcacion(Embarcacion embarcacion) {
		embarcacionesAsignadas.add(embarcacion);

	}
}
