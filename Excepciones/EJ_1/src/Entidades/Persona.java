package Entidades;

/**
 *
 * @author tomyv
 * Realizar una clase llamada Persona en el paquete de entidades que
tengan los siguientes atributos: nombre, edad, sexo (‘H’ para hombre, ‘M’
para mujer, ‘O’ para otro), peso y altura. Si desea añadir algún otro
atributo, puede hacerlo. Agregar constructores, getters y setters.
 */
public class Persona {
    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private double altura;
    private long dni;
    private String pais;
    

    public Persona() {
    }

    
    public Persona(String nombre, int edad,String  sexo, double peso, double altura, long dni, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.dni = dni;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public long getDni() {
        return dni;
    }

    public String getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
