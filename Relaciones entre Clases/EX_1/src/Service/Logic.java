package Service;

import Entidades.Perro;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Scanner;

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
public class Logic {

    private Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    //CREAMOS UNA LISTA DE LOS ENUMS.
    private ArrayList<Perro> dogs = new ArrayList();
    private Persona somebody = new Persona();

    public void all() {
        dogs.add(Perro.PEPE);
        dogs.add(Perro.SULTAN);
        dogs.add(Perro.BELLA);
        dogs.add(Perro.WILSON);
        do {
            //PREGUNTAMOS QUE PERSONA QUIERE ADOPTAR.
            crearPersona();
            //LE BUSCAMOS UN MASCOTA.
            adopcionMascota();
            //MOSTRAMOS LA ADOPCION.
            mostrarAdopcion();
            System.out.println("ANYONE ELSE?(Y/N)");
        } while ("Y".equalsIgnoreCase(sc.next()));
    }

    public void crearPersona() {
        //LE PEDIMOS LOS DATOS A LA PERSONA QUE QUIERE ADOPTAR.
        System.out.println("WHAT IS YOUR NAME?");
        somebody.setNombre(sc.next());
        System.out.println("SURNAME");
        somebody.setApellido(sc.next());
        System.out.println("AGE");
        somebody.setEdad(sc.nextInt());
        System.out.println("DNI");
        somebody.setDni(sc.nextInt());
    }

    public void adopcionMascota() {
        //CREAMOS UN BOOLEAN PARA VERIFICAR SI LA MASCOTA EXISTE.
        boolean flag = true;
        String ans = "";
        //LE PEDIMOS QUE ELIGA UN PERRO.
        System.out.println("CHOSE ONE NAME OF THE LIST");
        do {
            //MOSTRAMOS EL ENUM DE LOS PERROS ADOPTABLES.
            System.out.println("PODES ADOPTAR A:");
            mostrarAdoptables();
            String chosenDog = sc.next();
            //RECORREMOS EL ARRAY CON TODAS LAS MASCOTAS.
            for (Perro mascota : dogs) {
                //USAMOS EL IF PARA VALIDAR QUE LA OPCION ESTE EN LA LISTA.
                if (mascota.name().equalsIgnoreCase(chosenDog)) {
                    //AÑADIMOS LA MASCOTA A LA PERSONA 
                    somebody.setMascota(mascota);
                    //DELETEAMOS AL PERRO DE LA ARRAYLIST DE PERROS ADOPTABLES.
                    dogs.remove(mascota);
                    //VALIMOS QUE EL PERRO EXISTE.
                    flag = false;
                    System.out.println("ADOPTADO");
                    break;
                }
            }

            if (flag) {
                System.out.println(chosenDog + " DOESN'T EXIST");
                System.out.println("DO YOU WANT TO CONTINUE? (Y/N)");
                ans = sc.next();
            }

        } while ("Y".equalsIgnoreCase(ans) || flag);

    }

    //MOSTRAMOS LAS MASCOTAS ADOPTABLES.
    public void mostrarAdoptables() {
        for (Perro aux : dogs) {
            System.out.println(aux.name() + " " + aux.toString());
        }
    }

    //MOSTRAMOS LAS PERSONAS CON SU MASCOTA.
    public void mostrarAdopcion() {
        System.out.println(somebody.getNombre() + " HAS ADOPTED TO " + somebody.getMascota().name());
    }

}
