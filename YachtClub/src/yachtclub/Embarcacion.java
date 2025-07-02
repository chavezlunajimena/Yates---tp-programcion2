
package yachtclub;


public class Embarcacion{
    
    protected String matricula;
    protected String nombre;
    protected String tipo; 
    protected Dimension dimension;
    protected Amarre amarreAsignado;

    public Embarcacion(String matricula, String nombre, String tipo, Dimension dimension) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tipo = tipo;
        this.dimension = dimension;
        this.amarreAsignado = null;
    }
    public void setAmarreAsignado(Amarre amarreAsignado) {
        this.amarreAsignado = amarreAsignado;
    }

    public Amarre getAmarreAsignado() {
        return amarreAsignado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }


    @Override
    public String toString() {
        return "Embarcacion: " + nombre + " | Matricula: " + matricula + " | Tipo: " + tipo + " | Dimension: " + dimension;
    }
	public boolean mismaMatricula(String numeroEmbarcacion) {
		return this.matricula.equals(numeroEmbarcacion);
	}

    
    
}
