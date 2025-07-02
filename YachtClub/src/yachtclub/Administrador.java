package yachtclub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuario implements MenuUsuario {

	public Administrador(String nombre, int codigo, int dni, int telefono, Direccion direccion) {
		super(nombre, codigo, dni, telefono, direccion);
	}

	public void asignarEmbarcacionAmarre(Embarcacion embarcacion, Socio socio, Amarre amarre) {
		if (!amarre.isOcupado()) {
			embarcacion.setAmarreAsignado(amarre);
			amarre.setEmbarcacion(embarcacion);
			System.out.println("Embarcacion " + embarcacion.getNombre() + " asignada al socio " + socio.getNombre());

		} else {
			System.out.println("Amarre ocupado");
		}
	}

	public void registrarCompraAmarre(Socio socio, Amarre amarrecomprado) {
		socio.comprarAmarre(amarrecomprado, LocalDate.now());
		System.out.println("Compra de amarre registrada para el socio " + socio.getNombre());
	}

	public void asignarEmpleadoAZona(Empleado empleado, Zona asignacion) {
		empleado.agregarZonaAsignada(asignacion);
		System.out.println("Zona " + asignacion.getLetra() + "asignada al empleado " + empleado.getNombre());
	}

	public void verDatosSocio(Socio socio) {
		System.out.println("-----Datos del Socio-----");
		socio.mostrarDatos();
		socio.verEmbarcaciones();
		socio.verAmarresPropios();
	}

	@Override
	public void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		String titulo = "-----Menu Administrador-----";
		ArrayList<String> opcionesMenu = new ArrayList<>(List.of("Asignar un amarre a una embarcacion",
				"Registrar compra de amarre", "Ver todas las embarcaciones", "Asignar embarcacion a Socio",
				"Asignar zona a Empleado", "Asignar embarcacion a Empleado", "Salir"));
		int opcion;
		do {
			opcion = elegirOpcionMenu(opcionesMenu, titulo);

			switch (opcion) {
			case 1:
				Socio socio = ingresarSocio(sc);
				if (socio == null) {
					System.out.println("Socio no encontrado");
				} else {

					Amarre amarre = socio.buscarAmarreLibre();
					if (amarre != null) {
						System.out.println("Ingrese numero de embarcacion: ");
						String numeroEmbarcacion = sc.nextLine();
						Embarcacion embarcacion = socio.buscarEmbarcacion(numeroEmbarcacion);
						if (embarcacion != null) {
							asignarEmbarcacionAmarre(embarcacion, socio, amarre);
						} else {
							System.out.println("Embarcacion no encontrada");
						}
					} else {
						System.out.println("Todos los amarres estan ocupados");
					}
				}
				break;
			case 2:
				socio = ingresarSocio(sc);
				if (socio != null) {
					System.out.println("Ingrese numero de amarre: ");
					int numeroAmarre = Integer.parseInt(sc.nextLine());
					Amarre amarre = BaseDeDatos.buscarAmarre(numeroAmarre);
					if (amarre != null) {
						if (amarre.isOcupado()) {
							System.out.println("Amarre ocupado");
						} else {
							registrarCompraAmarre(socio, amarre);
							System.out.println("Amarre registrado");
						}
					} else {
						System.out.println("Amarre no encontrado");
					}
				}
				break;
			case 3:
				BaseDeDatos.mostrarEmbarcacionesDeSocios();
				break;
			case 4:
				socio = ingresarSocio(sc);
				if (socio == null) {
					System.out.println("Socio no encontrado");
				} else {

					System.out.print("Ingrese la matrícula: ");
					String matricula = sc.nextLine();

					System.out.print("Ingrese el nombre: ");
					String nombre = sc.nextLine();

					System.out.print("Ingrese el tipo: ");
					String tipo = sc.nextLine();

					System.out.print("Ingrese la manga: ");
					double manga = Double.parseDouble(sc.nextLine());

					System.out.print("Ingrese la eslora: ");
					double eslora = Double.parseDouble(sc.nextLine());
					if (BaseDeDatos.existeEmbarcacionEnSocio(matricula) == null) {
						Embarcacion e = new Embarcacion(matricula, nombre, tipo, new Dimension(manga, eslora));
						socio.agregarEmbarcacion(e);
						System.out.println("La embarcacion ha sido dada de alta");
					} else {
						System.out.println("La embarcacion con matricula " + matricula + " habia sido dada de alta");
					}
				}
				break;
			case 5:
				Empleado empleado = ingresarEmpleado(sc);
				if (empleado != null) {
					System.out.print("Ingrese la zona a la que desea asignar al empleado: ");
					String zonaLetra = sc.nextLine();
					Zona zonaDesignada = BaseDeDatos.existeZona(zonaLetra);
					if (zonaDesignada != null) {
						empleado.agregarZonaAsignada(zonaDesignada);
						zonaDesignada.agregarEmpleado(empleado);
						System.out.println("Se asigno la zona y el empleado mutuamente");
					} else {
						System.out.println("La zona " + zonaLetra + " no existe");
					}
				} else {
					System.out.println("Empleado no encontrado");

				}
				break;
			case 6:
				empleado = ingresarEmpleado(sc);
				if (empleado != null) {
					System.out.println("Ingrese el numero de embarcacion: ");
					String matricula = sc.nextLine();
					Embarcacion embarcacion = BaseDeDatos.existeEmbarcacionEnSocio(matricula);
					if (embarcacion != null) {
						empleado.agregarEmbarcacion(embarcacion);
						embarcacion.getAmarreAsignado().agregarEmpleado(empleado);
						System.out.println("Se asigno la embarcacion al empleado");
					} else {
						System.out.println("Embarcacion no encontrada");
					}
				} else {
					System.out.println("Empleado no encontrado");
				}
				break;
			}

		} while (opcion != opcionesMenu.size());
		System.out.println("Saliendo del menu de Administrador....");
	}

	private Empleado ingresarEmpleado(Scanner sc) {
		Empleado empleado = null;
		System.out.println("Ingrese numero de empleado: ");
		int dniempleado = Integer.parseInt(sc.nextLine());
		Usuario usuario = BaseDeDatos.buscarUsuario(dniempleado);
		if (usuario != null && usuario instanceof Empleado) {
			empleado = (Empleado) usuario;
		}
		return empleado;
	}

	private Socio ingresarSocio(Scanner sc) {
		Socio socio = null;
		System.out.println("Ingrese numero de socio: ");
		int dniSocio = Integer.parseInt(sc.nextLine());
		Usuario usuario = BaseDeDatos.buscarUsuario(dniSocio);
		if (usuario != null && usuario instanceof Socio) {
			socio = (Socio) usuario;
		}
		return socio;
	}
}
