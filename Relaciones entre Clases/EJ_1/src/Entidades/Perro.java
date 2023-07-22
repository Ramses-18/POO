package Entidades;

/**
     * @param args the command line arguments
     *
     * Realizar un programa para que una Persona pueda adoptar un Perro.
     *
     * Vamos a contar de dos clases.
     *
     * Perro, que tendrá como atributos: nombre, raza, edad y tamaño;
     * Persona con atributos: nombre, apellido, edad, documento y Perro.
     *
     * Ahora deberemos en el main crear dos Personas y dos Perros.
     *
     * Después, vamos a tener que pensar la lógica necesaria para asignarle a
     * cada Persona un Perro y por ultimo, mostrar desde la clase Persona, la
     * información del Perro y de la Persona.
     * 
*/

public class Perro {
    private String name;
    private String raza;
    private Integer edad;
    private String tamanio;
    
    public Perro() {
    }

    public Perro(String name, String raza, Integer edad, String tamanio) {
        this.name = name;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    
    @Override
    public String toString() {
        return "Perro{" + "name=" + name + ", raza=" + raza + ", edad=" + edad + ", tamanio=" + tamanio + '}';
    }

    
    
    
}
