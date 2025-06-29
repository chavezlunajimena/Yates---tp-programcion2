
package yachtclub;


public abstract class Embarcacion{
    
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
        this.amarreAsignado = null; //empieza sin amarre asignado
    }
// asigno el amarre que resivo por parametro
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

    public String getTipo() {
        return tipo;
    }

    public Dimension getDimension() {
        return dimension;
    }

    //para mostrar los datos cuando piden mostrar las embarcaciones en socio-- mostrar el amarre?
    @Override
    public String toString() {
        return "Embarcacion: " + nombre + " | Matricula: " + matricula + " | Tipo: " + tipo + " | Dimencion: " + dimension;
    }

    
    
}
