
package yachtclub;


public class Amarre {
    private int numero;
    private boolean servicioMantenimiento;
    private int contadorLuz;
    private int contadorAgua;
    private Embarcacion embarcacion;
    private Empleado empleadoEncargado;
    

    public Amarre(int numero, boolean servicioMantenimiento,int contadorLuz, int contadorAgua,Empleado empleadoEncargado) {
        this.numero = numero;
        this.servicioMantenimiento = servicioMantenimiento;
        this.contadorLuz = contadorLuz;
        this.contadorAgua = contadorAgua;
        this.embarcacion = null;
		this.empleadoEncargado = empleadoEncargado;
    }

    public Amarre(int numero, boolean servicioMantenimiento,int contadorLuz, int contadorAgua) {
        this(numero, servicioMantenimiento,contadorLuz,contadorAgua,null);
    }

    
    public void setEmbarcacion(Embarcacion embarcacion) {
	    this.embarcacion = embarcacion;
    }
    
    public int getNumero() {
        return numero;
    }
   
    public boolean isOcupado(){
        return this.embarcacion != null;
    }

    @Override
    public String toString() {
        String texto = "Amarre #" + numero + " | Servicio mantenimiento: " + servicioMantenimiento + " | : "; 
    	if (this.isOcupado()) {
			texto += " Si";
			texto += embarcacion;
    	}
		else
			texto += " No";
        return  texto;
    }

	public boolean mismoNumero(int numero) {
		return this.numero == numero;
	}

	public boolean mismoEncargado(Empleado empleado) {
		return this.empleadoEncargado == empleado;
	}

	public void agregarEmpleado(Empleado empleado) {
		this.empleadoEncargado = empleado;
		
	}
    
    
}
