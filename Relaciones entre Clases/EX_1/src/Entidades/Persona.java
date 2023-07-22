package Entidades;

/**
 * @param args the command line arguments
 *
 * Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona (EJ_1).
 * Nuestro programa va a tener que contar con muchas personas y muchos perros.
 * El programa deberá preguntarle a cada persona, que perro según su nombre,
 * quiere adoptar. Dos personas no pueden adoptar al mismo perro, si la persona
 * eligió un perro que ya estaba adoptado, se le debe informar a la persona. Una
 * vez que la Persona elige el Perro se le asigna, al final deberemos mostrar
 * todas las personas con sus respectivos perros.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private long dni;
    private boolean ado;
    private Perro mascota;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, long dni, boolean ado, Perro mascota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.ado = ado;
        this.mascota = mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public boolean isAdo() {
        return ado;
    }

    public void setAdo(boolean ado) {
        this.ado = ado;
    }

    public Perro getMascota() {
        return mascota;
    }

    public void setMascota(Perro mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "PersonaMasc{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + ", ado=" + ado + ", mascota=" + mascota + '}';
    }

}
