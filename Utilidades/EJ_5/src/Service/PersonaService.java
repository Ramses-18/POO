package Service;

import Entidades.Persona;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tomyv
 *
 * 
 */
public class PersonaService {

    //Método crearPersona que pida al usuario Nombre y fecha de nacimiento de la persona a crear.
    //Retornar el objeto Persona creado.
    public Persona crearPersona() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("What is your name");
        String name = sc.next();
        System.out.println("What day were you born");
        int day = sc.nextInt();
        System.out.println("What month?");
        int month = sc.nextInt();
        System.out.println("What year?");
        int year = sc.nextInt();
        Date d = new Date(year - 1900, month - 1, day);
        return new Persona(name, d);
    }

    //Método calcularEdad que calcule la edad del usuario utilizando el atributo de
    //fecha de nacimiento y la fecha actual.
    public int calcularEdad(Persona p) {
        Date Actual = new Date();
        return Actual.getYear() - p.getNac().getYear();
    }

    //Método menorQue recibe como parámetro una Persona y una edad. Retorna true si la persona es menor que la edad
    //consultada o false en caso contrario.
    public boolean menorQue(Persona p, int age) {
        return calcularEdad(p) > age;
    }
    
    //Método mostrarPersona que muestra la información de la persona deseada.
    public void mostrarPersona(Persona p){
        System.out.println( p.getName().toUpperCase() + " WAS BORN " + p.getNac());
    }
}
