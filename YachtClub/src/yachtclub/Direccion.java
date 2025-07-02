
package yachtclub;

class Direccion {
	private String calle;
	private int numero;
	private String ciudad;

	public Direccion(String calle, int numero, String ciudad) {
		this.setCalle(calle);
		this.setNumero(numero);
		this.setCiudad(ciudad);
	}

	private void setCalle(String calle) {
		this.calle = calle;
	}

	private void setNumero(int numero) {
		if (numero > 0)
			this.numero = numero;
		else
			this.numero = 0;
	}

	private void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return calle + " " + numero + ", " + ciudad;
	}

}
