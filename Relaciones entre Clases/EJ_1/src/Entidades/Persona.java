package Entidades;

/**
     * @param args the command line arguments
     *
     * Realizar un programa para que una Persona pueda adoptar un Perro.
     *
     * Vamos a contar de dos clases.
     *
     * Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase
     * Persona con atributos: nombre, apellido, edad, documento y Perro.
     *
     * Ahora deberemos en el main crear dos Personas y dos Perros.
     *
     * Después, vamos a tener que pensar la lógica necesaria para asignarle a
     * cada Persona un Perro y por ultimo, mostrar desde la clase Persona, la
     * información del Perro y de la Persona.
     * 
*/
public class Persona {
    private String name;
    private String surname;
    private Integer age;
    private Integer dni;
    private Perro dog;

    public Persona() {
    }

    public Persona(String name, String surname, Integer age, Integer dni) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
    }
    

    public Persona(String name, String surname, Integer age, Integer dni, Perro dog) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Perro getDog() {
        return dog;
    }

    public void setDog(Perro dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", dni=" + dni + ", dog=" + dog + '}';
    }

    

    
    
    
}
