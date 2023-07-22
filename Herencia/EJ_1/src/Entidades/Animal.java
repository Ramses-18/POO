package Entidades;

import Enum.Size;
import java.util.Scanner;

/**
 *
 * @author tomyv
 */

public class Animal {

    protected String name;
    protected Integer age;
    protected String type;
    protected String colour;
    protected Size siz;

    public Animal() {
    }

    public Animal(String name, Integer age, String type, String colour, Size siz) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.colour = colour;
        this.siz = siz;
    }

    public Animal createAnimal() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("NAME");
        this.name = sc.next();
        System.out.println("AGE");
        this.age = sc.nextInt();
        System.out.println("BREED");
        this.type = sc.next();
        System.out.println("COLOUR");
        this.colour = sc.next();
        while (this.siz == null) {
            System.out.println("CHOSE ONE SIZE");
            for (Size aux : Size.values()) {
                System.out.println(aux);
            }
            String size = sc.next();
            for (Size aux : Size.values()) {
                if (aux.toString().toUpperCase().equals(size.toUpperCase())) {
                    this.siz = aux;
                }
            }
        }
        return new Animal(name, age, type, colour, siz);
    }

    @Override
    public String toString() {
        return "Animal{" + " Name: " + name + ", Age: " + age + ", Type: " + type
                + ", Colour: " + colour + ", Size: " + siz + '}';
    }

}
