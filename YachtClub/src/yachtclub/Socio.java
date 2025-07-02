
package yachtclub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Socio extends Usuario implements MenuUsuario {

	private LocalDate fechaIngreso;
	private ArrayList<Embarcacion> embarcaciones;
	private ArrayList<CompraAmarre> amarresPropios;

	public Socio(String nombre, int codigo, int dni, int telefono, Direccion direccion, LocalDate fechaIngreso) {
		super(nombre, codigo, dni, telefono, direccion);

		this.fechaIngreso = fechaIngreso;
		this.embarcaciones = new ArrayList<>();
		this.amarresPropios = new ArrayList<>();

	}

	public void agregarEmbarcacion(Embarcacion e) {
		embarcaciones.add(e);
		System.out.println("Embarcacion " + e.getNombre() + " agregada al socio " + this.getNombre());
	}

	public void comprarAmarre(Amarre amarreComprado, LocalDate fecha) {
		amarresPropios.add(new CompraAmarre(fecha, amarreComprado));
	}

	public void verEmbarcaciones() {
		System.out.println("Embarcaciones de " + this.getNombre() + ":");
		if (embarcaciones.isEmpty()) {
			System.out.println("No posee embarcaciones registradas a su nombre.");
		} else {
			for (Embarcacion emb : embarcaciones) {
				System.out.println(emb);
			}
		}
	}

	public void verAmarresPropios() {
		System.out.println(" Amarres propios de " + this.getNombre() + ":");
		if (amarresPropios.isEmpty()) {
			System.out.println("No posee amarres propios.");
		} else {
			for (CompraAmarre ca : amarresPropios) {
				System.out.println(ca);
			}
		}
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Fecha de ingreso: " + fechaIngreso);
	}

	@Override
	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);

		int opcion;
		String titulo = "-----Menú Socio-----";
		ArrayList<String> opcionesMenu = new ArrayList<>(List.of("Ver amarres propios","Ver embarcaciones propias","Salir"));
		do {
			opcion = elegirOpcionMenu(opcionesMenu,titulo);

			switch (opcion) {
			case 1:
				verAmarresPropios();
				break;
			case 2:
				verEmbarcaciones();
				break;
			}

		} while (opcion != opcionesMenu.size());
		System.out.println("Saliendo del menu de socio....");
	}

	public Embarcacion buscarEmbarcacion(String numeroEmbarcacion) {
		Embarcacion embarcacionEncontrado = null;
		int i = 0;
		while (i < embarcaciones.size() && !embarcaciones.get(i).mismaMatricula(numeroEmbarcacion))
			i++;
		if (i < embarcaciones.size())
			embarcacionEncontrado = embarcaciones.get(i);
		return embarcacionEncontrado;

	}

	public Amarre buscarAmarreLibre() {
		Amarre amarreEncontrado = null;
		int i = 0;
		while (i < amarresPropios.size() && !amarresPropios.get(i).estaDisponible())
			i++;
		if (i < amarresPropios.size())
			amarreEncontrado = amarresPropios.get(i).getAmarre();
		return amarreEncontrado;
	}
}
