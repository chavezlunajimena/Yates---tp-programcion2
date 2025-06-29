
package yachtclub;


public abstract class Usuario {// es un metodo Abstracto de socio-empleado-admin
    private String nombre;
    private int codigo;
    private int dni;
    int telefono;
    private Direccion direccion;

    public Usuario(String nombre, int codigo, int dni, int telefono, Direccion direccion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: " + direccion);
    }

}
