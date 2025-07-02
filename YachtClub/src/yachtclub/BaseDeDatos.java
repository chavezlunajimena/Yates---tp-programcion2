package yachtclub;

import java.time.LocalDate;
import java.util.ArrayList;

public class BaseDeDatos {

	private static ArrayList<Usuario> usuarios;
	private static ArrayList<Zona> zonas;
	private static ArrayList<Amarre> amarres;
	private static int cantAmarres = 0;

	public static Embarcacion existeEmbarcacionEnSocio(String matricula) {
		int i = 0;
		Socio socio;
		Embarcacion embarcacion = null;
		while (i < usuarios.size() && embarcacion == null) {
			if (usuarios.get(i) instanceof Socio) {
				socio = (Socio) usuarios.get(i);
				embarcacion = socio.buscarEmbarcacion(matricula);
			}
			i++;

		}
		return embarcacion;
	}

	public static void mostrarEmbarcacionesDeSocios() {
		Socio socio;
		for (Usuario u : usuarios) {
			if (u instanceof Socio) {
				socio = (Socio) u;
				socio.verEmbarcaciones();
			}
		}
	}

	public static Zona existeZona(String zonaLetra) {
		Zona zonaEncontrada = null;
		int i = 0;
		while (i < zonas.size() && zonaEncontrada == null) {
			if (zonas.get(i).mismaLetra(zonaLetra)) {
				zonaEncontrada = zonas.get(i);
			}
			i++;
		}
		return zonaEncontrada;
	}

	public BaseDeDatos() {
		zonas = new ArrayList<>();
		amarres = new ArrayList<>();
		usuarios = new ArrayList<>();

	}

	private void agregarZonaALista(Zona zona, String letra) {
		Zona zonaBuscada = buscarZona(letra);
		if (zonaBuscada == null) {
			zonas.add(zona);
		} else {
			System.out.println("Zona ya registrada");
		}
	}

	private Zona buscarZona(String letra) {
		Zona zonaEncontrada = null;
		int i = 0;
		while (i < zonas.size() && !zonas.get(i).mismaLetra(letra)) {
			i++;
		}
		if (i < zonas.size()) {
			zonaEncontrada = zonas.get(i);
		}
		return zonaEncontrada;
	}

	public void agregarZona(String letra, String tipoDeBarco, double profundidad, double anchoAmarre) {
		Zona zonaNueva = new Zona(letra, tipoDeBarco, anchoAmarre);
		this.agregarZonaALista(zonaNueva, letra);
	}

	public void agregarAmarre(int numero, boolean servicioMantenimiento, int contadorLuz, int contadorAgua,String zona) {
		if (cantAmarres != 2) {
			Amarre amarreNuevo = new Amarre(numero, servicioMantenimiento, contadorLuz, contadorAgua);
			amarres.add(amarreNuevo);
			Zona zonaEncontrada = this.buscarZona(zona);
			zonaEncontrada.agregarAmarre(amarreNuevo);
			cantAmarres++;
		} else {
			System.out.println("Límite de amarres alcanzado");
		}
	}

	public void agregarUsuario(String nombre, int codigo, int dni, int telefono, String calle, int numeroPuerta,
			String localidad) {
		Usuario usuarioNuevo = new Administrador(nombre, codigo, dni, telefono,
				new Direccion(calle, numeroPuerta, localidad));
		this.agregarUsuarioALista(usuarioNuevo, dni);
	}

	public void agregarUsuario(String nombre, int codigo, int dni, int telefono, String calle, int numeroPuerta,
			String localidad, LocalDate fechaIngreso) {
		Usuario usuarioNuevo = new Socio(nombre, codigo, dni, telefono, new Direccion(calle, numeroPuerta, localidad),
				fechaIngreso);
		this.agregarUsuarioALista(usuarioNuevo, dni);
	}

	public void agregarUsuario(String nombre, int codigo, int dni, int telefono, String calle, int numeroPuerta,
			String localidad, String especialidad) {
		Usuario usuarioNuevo = new Empleado(nombre, codigo, dni, telefono,
				new Direccion(calle, numeroPuerta, localidad), especialidad);
		this.agregarUsuarioALista(usuarioNuevo, dni);
	}

	private void agregarUsuarioALista(Usuario usuario, int dni) {
		Usuario usuarioBuscado = buscarUsuario(dni);
		if (usuarioBuscado == null) {
			usuarios.add(usuario);
		} else {
			System.out.println(dni + " ya se encuentra registrado");
		}
	}

	public static Usuario buscarUsuario(int dni) {
		Usuario usuarioEncontrado = null;
		int i = 0;
		while (i < usuarios.size() && !usuarios.get(i).mismoDni(dni)) {
			i++;
		}
		if (i < usuarios.size()) {
			usuarioEncontrado = usuarios.get(i);
		}
		return usuarioEncontrado;
	}

	public static Amarre buscarAmarre(int numero) {
		Amarre amarreEncontrado = null;
		int i = 0;
		while (i < amarres.size() && !amarres.get(i).mismoNumero(numero)) {
			i++;
		}
		if (i < amarres.size()) {
			amarreEncontrado = amarres.get(i);
		}
		return amarreEncontrado;
	}

	public Usuario autenticarUsuario(int dni, int codigo) {
		Usuario usuario = buscarUsuario(dni);
		if (usuario == null || !usuario.mismoCodigo(codigo)) {
			usuario = null;
		}
		return usuario;
	}

	public void mostrarTodosLosUsuarios() {
		System.out.println("-----Lista de usuarios registrados-----");
		for (Usuario u : usuarios) {
			u.mostrarDatos();
		}
	}

}
