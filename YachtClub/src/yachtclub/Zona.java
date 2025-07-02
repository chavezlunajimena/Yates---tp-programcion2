
package yachtclub;

import java.util.ArrayList;

public class Zona {
	private String letra;
	private String tipoDeBarco;
	private final double profundidad;
	private double anchoAmarre;
	private ArrayList<Amarre> amarres;
	private ArrayList<Empleado> empleados;

	public Zona(String letra, String tipoDeBarco, double anchoAmarre) {
		setLetra(letra);
		setTipoDeBarco(tipoDeBarco);
		this.profundidad = 7;
		setAnchoAmarre(anchoAmarre);
		this.amarres = new ArrayList<>();
		this.empleados = new ArrayList<>();
	}

	public String getLetra() {
		return letra;
	}

	private void setLetra(String letra) {
		this.letra = letra;
	}

	private void setTipoDeBarco(String tipoDeBarco) {
		this.tipoDeBarco = tipoDeBarco;
	}

	private void setAnchoAmarre(double anchoAmarre) {
		this.anchoAmarre = anchoAmarre;
	}

	public String getTipoDeBarco() {
		return tipoDeBarco;
	}

	public double getProfundidad() {
		return profundidad;
	}

	public double getAncho() {
		return anchoAmarre;
	}

	@Override
	public String toString() {
		return "Zona " + letra + " | Tipo barcos: " + tipoDeBarco + " | Profundidad: " + profundidad
				+ "m | Ancho amarre: " + anchoAmarre + "m";
	}

	boolean mismaLetra(String letra) {
		return this.letra.equals(letra);
	}

	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}

	public int contarBarcosAsignadosPorEmpleado(Empleado empleado) {
		int cant = 0;
		for (Amarre amarre : amarres) {
			if (amarre.isOcupado() && amarre.mismoEncargado(empleado)) {
				cant++;
			}
		}
		return cant;
	}

	public void verEmbarcacionesAsignadas(Empleado empleado) {
		boolean tieneAmarre = false;
		for (Amarre amarre : amarres) {
			if (amarre.isOcupado() && amarre.mismoEncargado(empleado)) {
				System.out.println(amarre);
				tieneAmarre = true;
			}
		}
		if (!tieneAmarre) {
			System.out.println("No tiene embarcaciones asignadas");
		}
	}

	public void agregarAmarre(Amarre amarreNuevo) {
		this.amarres.add(amarreNuevo);
		
	}
}
