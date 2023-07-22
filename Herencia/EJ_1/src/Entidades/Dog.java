/**
     * @param args the command line arguments
     *
     * Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato,
     * Caballo.
     *
     * La clase Animal tendrá como atributos el nombre, alimento, edad y raza
     * del Animal.
     *
     * Crear un método en la clase Animal a través del cual cada clase hija
     * deberá mostrar luego un mensaje por pantalla informando de que se
     * alimenta.
     *
     * Generar una clase Main que realice lo siguiente:
     */
package Entidades;

import Enum.Size;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */
public class Dog extends Animal {

    private Integer fur;
    private Integer tail;

    public Dog() {
    }

    public Dog(Integer fur, Integer tail, String name, Integer age, String type, String colour, Size siz) {
        super(name, age, type, colour, siz);
        this.fur = fur;
        this.tail = tail;
    }

    @Override
    public Animal createAnimal() {
        super.createAnimal(); 
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("SCALE OF FUR");
        this.fur = sc.nextInt();
        System.out.println("SCALE OF TAIL");
        this.tail = sc.nextInt();
        return new Dog(fur,tail,name,age,type,colour, siz);
    }

    @Override
    public String toString() {
        return super.toString() + " Fur: " + fur + " Tail: " + tail;
    }
    
    

}
